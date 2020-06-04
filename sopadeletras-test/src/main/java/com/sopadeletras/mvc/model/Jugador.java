package com.sopadeletras.mvc.model;

public class Jugador {
	
	// Declaración atributos
	private int idGamer = 0;
	private String nick;
	private String email;
	private String password;
	private int puntuacion;
	
	// Método constructor
	public Jugador() {
		super();
	}
	
	public int getIdGamer() {
		return idGamer;
	}
	public void setIdGamer(int idGamer) {
		this.idGamer = idGamer;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Jugador: " + this.nick + " | id: " + this.idGamer + " ]";
	}
}
