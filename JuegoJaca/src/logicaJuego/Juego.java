package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import elementos.*;

public class Juego extends Object{

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega

	
	public Juego (PlayerType[]jugadores) {
		tablero = new HashMap<>(); 
		coordenadaJugadores = new ArrayList<>();
		
	}
	
	private void crearTablero() {
		crearRocas();
		crearGemas();
		crearPociones();
		crearDinero();
	}
	
	
	private boolean crearJugador(ElementType tipo) {
		Jugador jugador = new Jugador(tipo);
		Coordenada c = null;
		do {
			c = new Coordenada();	
		}while(coordenadaJugadores.contains(jugador)||tablero.containsKey(c));
		coordenadaJugadores.add(c);
		tablero.put(c, jugador); //tengo que asignar al jugador al tablero y no me deja
		return true;
	}
	
	
	private void crearRocas() {
		for (int i=0;i<Constantes.NUM_ROCAS;i++) {
			Element e1 = new Element(ElementType.ROCA);
			boolean encontrado = true;
			do {
				Coordenada c1 = new Coordenada();
				if(!tablero.containsKey(c1)) {
					tablero.put(c1,e1);
					encontrado = false;
				}
			}while(encontrado);
		}
	}
	
	
	private void crearGemas() {
		for (int i=0;i<Constantes.NUM_GEMAS;i++) {
			Element e1 = new Element(ElementType.GEMA);
			boolean encontrado = true;
			do {
				Coordenada c1 = new Coordenada();
				if(!tablero.containsKey(c1)) {
					tablero.put(c1,e1);
					encontrado = false;
				}
			}while(encontrado);
		}
	}
	
	private void crearPociones() {
		for (int i=0;i<Constantes.NUM_POCIONES;i++) {
			Element e1 = new Element(ElementType.POCION);
			boolean encontrado = true;
			do {
				Coordenada c1 = new Coordenada();
				if(!tablero.containsKey(c1)) {
					tablero.put(c1,e1);
					encontrado = false;
				}
			}while(encontrado);
		}
	}
	
	
	private void crearDinero() {
		for (int i=0;i<Constantes.NUM_DINERO;i++) {
			Element e1 = new Element(ElementType.DINERO);
			boolean encontrado = true;
			do {
				Coordenada c1 = new Coordenada();
				if(!tablero.containsKey(c1)) {
					tablero.put(c1,e1);
					encontrado = false;
				}
			}while(encontrado);
		}
	}
	
	
	
	
	/**
	 * Escribe el tablero en formato no gráfico. Devuelve el string con la
	 * información
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}


	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}


	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una dirección válida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pócima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Después de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

	
}
