package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class CoodenadaTest {

	//generar coordenadas
	@Test
	void coordenadaX0Test() {
		Coordenada c = new Coordenada(0, 0);
		assertEquals(0, c.getX());
	}
	
	@Test
	void coordenadaY0Test() {
		Coordenada c = new Coordenada(0, 0);
		assertEquals(0, c.getY());
	}

	@Test
	void coordenadaX9Test() {
		Coordenada c = new Coordenada(9, 0);
		assertEquals(9, c.getX());
	}
	
	@Test
	void coordenadaY9Test() {
		Coordenada c = new Coordenada(0, 9);
		assertEquals(9, c.getY());
	}

	@Test
	void coordenadaX10Test() {
		Coordenada c = new Coordenada(10, 0);
		assertEquals(0, c.getX());
	}
	
	@Test
	void coordenadaY10Test() {
		Coordenada c = new Coordenada(0, 10);
		assertEquals(0, c.getY());
	}
	
	@Test
	void coordenadaX_1Test() {
		Coordenada c = new Coordenada(-1, 0);
		assertEquals(0, c.getX());
	}
	
	@Test
	void coordenadaY_1Test() {
		Coordenada c = new Coordenada(0, -1);
		assertEquals(0, c.getY());
	}
	
	
	//Mover coordenadas
	@Test
	void moverDownTest() {
		Coordenada c = new Coordenada(0, 0);
		assertTrue(c.goDown());
	}
	
	@Test
	void moverDownFueraTest() {
		Coordenada c = new Coordenada(0, 9);
		assertFalse(c.goDown());
	}
	
	@Test
	void moverUpTest() {
		Coordenada c = new Coordenada(0, 9);
		assertTrue(c.goUp());
	}
	
	@Test
	void moverUpFueraTest() {
		Coordenada c = new Coordenada(0, 0);
		assertFalse(c.goUp());
	}
	
	@Test
	void moverRightTest() {
		Coordenada c = new Coordenada(0, 0);
		assertTrue(c.goRight());
	}
	
	@Test
	void moverRightFueraTest() {
		Coordenada c = new Coordenada(9, 0);
		assertFalse(c.goRight());
	}
	
	@Test
	void moverLeftTest() {
		Coordenada c = new Coordenada(9, 0);
		assertTrue(c.goLeft());
	}
	
	@Test
	void moverLeftFueraTest() {
		Coordenada c = new Coordenada(0, 0);
		assertFalse(c.goLeft());
	}
	
	//prueba del clone
	@Test
	void clonarTest() {
		Coordenada c = new Coordenada(5, 6);
		Coordenada cClone = c.clone();
		assertTrue(cClone.equals(c));
	}
	
}
