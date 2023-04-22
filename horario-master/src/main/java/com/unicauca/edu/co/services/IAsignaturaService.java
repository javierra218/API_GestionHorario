package com.unicauca.edu.co.services;


import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.response.AsignaturaResponseRest;

public interface IAsignaturaService {
	
	public ResponseEntity<AsignaturaResponseRest> listaAsignaturaPorFacultad(String fac_codigo);

}
