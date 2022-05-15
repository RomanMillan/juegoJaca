package main;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.PlayerType;

public class principalAux {

	public static void main(String[] args) {

		
		Coordenada coord = new Coordenada(10,1);
		System.out.println(coord);
//		coord.goDown();
//		System.out.println(coord);
//
//		coord = new Coordenada(1,9);
//		System.out.println(coord);
//		coord.goDown();
//		System.out.println(coord);
//		

		Jugador j = new Jugador(ElementType.ELFO);
		System.out.println(j.getVelocidadParaLuchar());
		
	}

}
