package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Poderes {
	Image imagenPoder1;
	Image imagenPoder2;
	Image imagenPoder3;
	Image imagenPoder4;
	public Poderes() {
		//imagenPoder1 = Herramientas.cargarImagen("Hielo.png");
		imagenPoder2 = Herramientas.cargarImagen("BotonPoder2.png");
		imagenPoder3 = Herramientas.cargarImagen("BotonPoder3.png");
		imagenPoder4 = Herramientas.cargarImagen("BotonPoder4.png");
	}
	public void dibujar(Entorno e) {
		e.dibujarCirculo(100, 100, 25, Color.RED);
	}
}
