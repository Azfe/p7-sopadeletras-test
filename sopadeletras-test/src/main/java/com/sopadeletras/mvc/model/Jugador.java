package com.sopadeletras.mvc.model;

public class Jugador {
	
	private int idGamer;
	private String nick;
	private String email;
	private String password;
	private int puntuacion;
	
	// Métodos constructores:	
	public Jugador() {
		super();
	}
	
	public Jugador(int idGamer, String nick, String email, String password, int puntuacion) {
		
		this.idGamer = idGamer;
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.puntuacion = puntuacion;				
	}
	
	// Getters y setters
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
		return "Jugador [idGamer=" + idGamer + ", nick=" + nick + ", email=" + email + ", password=" + password
				+ ", puntuacion=" + puntuacion + "]";
	}	
}