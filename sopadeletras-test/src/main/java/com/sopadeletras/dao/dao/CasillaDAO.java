package com.sopadeletras.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sopadeletras.connection.Conexion;
import com.sopadeletras.mvc.model.Casilla;

public class CasillaDAO {

	private Conexion con;
	private Connection connection;
	
	public CasillaDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException	{
		
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);		
	}
	
	// Insertar Casilla	
	public boolean insertar(Casilla casilla) throws SQLException{
		
		String sql = "INSERT INTO casilla(idCasilla, posicion) values (?,?)";
		System.out.println(casilla.getPosicion());
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, (Integer) null);
		statement.setInt(2, casilla.getPosicion());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	// Listar todas las casillas
	public List<Casilla> listaCasillas() throws SQLException{
		
		List<Casilla> listaCasillas = new ArrayList<Casilla>();
		
		String sql = "SELECT * FROM casilla";
		
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int idCasilla = resultSet.getInt("idCasilla");
			int posicion = resultSet.getInt("posicion");
			Casilla casilla = new Casilla(idCasilla, posicion);
			listaCasillas.add(casilla);			
		}
		
		con.desconectar();
		return listaCasillas;			
	}
	
	// Obtener por id
	public Casilla obtenerPorId(int idCasilla) throws SQLException{
		
		Casilla casilla = null;
		
		String sql = "SELECT * FROM casilla WHERE idCasilla = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCasilla);
		
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			casilla = new Casilla(res.getInt("idCasilla"), res.getInt("posicion"));
		}
		res.close();
		con.desconectar();
		
		return casilla;		
	}
	
	// Actualizar casilla
	public boolean actualizar(Casilla casilla) throws SQLException{
		boolean rowActualizar = false;
		String sql = "UPDATE casilla SET idCasilla = ?, posicion = ? WHERE idCasilla = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, casilla.getIdCasilla());
		statement.setInt(2, casilla.getPosicion());
		
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowActualizar;				
	}
	
	// Eliminar casilla	
	public boolean eliminar(Casilla casilla) throws SQLException{
		
		boolean rowEliminar = false;
		String sql = "DELETE FROM casilla WHERE idCasilla = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);		
		statement.setInt(1, casilla.getIdCasilla());
		
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowEliminar;
	}
}