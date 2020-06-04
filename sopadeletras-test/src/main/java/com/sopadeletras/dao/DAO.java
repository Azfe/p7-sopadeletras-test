package com.sopadeletras.dao;

import java.util.List;

import com.sopadeletras.dao.idao.DAOException;

public interface DAO<T, K> {
	
	void insertar(T a) throws DAOException;
	
	void modificar(T a) throws DAOException;
	
	void eliminar(T a) throws DAOException;
	
	List<T> obtenerTodos() throws DAOException;
	
	T obtener(K id) throws DAOException;

}
