package juego;
import entorno.Herramientas;

import java.awt.Image;

import entorno.Entorno;
public class Fondo {
	Image fondo;
	public Fondo(){
		fondo = Herramientas.cargarImagen("fondo.jpeg");
	}
	public void dibujar(Entorno e) {
		e.dibujarImagen(fondo, 335, 300, 0,1.25);
	}
}
