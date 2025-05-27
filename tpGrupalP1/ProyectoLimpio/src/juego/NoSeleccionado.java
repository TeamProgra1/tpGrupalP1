package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class NoSeleccionado {
	NoSeleccionado notS = new NoSeleccionado();
	Image noConfirmado;
	public void dibujar(Entorno e,boolean x) {
		noConfirmado = Herramientas.cargarImagen("eliminado.jpg");
		if (x == false) {
			e.dibujarImagen(noConfirmado, 400, 300, 0,1);
		}
	}
}
