package com.unicauca.edu.co.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.edu.co.model.Curso;
import com.unicauca.edu.co.response.CursoResponseRest;

public interface ICursoService {

    public ResponseEntity<CursoResponseRest> listar();
    public ResponseEntity<CursoResponseRest> buscarById(Long id);

    public ResponseEntity<CursoResponseRest> guardar(Curso curso, String curtip_codigo, String fac_codigo, String ubi_codigo);

    public ResponseEntity<CursoResponseRest> eliminarById(Long id);
    
    public ResponseEntity<CursoResponseRest> cursosPorFacultad(String fac_codigo);
    
    public ResponseEntity<CursoResponseRest> cursosPorAsig(String asig_codigo);
}