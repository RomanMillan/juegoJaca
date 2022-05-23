package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.PlayerType;
import logicaJuego.Constantes;

class JugadorTest {
	
	
	@Test
	void constructorJugadorTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getPociones());
		assertEquals(0, j.getDinero());
		assertEquals(0, j.getGemas());
		assertEquals(PlayerType.ELFO, j.getPlayer());
	}
	
	@Test
	void getDineroTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getDinero());
	}
	
	@Test
	void setDineroTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.setDinero(1);
		assertEquals(1, j.getDinero());
	}
	
	@Test
	void getGemasTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getGemas());
	}
	
	@Test
	void setGemasTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.setGemas(1);
		assertEquals(1,j.getGemas());
	}
	
	@Test
	void getPocionesTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getPociones());
	}
	
	@Test
	void setPocionesTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.setPociones(1);
		assertEquals(1,j.getPociones());
	}
	
	@Test
	void getNombreTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		assertEquals("ELFO", j.getNombre());
	}
	
	
	@Test
	void getFuerzaParaLucharTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int r = j.getFuerzaParaLuchar();
		assertTrue(r>=0&&r<=5);
	}
	
	@Test
	void getMagiaParaLucharTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int r = j.getMagiaParaLuchar();
		assertTrue(r>=0&&r<=6);
	}
	
	@Test
	void resumenTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		String r = j.resumen();
		assertEquals("ELFO: dinero: 0, gemas: 0 "
				+ "pociones: 0",r);
	}
	
	
	@Test
	void luchaTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		Jugador jE = new Jugador(PlayerType.GUERRERO);
		
		int r = j.lucha(jE);
		assertTrue((r==Constantes.EMPATE)
					||(r==Constantes.GANA_MUERE)
					||(r==Constantes.PIERDE_MUERE));
		
	}
	
	@Test
	void luchaDineroTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		Jugador jE = new Jugador(PlayerType.MAGO);
		
		j.setDinero(1);
		jE.setDinero(1);
		
		j.lucha(jE);
		int d = j.getDinero();
		
		assertTrue((d==0)||(d==1)||(d==2));
	}
	
	@Test
	void luchaPocionesTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		Jugador jE = new Jugador(PlayerType.MAGO);
		
		j.setPociones(1);
		jE.setPociones(1);
		
		j.lucha(jE);
		int d = j.getPociones();
		
		assertTrue((d==0)||(d==1)||(d==2));
	}
	
	
	
	@Test
	void getVelocidadParaLucharTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int r = j.getVelocidadParaLuchar();
		assertTrue(r>=0&&r<=7);
	}
	
	@Test
	void encuentraDineroTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.encuentraDinero();
		int r = j.getDinero();
		assertEquals(1,r);
	}
	
	@Test
	void encuentraPocionTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.encuentraPocion();
		int r = j.getPociones();
		assertEquals(1,r);
	}
	
	@Test
	void encuentraGemaTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.encuentraGema();
		int r = j.getGemas();
		assertEquals(1,r);
	}
	
	@Test
	void encuentraRocaGemaTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		j.encuentraGema();
		int r = j.encuentraRoca();
		assertEquals(0,r);
	}
	
	@Test
	void encuentraRocaMagiaTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int r = j.encuentraRoca();
		assertTrue((r==1)||(r==2));
		
	}

}






