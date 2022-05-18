package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.PlayerType;
import logicaJuego.Constantes;

class JugadorTest {

	//tests de Getter and Setter
	
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
	
	//random NO SE HACERLO
//	@Test
//	void getFuerzaParaLucharTest() {
//		Jugador j = new Jugador(PlayerType.ELFO);
//		assertEquals(5, j.getMagiaParaLuchar());
//	}
	
	@Test
	void luchaTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		Jugador jE = new Jugador(PlayerType.GUERRERO);
		int fuerzaJ = j.getFuerzaParaLuchar();
		int fuerzaJE = jE.getFuerzaParaLuchar();
		if(fuerzaJ == fuerzaJE) {
			assertEquals(0, j.lucha(jE));
		}else if(fuerzaJ>fuerzaJE) {
			assertEquals(3, j.lucha(jE));
		}else {
			assertEquals(6, j.lucha(jE));
		}
		
	}
	

}
