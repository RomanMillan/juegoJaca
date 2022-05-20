package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Juego;
import logicaJuego.JuegoException;

class JuegoTest {

	@Test
	void MoverJugadorTest() throws JuegoException, JugadorException {
		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		PlayerType[] ordenJugadores = new PlayerType[1];
		Juego j = new Juego(ordenJugadores);
		j.movePlayer('N');
		
	}

}
