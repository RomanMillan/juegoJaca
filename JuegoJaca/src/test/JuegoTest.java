package test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
	void constructorJuegoTest() {
		PlayerType[] jugadores = new PlayerType[4];
		
		jugadores[0] = PlayerType.ELFO;
		jugadores[1] = PlayerType.GUERRERO;
		jugadores[2] = PlayerType.MAGO;
		jugadores[3] = PlayerType.MAGO;
		
		Juego juego = new Juego(jugadores);
		String r = juego.toString();

		assertTrue(r.length() > 0);
		assertEquals(PlayerType.ELFO.name(), juego.getNombreJuegadorQueJuega());
		assertEquals(0, juego.getValorDado());
	}

	
	@Test
	void isTerminadoNoTest() {
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
	

	@Test
	void isTerminadoUnJugadorTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);

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
		
		PlayerType[] ordenJugadores = new PlayerType[4];
		
		ordenJugadores[0]= jugadores.get(0);
		ordenJugadores[1]= jugadores.get(1);
		ordenJugadores[2]= jugadores.get(2);
		ordenJugadores[3]= jugadores.get(3);
		
		Juego juego = new Juego(ordenJugadores);
		
		juego.proximoJugador();
		Coordenada c = juego.obtenerCoordenadaJugadorJuega();
		Jugador j = (Jugador) juego.obtenerElementoTablero(c);
		j.setDinero(Constantes.NUM_DINERO);
		
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
	
	@Test
	void getGanadorTest() {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];
		ordenJugadores[0]= jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);
		
		assertEquals("ELFO: dinero: 0, gemas: 0 pociones: 0",juego.getGanador());
	}
	
	
	
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
		Coordenada c = juego.obtenerCoordenadaJugadorJuega();
		Jugador j = (Jugador) juego.obtenerElementoTablero(c);
		j.setDinero(Constantes.NUM_DINERO);
		String ganador = juego.getGanador();
		assertEquals("ELFO: dinero: 2, gemas: 0 pociones: 0",ganador);
	}
	
	
	
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


	@SuppressWarnings("unlikely-arg-type")
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
		Element e = (Element) juego.obtenerElementoTablero(c);
		
		assertTrue((e == null)
				|| (e.asType().equals(ElementType.ELFO))
				|| (e.asType().equals(ElementType.GUERRERO)) 
				|| (e.asType().equals(ElementType.MAGO)) 
				|| (e.asType().equals(ElementType.OGRO)) 
				|| (e.asType().equals(ElementType.GEMA))
				|| (e.asType().equals(ElementType.POCION))
				|| (e.asType().equals(ElementType.DINERO)) 
				|| (e.asType().equals(ElementType.ROCA)));
		}
		
	
		@Test
		void movePlayerNoTest() {	
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			PlayerType[] ordenJugadores = new PlayerType[1];
			
			ordenJugadores[0]= jugadores.get(0);
			Juego juego = new Juego(ordenJugadores);

			try {
				juego.movePlayer('-');
				fail("Error. Exception no ejecutada");
			} catch (Exception e) {
				
			}
		}
		
		@Test
		void movePlayerArribaTest() throws JuegoException, JugadorException {	
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			PlayerType[] ordenJugadores = new PlayerType[1];
			
			ordenJugadores[0]= jugadores.get(0);
			Juego juego = new Juego(ordenJugadores);

			Coordenada a = juego.obtenerCoordenadaJugadorJuega();
			Coordenada f = new Coordenada(a.getX(), a.getY() - 1);

			juego.movePlayer('N');

			assertTrue(juego.isTerminado() 
						|| juego.obtenerCoordenadaJugadorJuega().equals(a)
						|| juego.obtenerCoordenadaJugadorJuega().equals(f));
			}
		
		@Test
		void movePlayerAbajoTest() throws JuegoException, JugadorException {	
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			PlayerType[] ordenJugadores = new PlayerType[1];
			
			ordenJugadores[0]= jugadores.get(0);
			Juego juego = new Juego(ordenJugadores);

			Coordenada a = juego.obtenerCoordenadaJugadorJuega();
			Coordenada f = new Coordenada(a.getX(), a.getY() + 1);

			juego.movePlayer('S');

			assertTrue(juego.isTerminado() 
						|| juego.obtenerCoordenadaJugadorJuega().equals(a)
						|| juego.obtenerCoordenadaJugadorJuega().equals(f));
			}
		
		@Test
		void movePlayerIzquierdaTest() throws JuegoException, JugadorException {	
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			PlayerType[] ordenJugadores = new PlayerType[1];
			
			ordenJugadores[0]= jugadores.get(0);
			Juego juego = new Juego(ordenJugadores);

			Coordenada a = juego.obtenerCoordenadaJugadorJuega();
			Coordenada f = new Coordenada(a.getX()-1, a.getY());

			juego.movePlayer('E');

			assertTrue(juego.isTerminado() 
						|| juego.obtenerCoordenadaJugadorJuega().equals(a)
						|| juego.obtenerCoordenadaJugadorJuega().equals(f));
			}
		
		@Test
		void movePlayerDerechaTest() throws JuegoException, JugadorException {	
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			PlayerType[] ordenJugadores = new PlayerType[1];
			
			ordenJugadores[0]= jugadores.get(0);
			Juego juego = new Juego(ordenJugadores);

			Coordenada a = juego.obtenerCoordenadaJugadorJuega();
			Coordenada f = new Coordenada(a.getX()+1, a.getY());

			juego.movePlayer('O');

			assertTrue(juego.isTerminado() 
						|| juego.obtenerCoordenadaJugadorJuega().equals(a)
						|| juego.obtenerCoordenadaJugadorJuega().equals(f));
			}
}
