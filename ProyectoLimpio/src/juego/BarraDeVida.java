package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class BarraDeVida {
		Image vida100,vida75,vida50,vida30,vida5,vida0;
		public BarraDeVida() {
			vida100 = Herramientas.cargarImagen("100%.png");
			vida75 = Herramientas.cargarImagen("75%.png");
			vida50 = Herramientas.cargarImagen("50%.png");
			vida30 = Herramientas.cargarImagen("30%.png");
			vida5 = Herramientas.cargarImagen("5%.png");
			vida0 = Herramientas.cargarImagen("0%.png");
		}
		public void dibujar(Entorno e) {
			e.dibujarImagen(vida100, 700, 600, 0, 0.3);
			e.dibujarImagen(vida75, 700, 700, 0, 0.3);
			e.dibujarImagen(vida50, 700, 700, 0, 0.3);
			e.dibujarImagen(vida30, 700, 700, 0, 0.3);
			e.dibujarImagen(vida5, 700, 700, 0, 0.3);
			e.dibujarImagen(vida0, 700, 700, 0, 0.3);
		}
}
