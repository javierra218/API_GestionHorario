package com.unicauca.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Asignatura;

public interface IAsignaturaDao extends CrudRepository<Asignatura, String> {
	
	@Query(nativeQuery = true, value=" SELECT a.* "
			+ " FROM asignatura AS a INNER JOIN programa AS p ON a.programa_prog_codigo = p.prog_codigo INNER JOIN departamento AS d ON p.departamento_dep_codigo = d.dep_codigo "
			+ " INNER JOIN facultad AS f ON d.facultad_fac_codigo = f.fac_codigo "
			+ " WHERE f.fac_codigo = ?1 ")
	List<Asignatura> listaPorFacultad(String fac_codigo);
	
}
