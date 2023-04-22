package com.unicauca.edu.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.edu.co.dao.IFacultadDao;
import com.unicauca.edu.co.dao.IRecursoDao;
import com.unicauca.edu.co.dao.ITipoRecursoDao;
import com.unicauca.edu.co.model.Facultad;
import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.model.Tiporecurso;
import com.unicauca.edu.co.response.RecursoResponseRest;

@Service
public class RecursoServiceImpl implements IRecursoService{
	
	@Autowired
	private IRecursoDao recursoDao;
	
	@Autowired
	private ITipoRecursoDao tipoRecursoDao;
	
	@Autowired
	private IFacultadDao facultadDao;

	//listar todos los recursos
	@Override
	@Transactional (readOnly = true)
	public ResponseEntity<RecursoResponseRest> listar() {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			List<Recurso> lis = (List<Recurso>) recursoDao.findAll();
			response.getRecursoResponse().setRecurso(lis);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
		}catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	//buscar por id 
	@Override
	public ResponseEntity<RecursoResponseRest> buscarById(Long id) {
		RecursoResponseRest response = new RecursoResponseRest();
		List<Recurso> list = new ArrayList<>();
		try {
			
			Optional<Recurso> recurso = recursoDao.findById(id);
			if(recurso.isPresent()) {
				list.add(recurso.get());
				response.getRecursoResponse().setRecurso(list);
				response.setMetadata("Respuesta ok", "00", "Recurso encontrado");
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso no encontrado");
				return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}
	
	//buscar recursos con cod_recurso
	@Override
	@Transactional (readOnly = true)
	public ResponseEntity<RecursoResponseRest> buscarByRec_codigo(String rec_codigo) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			List<Recurso> recurso = recursoDao.findByRec_codigo(rec_codigo);
			if(!recurso.isEmpty()) {
				response.getRecursoResponse().setRecurso(recurso);
				response.setMetadata("Respuesta ok", "00", "Recurso Encontrado");
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso no encontrado");
				return new ResponseEntity<RecursoResponseRest>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar");
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response,HttpStatus.OK);
	}

	//guardar recurso
	@Override
	public ResponseEntity<RecursoResponseRest> guardar(Recurso recurso, String rectipo_codigo, String fac_codigo) {
		RecursoResponseRest response = new RecursoResponseRest();
		List<Recurso> list = new ArrayList<>();
		try {
			
			Optional<Tiporecurso> tiporecurso = tipoRecursoDao.findById(rectipo_codigo);
			Optional<Facultad> facultad = facultadDao.findById(fac_codigo);
			
			if(tiporecurso.isPresent() && facultad.isPresent() ) {
				recurso.setTiporecurso(tiporecurso.get());
				recurso.setFacultad(facultad.get());;
				recurso.setUbicacion(facultad.get().getUbicacion());
			}else {
				response.setMetadata("respuesta ok", "-1" ,"Tipo recurso, Facultad, Ubicacion no se encuentra");
				return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			
			Recurso recursoSave = recursoDao.save(recurso);
			if(recursoSave!= null) {
				list.add(recursoSave);
				response.getRecursoResponse().setRecurso(list);
				response.setMetadata("Respuesta ok", "00", "Recurso Guardada");
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso No Guardada");
				return new ResponseEntity<RecursoResponseRest> (response,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consular");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	//actualizar recurso
	@Override
	public ResponseEntity<RecursoResponseRest> actualizar(Recurso recurso, Long idRecurso,String rectipo_codigo, String fac_codigo) {
		RecursoResponseRest response =  new RecursoResponseRest();
		List<Recurso> list = new  ArrayList<>();
		try {
			Optional<Recurso> recursoSearch = recursoDao.findById(idRecurso);
			Optional<Tiporecurso> tiporecurso = tipoRecursoDao.findById(rectipo_codigo);
			Optional<Facultad> facultad = facultadDao.findById(fac_codigo);
			if(tiporecurso.isPresent() && facultad.isPresent()) {
				recurso.setTiporecurso(tiporecurso.get());
				recurso.setFacultad(facultad.get());;
				recurso.setUbicacion(facultad.get().getUbicacion());
			}else {
				response.setMetadata("respuesta ok", "-1" ,"Tipo recurso, Facultad, Ubicacion no se encuentra");
				return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			if(recursoSearch.isPresent()) {
				recursoSearch.get().setRec_codigo(recurso.getRec_codigo());
				recursoSearch.get().setRec_capmax(recurso.getRec_capmax());
				recursoSearch.get().setRec_nombre(recurso.getRec_nombre());
				recursoSearch.get().setRec_descripcion(recurso.getRec_descripcion());
				recursoSearch.get().setFacultad(facultad.get());
				recursoSearch.get().setTiporecurso(tiporecurso.get());
				recursoSearch.get().setUbicacion(facultad.get().getUbicacion());

				
				Recurso recusoUpdate = recursoDao.save(recursoSearch.get());
				if(recusoUpdate != null) {
					list.add(recusoUpdate);
					response.getRecursoResponse().setRecurso(list);
					response.setMetadata("Respuesta ok", "00", "Recurso Actualizado");
				}else {
					response.setMetadata("Respuesta nok", "-1", "Recurso no Actualizado");
					return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.BAD_REQUEST);
				}
			}else {
				response.setMetadata("Respuesta nok", "-1", "Recurso No encontrado");
				return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al actualizar");
			return new ResponseEntity<RecursoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest> (response, HttpStatus.OK);
	}

	//eliminar dela bd un recurso
	@Override
	public ResponseEntity<RecursoResponseRest> eliminarById(Long id) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			recursoDao.deleteById(id);
			response.setMetadata("Respuesta ok", "00", "Recurso eliminado");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al eliminar");
			e.getStackTrace();
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.OK);
	}

	//Asignar recursos a un recurso
	@Override
	public ResponseEntity<RecursoResponseRest> asignarRecursoaRecurso(Long rec_codigo, Long rec_codigo2) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			Optional<Recurso> recursoPadre = recursoDao.findById(rec_codigo);
			Optional<Recurso> recursoHijo = recursoDao.findById(rec_codigo2);
			recursoHijo.get().setEstado(true);
			recursoPadre.get().agregarRecursos(recursoHijo.get());
			List<Recurso> list = new ArrayList<Recurso>();
			recursoDao.save(recursoPadre.get());
			list.add(recursoPadre.get());
			response.getRecursoResponse().setRecurso(list);
			response.setMetadata("Respuesta ok", "00", "Recurso asignado");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al asignar recursos");
			return new ResponseEntity<RecursoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.OK);
	}
	
	//Desasignar recursos a un recurso
	@Override
	public ResponseEntity<RecursoResponseRest> desasignarRecursoaRecurso(Long rec_codigo, Long rec_codigo2) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			Optional<Recurso> recursoPadre = recursoDao.findById(rec_codigo);
			Optional<Recurso> recursoHijo = recursoDao.findById(rec_codigo2);
			recursoHijo.get().setEstado(false);
			recursoPadre.get().getRecursoHijo().remove(recursoHijo.get());
			recursoDao.save(recursoPadre.get());
			response.setMetadata("Respuesta ok ", "00", "Se desasigno el recurso");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "ocurrio un erro al querer desasignar");
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.OK);
	}
	
	//Recursos Auditorio Sala Salon por facultad 
	@Override
	public ResponseEntity<RecursoResponseRest> recursosPorFacultadAudiSalaSalon (String fac_codigo) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			List<Recurso> list = recursoDao.recursosPorFacultadAudiSalaSalon(fac_codigo);
			response.getRecursoResponse().setRecurso(list);
			response.setMetadata("Respuesta ok", "00", "Recursos encontrados");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al buscar recursos Auditorio Sala Salon");
			return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.OK);
	}

	//Recursos diferentes a Auditorio sala salon por facultad que estes disponibles 
	@Override
	public ResponseEntity<RecursoResponseRest> recursosPorFacultadDiferenteAudiSalaSalon(String fac_codigo) {
		RecursoResponseRest response = new RecursoResponseRest();
		try {
			List<Recurso> list = recursoDao.recursosPorFacultadDiferenteAudiSalaSalon(fac_codigo);
			response.getRecursoResponse().setRecurso(list);
			response.setMetadata("Respuesta ok", "00", "Recursos encontrados");
		} catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al buscar recursos diferentes Auditorio sala salon");
			return new ResponseEntity<RecursoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RecursoResponseRest>(response, HttpStatus.OK);
	}

}
