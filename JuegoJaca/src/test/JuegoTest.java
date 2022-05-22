package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
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

	
	//no consigo implementarlo correctamente.
	/*
	@Test
	void MoverJugadorUpTest() {
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
		try {
			if(c.getY()>0) {
				juego.movePlayer('N');
				Element e = (Element) juego.obtenerElementoTablero(c);
				
				if(e == null
						||e.equals(Constantes.GANA_MUERE)
						|| e.equals(Constantes.ROMPE_ROCA_CON_GEMA)
						|| e.equals(Constantes.GANA_A_LA_ROCA)
						|| e.equals(Constantes.GANA_DINERO)){
					
					Coordenada auxC = new Coordenada(c.getX(), c.getY()-1);
					assertEquals(auxC, c);
				}else if(e.equals(Constantes.PIERDE_USA_POCIMA)
						|| e.equals(Constantes.PIERDE_DINERO)
						|| e.equals(Constantes.PIERDE_A_LA_ROCA)
						|| e.equals(Constantes.EMPATE)){
					
					Coordenada auxC = new Coordenada(c.getX(), 0);
					assertEquals(auxC, c);
				}else {
					assertFalse(false);
				}
			}else {
				Coordenada auxC = new Coordenada(c.getX(), 0);
				assertEquals(auxC, c);
			}
		} catch (JuegoException | JugadorException e) {
			fail("Error");
		}
	}
	
	*/
	
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
		if(r==0) {
			assertEquals(0,r);
		}else if(r==1) {
			assertEquals(1,r);
		}else if(r==2) {
			assertEquals(2,r);
		}else if(r==3) {
			assertEquals(3,r);
		}else if(r==4) {
			assertEquals(4,r);
		}else if(r==5) {
			assertEquals(5,r);
		}else if(r==6) {
			assertEquals(6,r);
		}else if(r==7) {
			assertEquals(7,r);
		}else {
			fail("Fuera de rango");
		}
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
		if(r==0) {
			assertEquals(0,r);
		}else if(r==1) {
			assertEquals(1,r);
		}else if(r==2) {
			assertEquals(2,r);
		}else if(r==3) {
			assertEquals(3,r);
		}else if(r==4) {
			assertEquals(4,r);
		}else if(r==5) {
			assertEquals(5,r);
		}else if(r==6) {
			assertEquals(6,r);
		}else if(r==7) {
			assertEquals(7,r);
		}else {
			fail("Fuera de rango");
		}
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
