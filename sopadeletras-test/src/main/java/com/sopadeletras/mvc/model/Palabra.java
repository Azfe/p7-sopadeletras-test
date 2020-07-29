package com.sopadeletras.mvc.model;

public class Palabra {
	
	private int idPalabra;
	private String nomPalabra;
	private int numLetras;
	
	// Métodos constructores:	
	public Palabra() {
		super();
	}
	
	public Palabra(int idPalabra, String nomPalabra, int numLetras) {		
		this.idPalabra = idPalabra;
		this.nomPalabra = nomPalabra;
		this.numLetras = numLetras;				
	}
	
	// Getters y setters
	public int getIdPalabra() {
		return idPalabra;
	}

	public void setIdPalabra(int idPalabra) {
		this.idPalabra = idPalabra;
	}

	public String getNomPalabra() {
		return nomPalabra;
	}

	public void setNomPalabra(String nomPalabra) {
		this.nomPalabra = nomPalabra;
	}

	public int getNumLetras() {
		return numLetras;
	}

	public void setNumSilabas(int numLetras) {
		this.numLetras = numLetras;
	}

	@Override
	public String toString() {
		return "Palabra [idPalabra=" + idPalabra + ", nomPalabra=" + nomPalabra + ", numLetras=" + numLetras + "]";
	}

}
