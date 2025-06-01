package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Poderes {
	double x,y;
	Image poder1;
	int energia;
	public Poderes() {
		this.energia = 50;
		poder1 = Herramientas.cargarImagen("BombaAgua.png");
	}
	public void dibujar(double x,double y,Entorno e) {
		e.dibujarImagen(poder1,x, y, 0,0.2);
	}
}
