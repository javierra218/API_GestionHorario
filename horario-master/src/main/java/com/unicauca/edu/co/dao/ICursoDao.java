package com.unicauca.edu.co.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.unicauca.edu.co.model.Curso;

public interface ICursoDao extends CrudRepository<Curso, Long> {
//    @Query("SELECT c from Curso c where c.cur_id LIKE %?1%")
//    List<Curso> findByCur_id(String cur_id);
    
//    @Query(nativeQuery=true,value="SELECT DISTINCT * FROM curso INNER JOIN asignatura ON curso.asignatura_asig_codigo = asignatura.asig_codigo INNER JOIN programa ON asignatura.programa_prog_codigo = programa.prog_codigo INNER JOIN departamento ON programa.departamento_dep_codigo = departamento.dep_codigo INNER JOIN facultad ON departamento.facultad_fac_codigo = facultad.fac_codigo WHERE facultad.fac_codigo = ?1")
//    List<Curso> listaByFacultad(String fac_codigo);
    
    @Query(nativeQuery=true,value="SELECT c.* FROM curso AS c WHERE asignatura_asig_codigo = ?1")
    List<Curso> listaByAsig(String asig_codigo);
}