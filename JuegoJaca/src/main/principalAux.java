package main;

import java.util.ArrayList;
import java.util.HashMap;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.PlayerType;
import logicaJuego.Constantes;

public class principalAux {

	public static void main(String[] args) {

		

		HashMap<Coordenada, Element> tablero = new HashMap<>();
		 ArrayList<Coordenada> coordenadaJugadores = new ArrayList<>();
		
		Jugador j = new Jugador(PlayerType.ELFO);
		Coordenada c = new Coordenada();
		coordenadaJugadores.add(c);
		tablero.put(c, j);
		
		Jugador j2 = new Jugador(PlayerType.GUERRERO);
		Coordenada c2 = new Coordenada();
		coordenadaJugadores.add(c2);
		tablero.put(c2, j2);
		
		Jugador j3 = new Jugador(PlayerType.MAGO);
		Coordenada c3 = new Coordenada();
		coordenadaJugadores.add(c3);
		tablero.put(c3, j3);
		
		j2.setDinero(4);
		
		for(int i = 0; i<coordenadaJugadores.size();i++) {
			Jugador ju;
			ju = (Jugador) tablero.get(coordenadaJugadores.get(i));
			if(ju.getDinero()== Constantes.DINERO) {
				String info = ju.resumen();
				System.out.println(info);
			}
		}
		
		
		StringBuilder nom = new StringBuilder();
		for(int i = 0; i<coordenadaJugadores.size();i++) {
			j = (Jugador) tablero.get(coordenadaJugadores.get(i));
			nom.append("El jugador " + (i+1) + " es un " + j.getNombre() + "\n");
		}
		System.out.println(nom);
		
		
		
		
		
	}

}
