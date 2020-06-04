package com.sopadeletras.mvc.model;

public class Palabra {
	
	private int idPalabra;
	private String nomPalabra;
	private int numSilabas;
	
	public Palabra() {
		super();
	}

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

	public int getNumSilabas() {
		return numSilabas;
	}

	public void setNumSilabas(int numSilabas) {
		this.numSilabas = numSilabas;
	}

	@Override
	public String toString() {
		return "Palabra [idPalabra=" + idPalabra + ", nomPalabra=" + nomPalabra + ", numSilabas=" + numSilabas + "]";
	}

}
