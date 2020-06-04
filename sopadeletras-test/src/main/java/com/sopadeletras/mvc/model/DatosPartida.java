package com.sopadeletras.mvc.model;

public class DatosPartida {
	
	private int idPartida;
	private int contadorTiempo;
	private int aciertos;
	private int numIntentos;
	private int intentosRestantes;
	private int totalIntentos;
	
	public DatosPartida() {
		super();
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
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

	public int getIntentosRestantes() {
		return intentosRestantes;
	}

	public void setIntentosRestantes(int intentosRestantes) {
		this.intentosRestantes = intentosRestantes;
	}

	public int getTotalIntentos() {
		return totalIntentos;
	}

	public void setTotalIntentos(int totalIntentos) {
		this.totalIntentos = totalIntentos;
	}

	@Override
	public String toString() {
		return "DatosPartida [idPartida=" + idPartida + ", contadorTiempo=" + contadorTiempo + ", aciertos=" + aciertos
				+ ", numIntentos=" + numIntentos + ", intentosRestantes=" + intentosRestantes + ", totalIntentos="
				+ totalIntentos + "]";
	}
	
}
