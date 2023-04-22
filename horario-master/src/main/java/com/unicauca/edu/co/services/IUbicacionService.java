package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Ubicacion;
import com.unicauca.edu.co.response.UbicacionResponseRest;

public interface IUbicacionService {
	
	public ResponseEntity<UbicacionResponseRest> listar();
	public ResponseEntity<UbicacionResponseRest> buscarById(String id);
	public ResponseEntity<UbicacionResponseRest> guardar(Ubicacion ubicacion);
	public ResponseEntity<UbicacionResponseRest> actualizar(Ubicacion ubicacion, String id);
	public ResponseEntity<UbicacionResponseRest> eliminarById(String id);

}
