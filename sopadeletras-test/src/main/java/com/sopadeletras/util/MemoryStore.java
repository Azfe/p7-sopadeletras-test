package com.sopadeletras.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sopadeletras.mvc.model.Jugador;

/* Esta clase almacena la información de manera temporal mientras se ejecute la app. Esto evita usar una bbdd. */

public class MemoryStore {
	
	private static HashMap<String,Jugador> jugadores = new HashMap<>(); // En un HashMap se almacenan valores en un mapa formando un par clave-valor
	
	// Añadir jugador
	
	public static void addJugador(Jugador jugador) {
		String idGamer = jugador.getIdGamer()+"";
		
		if(jugadores.containsKey(idGamer)) {
			jugadores.remove(idGamer);
		}
		
		jugadores.put(idGamer, jugador);
	}
	
	// Actualizar jugador
	public static void editJugador(Jugador jugador) {
		jugadores.replace(jugador.getIdGamer()+"", jugador);
	}
	
	// Listar jugadores
	public static List<Jugador> getJugadores(){
		return new ArrayList<>(jugadores.values());
	}
	
	// Obtener un jugador
	public static Jugador getJugador(String idGamer) {
		return jugadores.get(idGamer);
	}

}
