package com.unicauca.edu.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.edu.co.dao.ITipoRecursoDao;
import com.unicauca.edu.co.model.Tiporecurso;
import com.unicauca.edu.co.response.TipoRecursoResponseRest;

@Service
public class TipoRecursoServiceImpl implements ITipoRecursoService{

	@Autowired
	private ITipoRecursoDao tiporecursoDao;
	
	
	//metodo para listar todos los tipos de recursos
	@Override
	public ResponseEntity<TipoRecursoResponseRest> listar() {
		TipoRecursoResponseRest response = new TipoRecursoResponseRest();
		try {
			List<Tiporecurso> tiporecurso = (List<Tiporecurso>) tiporecursoDao.findAll();
			response.getTiporecursoResponse().setTiporecurso(tiporecurso);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.OK);
	}
	
	//metodo para buscar tipo de recurso por su codigo
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<TipoRecursoResponseRest> buscarById(String cod_tiporecurso) {
		TipoRecursoResponseRest response = new TipoRecursoResponseRest();
		List<Tiporecurso> list = new ArrayList<>();
		try {
			Optional<Tiporecurso> tiporecurso = tiporecursoDao.findById(cod_tiporecurso);
			
			if(tiporecurso.isPresent()) {
				list.add(tiporecurso.get());
				response.getTiporecursoResponse().setTiporecurso(list);
				response.setMetadata("respuesta ok", "00", "tipo recurso encontrado");
			}else {
				response.setMetadata("respuesta ok", "-1", "tipo recurso no encontrado");
				return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.getStackTrace();
			response.setMetadata("respuesta ok", "-1", "Error al buscar tipo de recurso");
			return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.OK);
	}
	
	//metodo que trae todos los hijos que tiene un padre buscado por cod_pare
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<TipoRecursoResponseRest> listarHijosDePadreByCodPadre(String cod_tiporecurso_padre) {
		TipoRecursoResponseRest response = new TipoRecursoResponseRest();
		List<Tiporecurso> list = new ArrayList<>();
		try {
			list  = tiporecursoDao.listarHijosDePadreByCodPadre(cod_tiporecurso_padre);
			if(list.size() > 0) {
				response.getTiporecursoResponse().setTiporecurso(list);
				response.setMetadata("respuesta ok", "00", "hijo(s) encontrado(s)");
			}else {
				response.setMetadata("respuesta ok", "-1", "No tiene hijos");
				return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setMetadata("respuesta nok", "-1", "Error al buscar los hijos");
			return new ResponseEntity<TipoRecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoRecursoResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TipoRecursoResponseRest> guardar(Tiporecurso tiporecurso, String cod_tiporecurso_padre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TipoRecursoResponseRest> actualizar(Tiporecurso tiporecurso, String cod_tiporecurso_padre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TipoRecursoResponseRest> eliminarById(Long cod_tiporecurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
