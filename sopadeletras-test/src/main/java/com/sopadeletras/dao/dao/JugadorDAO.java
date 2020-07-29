package com.sopadeletras.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sopadeletras.connection.Conexion;
import com.sopadeletras.dao.CRUD;
import com.sopadeletras.dao.idao.DAOException;
import com.sopadeletras.dao.idao.JugadorIDAO;
import com.sopadeletras.mvc.model.Jugador;

public class JugadorDAO {
	
	private Conexion con;
	private Connection connection;
	
	public JugadorDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException	{
		
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);		
	}
	
	// Insertar Jugador	
	public boolean insertar(Jugador jugador) throws SQLException{
		
		String sql = "INSERT INTO jugador(idGamer, nick, email, password, puntuacion) values (?,?,?,?,?)";
		System.out.println(jugador.getNick());
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, (Integer) null);
		//statement.setInt(2,  jugador.getIdGamer());
		statement.setString(2, jugador.getNick());
		statement.setString(3, jugador.getEmail());
		statement.setString(4,  jugador.getPassword());
		statement.setInt(5, jugador.getPuntuacion());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;		
	}
	
	// Listar todos los productos
	public List<Jugador> listaJugadores() throws SQLException{
		
		List<Jugador> listaJugadores = new ArrayList<Jugador>();
		
		String sql = "SELECT * FROM jugador";
		
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int idGamer = resultSet.getInt("idGamer");
			String nick = resultSet.getString("nick");
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			int puntuacion = resultSet.getInt("puntuacion");
			Jugador jugador = new Jugador(idGamer, nick, email, password, puntuacion);
			listaJugadores.add(jugador);			
		}
		
		con.desconectar();
		return listaJugadores;			
	}
	
	// Obtener por id
	public Jugador obtenerPorId(int idGamer) throws SQLException{
		
		Jugador jugador = null;
		
		String sql = "SELECT * FROM jugador WHERE idGamer = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idGamer);
		
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			jugador = new Jugador(res.getInt("idGamer"), res.getString("nick"), res.getString("email"), 
					res.getString("password"), res.getInt("puntuacion"));
		}
		res.close();
		con.desconectar();
		
		return jugador;		
	}
	
	// Actualizar jugador
	public boolean actualizar(Jugador jugador) throws SQLException{
		boolean rowActualizar = false;
		String sql = "UPDATE jugador SET idGamer = ?, nick = ?, email = ?, password = ?, puntuacion = ? WHERE idGamer = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, jugador.getIdGamer());
		statement.setString(2, jugador.getNick());
		statement.setString(3, jugador.getEmail());
		statement.setString(4, jugador.getPassword());
		statement.setInt(5, jugador.getPuntuacion());
		
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowActualizar;				
	}
	
	// Eliminar jugador
	
	public boolean eliminar(Jugador jugador) throws SQLException{
		
		boolean rowEliminar = false;
		String sql = "DELETE FROM jugador WHERE idGamer = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);		
		statement.setInt(1, jugador.getIdGamer());
		
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowEliminar;
	}	
}