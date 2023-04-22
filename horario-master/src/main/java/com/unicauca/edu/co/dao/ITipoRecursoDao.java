package com.unicauca.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Tiporecurso;

public interface ITipoRecursoDao extends CrudRepository<Tiporecurso, String> {

	/*SELECT * FROM tiporecurso WHERE	tiporecurso.tiporecurso_rectipo_codigo = 'Amb'*/
	
	@Query("select t from Tiporecurso t where t.tiporecurso.rectipo_codigo = ?1")
	List<Tiporecurso> listarHijosDePadreByCodPadre(String cod_tiporecurso_padre);
	
}
