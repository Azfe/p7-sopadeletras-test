package com.sopadeletras.dao.idao;

import java.util.List;

import com.sopadeletras.dao.CRUD;
import com.sopadeletras.mvc.model.Jugador;

public interface JugadorIDAO extends CRUD {
	
	
	public List listar();	
	public Jugador list(int id);
	public boolean add(Jugador jug);
	public boolean update(Jugador jug);
	public boolean eliminar();

}
