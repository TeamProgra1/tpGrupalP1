package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Personaje {
	double x,y;
	Image imagen;
	
	public Personaje(double x,double y) {
		this.x=x;
		this.y=y;
		this.imagen = Herramientas.cargarImagen("perro.jpg");
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(this.imagen, this.x, this.y, 0,0.5);
	}
	
	public void mover(int vertical,int horizontal) {
			this.x += horizontal;
			this.y += vertical;
	}
}
