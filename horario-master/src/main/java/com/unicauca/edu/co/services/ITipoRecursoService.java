package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Tiporecurso;
import com.unicauca.edu.co.response.TipoRecursoResponseRest;

public interface ITipoRecursoService {
	
	public ResponseEntity<TipoRecursoResponseRest> listar();
	public ResponseEntity<TipoRecursoResponseRest> buscarById(String cod_tiporecurso);
	public ResponseEntity<TipoRecursoResponseRest> guardar(Tiporecurso tiporecurso, String cod_tiporecurso_padre);
	public ResponseEntity<TipoRecursoResponseRest> actualizar(Tiporecurso tiporecurso, String cod_tiporecurso_padre);
	public ResponseEntity<TipoRecursoResponseRest> eliminarById(Long cod_tiporecurso);
	public ResponseEntity<TipoRecursoResponseRest> listarHijosDePadreByCodPadre(String cod_tiporecurso_padre);
	
}
