package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Seleccionado {
	Seleccionado s = new Seleccionado();
	Image confirmado;
	public void dibujar(Entorno e,boolean x) {
		confirmado = Herramientas.cargarImagen("confirmado.jpg");
		if (x == true)  {
			e.dibujarImagen(confirmado, 400, 300, 0,1);
		}
	}
}