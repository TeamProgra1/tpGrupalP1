package juego;
import entorno.Herramientas;

import java.awt.Image;

import entorno.Entorno;
public class Fondo {
	Image fondo;
	public Fondo(){
		fondo = Herramientas.cargarImagen("fondoDelJuego.jpeg");
	}
	public void dibujar(Entorno e) {
		e.dibujarImagen(fondo, 300, 300, 0,1.15);
	}
	
}
