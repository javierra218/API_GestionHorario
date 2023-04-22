package com.unicauca.edu.co.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicauca.edu.co.dao.IAsignaturaDao;
import com.unicauca.edu.co.model.Asignatura;
import com.unicauca.edu.co.response.AsignaturaResponseRest;

@Service
public class AsignaturaServiceImpl implements  IAsignaturaService{
	
	@Autowired
    private IAsignaturaDao asignaturaDao;

       
   //Asignatura por Facultad
    
  	@Override
  	public ResponseEntity<AsignaturaResponseRest> listaAsignaturaPorFacultad(String fac_codigo) {
  		AsignaturaResponseRest response = new AsignaturaResponseRest();
  		try {
  			List<Asignatura> list = asignaturaDao.listaPorFacultad(fac_codigo);
  			response.getAsignaturaResponse().setAsignatura(list);
  			response.setMetadata("Respuesta ok", "00", "Asignaturas encontradas");
  		} catch (Exception e) {
  			response.setMetadata("Respuesta nok", "-1", "Error al buscar Asignaturas");
  			return new ResponseEntity<AsignaturaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  		}
  		return new ResponseEntity<AsignaturaResponseRest>(response, HttpStatus.OK);
  	}

}
