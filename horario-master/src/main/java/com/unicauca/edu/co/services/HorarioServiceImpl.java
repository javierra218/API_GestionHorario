package com.unicauca.edu.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.edu.co.dao.ICursoDao;
import com.unicauca.edu.co.dao.IHorarioDao;
import com.unicauca.edu.co.dao.IRecursoDao;
import com.unicauca.edu.co.model.Curso;
import com.unicauca.edu.co.model.Horario;
import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.model.dto.HorarioDto;
import com.unicauca.edu.co.model.projection.HorarioProjection;
import com.unicauca.edu.co.response.HorarioResponseRest;

@Service
public class HorarioServiceImpl  implements IHorarioService{
	
	@Autowired
	private IHorarioDao horarioDao;
	
	@Autowired
	private IRecursoDao recursoDao;
	
	@Autowired
	private ICursoDao cursoDao;

	//listar todos los horarios 
	@Override
	@Transactional (readOnly = true)
	public ResponseEntity<HorarioResponseRest> listar() {
		HorarioResponseRest response = new HorarioResponseRest();
		try {
			List<Horario> horario = (List<Horario>) horarioDao.findAll();
			response.getHorarioResponse().setHorario(horario);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HorarioResponseRest> buscarById() {
		// TODO Auto-generated method stub
		return null;
	}

	//metodo para buscar si x recurso(auditorio,salon,sala) esta ocupado un dia a las respectivas horas
	@Override
	public ResponseEntity<HorarioResponseRest> buscarRecursoDiaHIniHFin(Horario horario, Long recurso_id) {
		HorarioResponseRest response = new HorarioResponseRest();
		try {
			List<HorarioProjection> list = horarioDao.buscarRecursoDiaHIniHFin(recurso_id, horario.getHor_dia(), horario.getHor_hora_inicio(), horario.getHor_hora_fin());
			if(list.size() > 0) {
				List<HorarioDto> resHorario = new ArrayList<HorarioDto>();
				for (HorarioProjection h :list) {
					HorarioDto objHorario = new HorarioDto(h.getCur_id(),h.getHor_dia(),h.getHor_hora_inicio(),h.getHor_hora_fin(),h.getRec_id(),h.getCur_id());
					resHorario.add(objHorario);
				}
				response.getHorarioResponse().setHorarioDto(resHorario);
			}
			response.setMetadata("Resopuesta ok", "00", "Respuesta exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.OK) ;
	}

	//metodo para agregar horario un recurso una hinicio, hfin, y el curso
	@Override
	public ResponseEntity<HorarioResponseRest> asigHorarioaRecurso(Horario horario, Long recurso_id, Long curso_id) {
		HorarioResponseRest response = new HorarioResponseRest();
		try {
			List<HorarioProjection> esta = horarioDao.buscarRecursoDiaHIniHFin(recurso_id, horario.getHor_dia() , horario.getHor_hora_inicio(), horario.getHor_hora_fin());
			if(esta.size() > 0) {//validación si ese recurso ya tiene asiganda esa hora inicio y fin
				response.setMetadata("Respuesta nok", "200", "Este recurso ya esta ocupado ese dia y en esas horas");
				return new ResponseEntity<HorarioResponseRest> (response, HttpStatus.BAD_REQUEST);
			}
			String[] hsInicio = horario.getHor_hora_inicio().split(":");
			String[] hsFin = horario.getHor_hora_fin().split(":");
			int hi = Integer.parseInt(hsInicio[0]);
			int hf = Integer.parseInt(hsFin[0]);
			if((hf-hi) != 2) {//validando las horas, si hay mas de dos horas entre ellas, o la hi > hf
				response.setMetadata("Respuesta nok", "300", "hay un error en las horas");
				return new ResponseEntity<HorarioResponseRest> (response, HttpStatus.BAD_REQUEST);
			}
			Optional<Recurso> recurso = recursoDao.findById(recurso_id);
			Optional<Curso> curso = cursoDao.findById(curso_id);
			if(recurso.get().getRec_capmax() < curso.get().getCur_capmax()) {//validando que el recurso tenga la capacidad que el curso requiere
				response.setMetadata("Respuesta nok", "400", "El recurso no cumple con la capacidad maxima que requiere el curso");
				return new ResponseEntity<HorarioResponseRest> (response, HttpStatus.BAD_REQUEST);
			}
			
			horario.setCurso(curso.get());
			horario.setRecurso(recurso.get());
			horarioDao.save(horario);
			response.setMetadata("Resopuesta ok", "00", "Se guardo el horario");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al guardar horario");
			System.err.println(e);
			return new ResponseEntity<HorarioResponseRest> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<HorarioResponseRest> (response, HttpStatus.OK);
	}

	//metodo para desagregar horario un recurso una hinicio, hfin, y el curso
	@Override
	
	public ResponseEntity<HorarioResponseRest> desAsigHorarioaRecurso(Long recurso_id) {
		HorarioResponseRest response = new HorarioResponseRest();
		try {
//			Optional<Horario> horario = horarioDao.findById(recurso_id);
			horarioDao.eliminarHorario(recurso_id);
			response.setMetadata("respuesta ok", "00", "Horario eliminado");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al eliminar");
			e.getStackTrace();
			return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.OK);
	}

	//metodo para listar los horarios de un recurso especifico
	@Override
	public ResponseEntity<HorarioResponseRest> listarHorariosDeRecurso(Long horario_id) {
		HorarioResponseRest response = new HorarioResponseRest();
		try {
			List<HorarioProjection> listaP = horarioDao.listarHorariosDeRecurso(horario_id);
			if(listaP.size() > 0) {
				List<HorarioDto> listaHoDto = new ArrayList<HorarioDto>();
				for (HorarioProjection h : listaP) {
					HorarioDto objHorario = new HorarioDto(h.getCur_id(),h.getHor_dia(),h.getHor_hora_inicio(),h.getHor_hora_fin(),h.getRec_id(),h.getCur_id());
					listaHoDto.add(objHorario);
				}
				response.getHorarioResponse().setHorarioDto(listaHoDto);
			}
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<HorarioResponseRest>(response, HttpStatus.OK) ;
	}

}
