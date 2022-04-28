package elementos;

import java.util.Objects;

import logicaJuego.Constantes;

public class Coordenada {

	private int x;
	private int y;
	
	
	//constructores
	public Coordenada() {
		super();
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
		if(x >= 0 && x<= Constantes.TAMANNO) {
			this.x = x;	
		}else {
			this.x = 0;
		}
		
	}

	private void setY(int y) {
		if(y >= 0 && y<= Constantes.TAMANNO) {
			this.y = y;	
		}else {
			this.y = 0;
		}
	}

	//hashcode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	//metodos

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
	
	
	
}
