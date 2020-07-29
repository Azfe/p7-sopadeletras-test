package com.sopadeletras.dao.idao;

import java.util.List;

import com.sopadeletras.dao.CRUD;
import com.sopadeletras.mvc.model.DatosPartida;
import com.sopadeletras.mvc.model.Jugador;

public interface DatosPartidaDAO extends CRUD {
	
	public void insertar(DatosPartida a);	
	public Jugador list(int id);
	public boolean add(Jugador jug);
	public boolean update(Jugador jug);
	public boolean eliminar();

}
