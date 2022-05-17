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
		dado = 0;
		jugadorJuega = 0;
		crearTablero();
		crearJugador(jugadores[0]);
		crearJugador(jugadores[1]);
		crearJugador(jugadores[2]);
		crearJugador(jugadores[3]);
	}
	
	private void crearTablero() {
		crearRocas();
		crearGemas();
		crearPociones();
		crearDinero();
	}
	
	
	private boolean crearJugador(PlayerType tipo) {
		Jugador jugador = new Jugador(tipo);
		Coordenada c = null;
		do {
			c = new Coordenada();	
		}while(coordenadaJugadores.contains(jugador)&&tablero.containsKey(c));
		coordenadaJugadores.add(c);
		tablero.put(c, jugador);
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
	
	private void eliminarJugador(Coordenada coord) {
		tablero.remove(coord);
		coordenadaJugadores.remove(coord);
	}
	
	public boolean isTerminado() {
		boolean terminado = false;
		if(coordenadaJugadores.size()==1) {
			terminado = true;
		}else {
			for(int i = 0; i<coordenadaJugadores.size()&& !terminado;i++) {
				Jugador j;
				j = (Jugador) tablero.get(coordenadaJugadores.get(i));
				if(j.getDinero()== Constantes.NUM_DINERO) {
					terminado = true;
				}
			}
		}
		return terminado;
	}
	
	public String getGanador() {
		String info="";
		Jugador j;
		boolean terminado = false;
		if(coordenadaJugadores.size()==1) {
			j = (Jugador) tablero.get(coordenadaJugadores.get(0));
			info = j.resumen();
		}else {
			for(int i = 0; i<coordenadaJugadores.size()&& !terminado;i++) {
				j = (Jugador) tablero.get(coordenadaJugadores.get(i));
				if(j.getDinero()== Constantes.NUM_DINERO) {
					info = j.resumen();
					terminado = true;
				}
			}
		}
		return info;
	}
	
	public void decrementaDado() {
		dado--;
	}
	
	public int getValorDado() {
		return dado;
	}
	
	public void setDado() {
		Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		dado = j.getVelocidadParaLuchar();
	}
	
	public Element obtenerElementoTablero(Coordenada coord) {
		return tablero.get(coord); 
	}
	
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return coordenadaJugadores.get(jugadorJuega);
	}
	
	public String getNombreJuegadorQueJuega() {
		Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		return j.getNombre();
	}
	
	public String imprimeNombreJugadores() {
		Jugador j;
		StringBuilder nom = new StringBuilder();
		for(int i = 0; i<coordenadaJugadores.size();i++) {
			j = (Jugador) tablero.get(coordenadaJugadores.get(i));
			nom.append("El jugador " + (i+1) + " es un " + j.getNombre() + "\n");
		}
		return nom.toString();
	}
	
	public String imprimeValoresJugadores() {
		Jugador j;
		StringBuilder v = new StringBuilder();
		for(int i = 0; i<coordenadaJugadores.size();i++) {
			j = (Jugador) tablero.get(coordenadaJugadores.get(i));
			v.append(j.getNombre() + " Dinero: " + j.getDinero() + " Pociones: " + j.getPociones() 
			+ " Gemas: " +j.getGemas()+ "\n");
		}
		return v.toString();
	}
	
	
	public int getMovimientoJugador() {
		Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		return j.getVelocidadParaLuchar();
	}
	
	public void proximoJugador() {
		if(jugadorJuega == coordenadaJugadores.size()-1) {
			jugadorJuega = 0;
		}else {
			jugadorJuega++;
		}
	}
	
	private void cambiaJugadorAPosicion(Coordenada coord) {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		tablero.remove(c);
		tablero.put(coord, j);
		coordenadaJugadores.remove(c);
		coordenadaJugadores.add(coord);
	}
	
	private Coordenada getNextPosition(char direction) throws JuegoException {
		if(direction != 'N' && direction != 'S'&& direction != 'E'&& direction != 'O') {
			throw new JuegoException("Direccion incorrecta");
		}
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Coordenada ac = c.clone();
		
		switch (direction) {
		case 'N': {
			ac.goUp();
			break;
		}
		case 'S': {
			ac.goDown();
			break;
		}
		case 'E': {
			ac.goRight();
			break;
		}
		case 'O': {
			ac.goLeft();
			break;
		}
		default:
			System.out.println("Fuera de rango");
		}
		return ac;
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
