package elementos;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import logicaJuego.Constantes;

public class Coordenada extends Object{

	private int x;
	private int y;
	
	
	//constructores
	public Coordenada() {
		super();
		ThreadLocalRandom rX = ThreadLocalRandom.current();
        this.x = rX.nextInt(0, Constantes.TAMANNO);
        this.y = rX.nextInt(0, Constantes.TAMANNO);
	}
	
	public Coordenada(int x, int y) {
		super();
		setX(x);
		setY(y);
	}

	//getter and setter
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

	private void setX(int x) {
		if(x >= 0 && x<= Constantes.TAMANNO-1) {
			this.x = x;	
		}else {
			this.x = 0;
		}
		
	}

	private void setY(int y) {
		if(y >= 0 && y<= Constantes.TAMANNO-1) {
			this.y = y;	
		}else {
			this.y = 0;
		}
	}
	
	//metodos (mover posicion)
	public boolean goDown() {
		boolean respuesta = true;
		if(y == Constantes.TAMANNO-1) {
			respuesta = false;
		}else {
			this.y++;
		}
		return respuesta;
	}
	
	public boolean goUp() {
		boolean respuesta = true;
		if(y== 0) {
			respuesta = false;
		}else {
			this.y--;
		}
		return respuesta;
	}
	
	public boolean goRight() {
		boolean respuesta = true;
		if(x== Constantes.TAMANNO-1) {
			respuesta = false;
		}else {
			this.x++;
		}
		return respuesta;
	}
	
	public boolean goLeft() {
		boolean respuesta = true;
		if(x==0) {
			respuesta = false;
		}else {
			this.x--;
		}
		return respuesta;
	}
	
	
	//hashcode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}

	//toString
	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}
	

	public Coordenada clone() {
		Coordenada clone = new Coordenada(this.x, this.y);
		return clone;
	}
	
}
