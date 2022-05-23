package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import javax.lang.model.element.Element;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.ElementType;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;
import logicaJuego.JuegoException;


class JuegoTest {

	


	
	@Test
	void isTerminadoTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		assertFalse(juego.isTerminado());
	}
	
	//implementar
	@Test
	void isTerminado1JugadorTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];
		
		ordenJugadores[0]= jugadores.get(0);

		Juego juego = new Juego(ordenJugadores);
		assertTrue(juego.isTerminado());
	}

	@Test
	void isTerminadoDineroTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];
		
		ordenJugadores[0]= jugadores.get(0);

		Juego juego = new Juego(ordenJugadores);
		assertTrue(juego.isTerminado());
	}
	
	
	@Test
	void getGanadorNoTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		assertEquals("",juego.getGanador());
	}
	/*
	@Test
	void getGanadorDineroTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);
		
		Juego juego = new Juego(ordenJugadores);
		PlayerType auxJ = jugadores.get(0);
		Jugador j = new Jugador(auxJ);
		j.encuentraDinero();
		j.encuentraDinero();
		assertEquals(auxJ,juego.getGanador());
	}
	*/
	
	
	@Test
	void getNombreJuegadorQueJuegaTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		assertEquals("ELFO",juego.getNombreJuegadorQueJuega());
	
	}
	
	@Test
	void imprimeNombreJugadoresTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		assertEquals("El jugador 1 es un ELFO\n"
				+ "El jugador 2 es un GUERRERO\n"
				+ "El jugador 3 es un MAGO\n"
				+ "El jugador 4 es un OGRO\n", 
				juego.imprimeNombreJugadores());
	}
	
	@Test
	void imprimeValoresJugadoresTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		assertEquals("ELFO Dinero: 0 Pociones: 0 Gemas: 0\n"
				+ "GUERRERO Dinero: 0 Pociones: 0 Gemas: 0\n"
				+ "MAGO Dinero: 0 Pociones: 0 Gemas: 0\n"
				+ "OGRO Dinero: 0 Pociones: 0 Gemas: 0\n", 
				juego.imprimeValoresJugadores());
	}
	
	@Test
	void getValorDadoTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		int r = juego.getValorDado();
		assertEquals(0, r);
	}
	
	@Test
	void decrementaDadoTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		juego.decrementaDado();
		int r = juego.getValorDado();
		assertEquals(-1, r);
	}
	
	@Test
	void setDadoTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		juego.setDado();
		int r = juego.getValorDado();
		assertTrue(r>= 0 && r<= 7);
	}
	
	@Test
	void getMovimientoJugadorTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		juego.setDado();
		int r = juego.getMovimientoJugador();
		assertTrue(r>= 0&&r<= 7);
	}
	
	@Test
	void proximoJugadorTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		juego.proximoJugador();
		
		assertEquals("GUERRERO",juego.getNombreJuegadorQueJuega());
	}


	
	
	/*
	@Test
	void obtenerElementoTableroTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);

		Juego juego = new Juego(ordenJugadores);
		Coordenada c = new Coordenada();
		Element r = (Element) juego.obtenerElementoTablero(c);
		if(r == ) {
			assertEquals("", juego.toString());	
		}
		
	}
	*/
	
	
	
}
