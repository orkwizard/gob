package com.gob.webapp.kpi.model;

public class Dependencia {

	private long id;
	private String dependencia;
	private String descripcion;
	
	
	
	public Dependencia(long id, String dependencia, String descripcion) {
		super();
		this.id = id;
		this.dependencia = dependencia;
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString() {
		return "Dependencia [id=" + id + ", dependencia=" + dependencia + ", descripcion=" + descripcion + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
