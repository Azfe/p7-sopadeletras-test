package com.sopadeletras.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.sopadeletras.dao.idao.DAOException;
import com.sopadeletras.dao.idao.JugadorDAO;
import com.sopadeletras.mvc.model.Jugador;

public class MySQLJugadorDAO implements JugadorDAO {
	
	final String INSERT = "INSERT INTO JUGADOR(idGamer, nick, email, password, puntuacion) values (?, ?, ?, ?, ?)";
	
	final String UPDATE = "UPDATE jugador SET nick = ?, email = ?, password = ?, puntuacion = ? WHERE idGamer = ?";
	
	final String DELETE = "DELETE FROM jugador WHERE idGamer = ?";
	
	final String GETALL = "SELECT idGamer, nick, email, password, puntuacion FROM JUGADOR";
	
	final String GETONE = "SELECT idGamer, nick, email, password, puntuacion FROM JUGADOR WHERE idGamer = ?";
	
	private Connection conexion;
	
	public MySQLJugadorDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void insertar(Jugador j) throws DAOException {
		// TODO Auto-generated method stub
		
		PreparedStatement stat = null;
		
		try {			
			stat = conexion.prepareStatement(INSERT);
			stat.setInt(1, j.getIdGamer());
			stat.setString(2, j.getNick());
			stat.setString(2, j.getEmail());
			stat.setString(2, j.getPassword());
			stat.setInt(2, j.getPuntuacion());
			if(stat.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya guardado.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		} finally {
			if(stat != null) {
				
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
	}

	@Override
	public void modificar(Jugador a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Jugador a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Jugador> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador obtener(String idGamer) {
		// TODO Auto-generated method stub
		return null;
	}
}
