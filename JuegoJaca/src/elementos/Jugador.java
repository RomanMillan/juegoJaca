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
		ThreadLocalRandom magia = ThreadLocalRandom.current();
        return magia.nextInt(0, getMagia());
	}

	//toString
	
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
				resultado = Constantes.GANA_MUERE;
			}		
		}else {
			if(this.getPociones()>0) {
				resultado = Constantes.PIERDE_USA_POCIMA;
			}else if(this.getDinero()>0) {
				resultado = Constantes.PIERDE_DINERO;
			}else {
				resultado = Constantes.PIERDE_MUERE;
			}
		}
		return resultado;
	}
	
	public int getVelocidadParaLuchar() {
		ThreadLocalRandom velocidad = ThreadLocalRandom.current();
        return velocidad.nextInt(0, getVelocidad());
	}
	
	public void encuentraDinero() {
		setDinero(getDinero()+1);
	}
	
	public void encuentraPocion() {
		setPociones(getPociones()+1);
	}
	
	public void encuentraGema() {
		setGemas(getGemas()+1);
	}
	
	public int encuentraRoca() {
		//TODO Exception jugador?
		int resultado;
		if(getGemas()>0) {
			resultado = Constantes.ROMPE_ROCA_CON_GEMA;
			setGemas(getGemas()-1);
		}else if(getMagia()>4) {
			resultado = Constantes.GANA_A_LA_ROCA;
		}else {
			resultado = Constantes.PIERDE_A_LA_ROCA;
		}
		
		return resultado;
		
	}
	
	
}






