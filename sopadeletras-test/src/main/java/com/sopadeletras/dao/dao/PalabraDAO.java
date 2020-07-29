package com.sopadeletras.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sopadeletras.connection.Conexion;
import com.sopadeletras.dao.dao.PalabraDAO;
import com.sopadeletras.mvc.model.Palabra;

public class PalabraDAO {
	
	private Conexion con;
	private Connection connection;
	
	public PalabraDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException	{
		
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);		
	}
	
	// Insertar Palabra
	public boolean insertar(Palabra palabra) throws SQLException{
		
		String sql = "INSERT INTO palabra(idPalabra, nomPalabra, numLetras) values (?,?,?)";
		System.out.println(palabra.getNomPalabra());
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, (Integer) null);
		//statement.setInt(2,  jugador.getIdGamer());
		statement.setString(2, palabra.getNomPalabra());
		statement.setInt(3, palabra.getNumLetras());

		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;		
	}
	
	// Listar todos los productos
	public List<Palabra> listaPalabras() throws SQLException{
		
		List<Palabra> listaPalabras = new ArrayList<Palabra>();
		
		String sql = "SELECT * FROM palabra";
		
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int idPalabra = resultSet.getInt("idPalabra");
			String nomPalabra = resultSet.getString("Palabra");
			int numLetras = resultSet.getInt("numLetras");
			Palabra palabra = new Palabra(idPalabra, nomPalabra, numLetras);
			listaPalabras.add(palabra);			
		}
		
		con.desconectar();
		return listaPalabras;			
	}
	
	// Obtener por id
	public Palabra obtenerPorId(int idPalabra) throws SQLException{
		
		Palabra palabra = null;
		
		String sql = "SELECT * FROM palabra WHERE idPalabra = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idPalabra);
		
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			palabra = new Palabra(res.getInt("idPalabra"), res.getString("nomPalabra"), res.getInt("numLetras"));
		}
		res.close();
		con.desconectar();
		
		return palabra;		
	}
	
	// Actualizar palabra
	public boolean actualizar(Palabra palabra) throws SQLException{
		boolean rowActualizar = false;
		String sql = "UPDATE jugador SET idGamer = ?, nick = ?, email = ?, password = ?, puntuacion = ? WHERE idGamer = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, palabra.getIdPalabra());
		statement.setString(2, palabra.getNomPalabra());
		statement.setInt(3, palabra.getNumLetras());
		
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowActualizar;				
	}
	
	// Eliminar palabra
	
	public boolean eliminar(Palabra palabra) throws SQLException{
		
		boolean rowEliminar = false;
		String sql = "DELETE FROM palabra WHERE idPalabra= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);		
		statement.setInt(1, palabra.getIdPalabra());
		
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowEliminar;
	}
}