package com.gob.app.kpis.AppKPIS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DependenciaService {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	 public List<Dependencia> findAll(){
		   return jdbcTemplate.query(
		            "SELECT idDependencia, Dependencia, Descripcion FROM Dependencia",
	                (rs, rowNum) -> new Dependencia(rs.getInt("idDependencia"),
	                rs.getString("Dependencia"), rs.getString("Descripcion")));
	 }
	 
	 public void update(Dependencia d){
		 jdbcTemplate.update(
		            "UPDATE Dependencia SET Dependencia=?, Descripcion=? WHERE idDependencia=?",
		            d.getDependencia(), d.getDescripcion(), d.getIdDependencia());
	 }
}
