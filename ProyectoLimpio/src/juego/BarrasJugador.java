package juego;

import java.awt.Color;
import entorno.Entorno;

public class BarrasJugador {
		public void dibujar(Entorno e) {
			// Vida
			e.dibujarRectangulo(700,410, 105, 15, 0, Color.BLACK);
			e.dibujarRectangulo(700,410, 100, 10, 0, Color.GREEN);
			// Puntos de poder
			e.dibujarRectangulo(700,460, 105, 15, 0, Color.BLACK);
			e.dibujarRectangulo(700,460, 100, 10, 0, Color.CYAN);
		}
		public void bajaLaVida(Personaje personaje, Enemigo enemigo,Entorno e) {
				double dx = personaje.x - enemigo.x;
				double dy = personaje.y - enemigo.y;
				double distancia = Math.sqrt(dx * dx + dy * dy);
				if (distancia <= 1) {
					if (personaje.cooldown == 0 && personaje.vida > 0) {
			            personaje.vida -= 1;
			            personaje.cooldown = 120;
						}
				}
				e.dibujarRectangulo(700,410, 100, 10, 0, Color.RED);
				e.dibujarRectangulo(700 - (100 - personaje.vida) / 2,410, personaje.vida, 10, 0, Color.GREEN);
					if (personaje.cooldown > 0) {
						personaje.cooldown--;
					}
		}
}
		/*}
		public void Energia(Personaje personaje, Poderes poderes) {
				if 
		}*/