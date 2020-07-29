package com.sopadeletras.mvc.model;

public class Casilla {
	
	private int idCasilla;
	private int posicion;
	
	// Métodos constructores:	
	public Casilla() {
		super();
	}
	
	public Casilla(int idCasilla, int posicion) {
		super();
		this.idCasilla = idCasilla;
		this.posicion = posicion;
	}
	
	// Getters y Setters
	public int getIdCasilla() {
		return idCasilla;
	}

	public void setIdCasilla(int idCasilla) {
		this.idCasilla = idCasilla;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	// toString
	@Override
	public String toString() {
		return "Casilla [idCasilla=" + idCasilla + ", posicion=" + posicion + ", getIdCasilla()=" + getIdCasilla()
				+ ", getPosicion()=" + getPosicion() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
