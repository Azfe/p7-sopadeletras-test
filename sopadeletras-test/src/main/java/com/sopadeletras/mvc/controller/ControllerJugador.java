package com.sopadeletras.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopadeletras.dao.dao.JugadorDAO;
import com.sopadeletras.mvc.model.Jugador;

/*
 * Clase de implementación de servlet ControllerJugador
*/

@WebServlet("/ControllerJugador")
public class ControllerJugador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	JugadorDAO jugadorDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		
		try {
			jugadorDAO = new JugadorDAO(jdbcURL, jdbcUserName, jdbcPassword);
		}catch(Exception e) {
			
		}
	}
	
	public ControllerJugador() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("Hola Servlet...");
		String action = request.getParameter("action");
		System.out.println(action);
		
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("Entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch(Exception e) {
			e.getStackTrace();
		}		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Jugador articulo = new Jugador(0, request.getParameter("nick"), request.getParameter("email"), request.getParameter("password"), 
				Integer.parseInt(request.getParameter("precio")));
		jugadorDAO.insertar(articulo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Jugador> listaArticulos= jugadorDAO.listaJugadores();
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Jugador jugador = jugadorDAO.obtenerPorId(Integer.parseInt(request.getParameter("idGamer")));
		request.setAttribute("jugador", jugador);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Jugador jugador = new Jugador(Integer.parseInt(request.getParameter("idGamer")), request.getParameter("nick"), request.getParameter("email"), 
				request.getParameter("password"), Integer.parseInt(request.getParameter("puntuacion")));
		jugadorDAO.actualizar(jugador);
		index(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Jugador jugador = jugadorDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		jugadorDAO.eliminar(jugador);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}