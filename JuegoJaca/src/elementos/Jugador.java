package elementos;

import java.util.concurrent.ThreadLocalRandom;

import logicaJuego.Constantes;

public class Jugador {

	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;
	
	//constructor
	public Jugador(PlayerType player) {
		super();
		this.player = player;
	}

	//getter and setter (obejtos)
	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) {
		this.gemas = gemas;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) {
		this.pociones = pociones;
	}

	public PlayerType getPlayer() {
		return player;
	}
	
	//getter del player
	
	public String getNombre() {
		return player.name();
	}
	
	private int getFuerza() {
		return player.getFuerza();
	}
	
	private int getMagia() {
		return player.getMagia();
	}
	
	private int getVelocidad() {
		return player.getVelocidad();
	}
	
	public int getFuerzaParaLuchar() {
		ThreadLocalRandom fuerzaR = ThreadLocalRandom.current();
        return fuerzaR.nextInt(0, getFuerza());
	}
	
	public int getMagiaParaLuchar() {
		ThreadLocalRandom fuerzaR = ThreadLocalRandom.current();
        return fuerzaR.nextInt(0, getFuerza());
	}

	public String resumen() {
		return "Jugador [dinero=" + dinero + ", gemas=" + gemas + ", player=" + player + ", pociones=" + pociones + "]";
	}
	
	public int lucha(Jugador enemigo) {
		int fuerzaEnemigo = enemigo.getFuerzaParaLuchar();
		int fuerzaJugador = getFuerzaParaLuchar();
		int resultado;
		
		if(fuerzaJugador == fuerzaEnemigo) {
			resultado = Constantes.EMPATE;
		}else if(fuerzaJugador>fuerzaEnemigo) {
			if(enemigo.getPociones()>0) {
				resultado = Constantes.GANA_USA_POCIMA;	
			}else if(enemigo.getDinero()>0) {
				resultado = Constantes.GANA_DINERO;
			}else {
				resultado = Constantes.PIERDE_MUERE;
			}		
		}else {
			
		}
		
		return resultado;
		
	}
	
	
	
	
	
}
