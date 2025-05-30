package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class BarrasJugador {
		public void dibujar(Entorno e) {
			// Vida
			e.dibujarRectangulo(700,460, 105, 15, 0, Color.BLACK);
			e.dibujarRectangulo(700,460, 100, 10, 0, Color.GREEN);
			// Puntos de poder
			e.dibujarRectangulo(700,510, 105, 15, 0, Color.BLACK);
			e.dibujarRectangulo(700,510, 100, 10, 0, Color.BLUE);
		}
		public void quitarVida(Entorno e) {
				e.dibujarRectangulo(700,460, 90, 10, 0, Color.GRAY);
		}
		
}
