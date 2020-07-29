package com.sopadeletras.dao;

import java.util.List;

import com.sopadeletras.mvc.model.Jugador;
import com.sopadeletras.mvc.model.Palabra;

public interface CRUD{
	
	public List listar();	
	public Jugador list(int id);
	public boolean add(Jugador jug);
	public boolean update(Jugador jug);
	public boolean eliminar(int id);	

}
