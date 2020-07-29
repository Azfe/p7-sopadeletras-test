package com.sopadeletras.mvc.model;


import java.io.Serializable;
import java.sql.Timestamp;


public class DatosPartida {

	private int idPartida;
	private Timestamp fecha;
	private int contadorTiempo;
	private int aciertos;
	private int numIntentos;
	
	public DatosPartida() {
		super();
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getContadorTiempo() {
		return contadorTiempo;
	}

	public void setContadorTiempo(int contadorTiempo) {
		this.contadorTiempo = contadorTiempo;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public int getNumIntentos() {
		return numIntentos;
	}

	public void setNumIntentos(int numIntentos) {
		this.numIntentos = numIntentos;
	}

	@Override
	public String toString() {
		return "DatosPartida [idPartida=" + idPartida + ", fecha=" + fecha + ", contadorTiempo=" + contadorTiempo
				+ ", aciertos=" + aciertos + ", numIntentos=" + numIntentos + "]";
	}	
}