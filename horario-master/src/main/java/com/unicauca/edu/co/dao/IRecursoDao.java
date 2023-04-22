package com.unicauca.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Recurso;
import com.unicauca.edu.co.model.projection.RecursoProjection;

public interface IRecursoDao extends CrudRepository<Recurso, Long> {

	@Query("SELECT r from Recurso r where r.rec_codigo LIKE %?1%")
	List<Recurso> findByRec_codigo(String rec_codigo);
	
	//consulta que trae los recursos de una facultad iguales a sala salon auditorio
	@Query(nativeQuery = true, value= "SELECT r.* FROM recurso AS r WHERE r.facultad_fac_codigo = ?1 AND (r.tiporecurso_rectipo_codigo = 'Sala' OR r.tiporecurso_rectipo_codigo = 'Salon' OR r.tiporecurso_rectipo_codigo = 'Auditorio') ")
	List<Recurso> recursosPorFacultadAudiSalaSalon (String fac_codigo);
	
	//consulta que trae los recursos de una facultad diferentes a sala salon auditorio
	@Query(nativeQuery=true, value= "SELECT r.* FROM recurso AS r WHERE r.facultad_fac_codigo = 'FIET' AND r.tiporecurso_rectipo_codigo <> 'Salon' AND r.tiporecurso_rectipo_codigo <> 'Auditorio' AND r.tiporecurso_rectipo_codigo <> 'Sala' ")
	List<Recurso> recursosPorFacultadDiferenteAudiSalaSalon(String fac_codigo);
	
	//consulta que lista los recursos 
	@Query(nativeQuery= true, value = "SELECT r.rec_id, r.rec_codigo, f.fac_codigo, r.rec_descripcion, r.rec_capmax, r.rec_nombre, tr.rectipo_codigo, u.ubi_codigo "
			+ " FROM recurso AS r INNER JOIN facultad AS f ON r.facultad_fac_codigo = f.fac_codigo "
			+ " INNER JOIN tiporecurso AS tr ON r.tiporecurso_rectipo_codigo = tr.rectipo_codigo "
			+ " INNER JOIN ubicacion AS u ON f.ubicacion_ubi_codigo = u.ubi_codigo AND r.ubicacion_ubi_codigo = u.ubi_codigo ")
	List<RecursoProjection> listarRecursos();
}