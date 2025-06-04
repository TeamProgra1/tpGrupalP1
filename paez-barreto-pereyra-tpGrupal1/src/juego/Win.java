package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Win {
	Image win;
	public Win() {
		win = Herramientas.cargarImagen("win.jpg");
	}
	public void dibujar(Entorno e,boolean w) {
		if (w == true) {
			e.dibujarImagen(this.win, 385, 300, 0,2.4);
	}
}
}
