package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.PlayerType;

class JugadorTest {
	
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
		}else {
			fail("Fuera de rango");
		}
	}
	
	@Test
	void getMagiaParaLucharTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int r = j.getMagiaParaLuchar();
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
		}else {
			fail("Fuera de rango");
		}
	}
	
	@Test
	void resumenTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		String r = j.resumen();
		assertEquals("ELFO: dinero: 0, gemas: 0 "
				+ "pociones: 0",r);
	}
	
	
	//REVISAR
//	@Test
//	void luchaTest() {
//		Jugador j = new Jugador(PlayerType.ELFO);
//		Jugador jE = new Jugador(PlayerType.GUERRERO);
//		int fuerzaJ = j.getFuerzaParaLuchar();
//		int fuerzaJE = jE.getFuerzaParaLuchar();
//		int r = j.lucha(jE);
//		
//		if(fuerzaJ == fuerzaJE) {
//			assertEquals(0, r);
//		}else if(fuerzaJ>fuerzaJE) {
//			if(jE.getPociones()>0) {
//				assertEquals(1, r);	
//			}else if(jE.getDinero()>0) {
//				assertEquals(2, r);	
//			}else {
//				assertEquals(3, r);	
//			}
//		}else {
//			if(j.getPociones()>0) {
//				assertEquals(4, r);	
//			}else if(j.getDinero()>0) {
//				assertEquals(5, r);	
//			}else {
//				assertEquals(6, r);
//			}
//		}
//	}
	
	
	@Test
	void getVelocidadParaLucharTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int r = j.getVelocidadParaLuchar();
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
		int magia = j.getFuerzaParaLuchar();
		if(magia>4) {
			assertEquals(1,r);
		}else {
			assertEquals(2,r);	
		}
		
	}

}






