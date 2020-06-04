package com.sopadeletras.mvc.model;

import java.util.ArrayList;

public class Tablero {
	
	private int idTablero;	
	ArrayList<Casilla> arrayCasillas = new ArrayList<Casilla>();
	
	public Tablero() {
		super();		
	}

	public int getIdTablero() {
		return idTablero;
	}

	public void setIdTablero(int idTablero) {
		this.idTablero = idTablero;
	}

	public ArrayList<Casilla> getArrayCasillas() {
		return arrayCasillas;
	}

	public void setArrayCasillas(ArrayList<Casilla> arrayCasillas) {
		this.arrayCasillas = arrayCasillas;
	}

	@Override
	public String toString() {
		return "Tablero [idTablero=" + idTablero + ", getIdTablero()=" + getIdTablero() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
