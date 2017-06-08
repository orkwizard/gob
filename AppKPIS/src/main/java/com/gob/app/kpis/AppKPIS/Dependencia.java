package com.gob.app.kpis.AppKPIS;


public class Dependencia {

	private int idDependencia;
	private String Dependencia;
	private String Descripcion;
	
	public Dependencia(int idDependencia, String dependencia, String descripcion) {
		super();
		this.idDependencia = idDependencia;
		Dependencia = dependencia;
		Descripcion = descripcion;
	}
	
	
	
	@Override
	public String toString() {
		return "Dependencia [idDependencia=" + idDependencia + ", Dependencia=" + Dependencia + ", Descripcion="
				+ Descripcion + "]";
	}
	
	
	public int getIdDependencia() {
		return idDependencia;
	}
	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}
	public String getDependencia() {
		return Dependencia;
	}
	public void setDependencia(String dependencia) {
		Dependencia = dependencia;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
