package juego;

import java.awt.Color;
import entorno.Entorno;

public class BarrasJugador {
		public void dibujar(Entorno e,Personaje personaje) {
			// Vida
			if (personaje.vida > 0) {
			e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
			e.escribirTexto("("+personaje.vida+"/"+"100" + ")",680, 400);
			e.dibujarRectangulo(700,410, 105, 15, 0, Color.BLACK);
			e.dibujarRectangulo(700 - (100 - personaje.vida) / 2,410, personaje.vida, 10, 0, Color.GREEN);
			if (personaje.vida <= 0) {
				personaje.vida = 0;
				e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
				e.escribirTexto("("+personaje.vida+"/"+"100" + ")",680, 400);
				e.dibujarRectangulo(700,410, 105, 15, 0, Color.BLACK);
				e.dibujarRectangulo(700 - personaje.vida,410, personaje.vida, 10, 0, Color.GREEN);
			}
			// Puntos de poder
				e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
				e.escribirTexto("("+personaje.energia+"/"+"10" + ")",700, 450);
				e.dibujarRectangulo(700,460, 105, 15, 0, Color.BLACK);
				double energiaMax = 10.0;
				double anchoTotal = 100.0;
				double anchoActual = personaje.energia * (anchoTotal / energiaMax);
				double x = 650 + anchoActual / 2;
				e.dibujarRectangulo(x, 460, anchoActual, 10, 0, Color.CYAN);
			}

}
		public void bajaLaVida(Personaje personaje, Enemigo enemigo,Entorno e) {
				if (enemigo.alcanzoAlMago) {
					if (personaje.vida > 0) {
			            personaje.vida -= 5;
						}else {
							personaje.vida = 0;
						}
				}
				}
		public void bajaLaEnergia(Personaje personaje) {
				if (personaje.energia < 0) {
					personaje.energia = 0;
				}
				if (personaje.poderActivo && personaje.consumirEnergia) {
					if (personaje.energia > 0 && personaje.energia > 1) {
						personaje.energia -= 2;
					
				}else {
					personaje.poderActivo = false;
				}
				}
				if (personaje.poderActivo2 && personaje.consumirEnergia2) {
					if (personaje.energia > 0 && personaje.energia > 2) {
						personaje.energia -= 3;
				}else {
					personaje.poderActivo2 = false;
				}
				}
		
					personaje.consumirEnergia = false;
					personaje.consumirEnergia2 = false;
					
			        if (personaje.energia <= 0) {
			            personaje.poderActivo = false;
			            personaje.poderActivo2 = false;
			          
			        }
			        	if (personaje.cooldownEnergia > 0) {
			        		personaje.cooldownEnergia --;
					}
					if (personaje.cooldownEnergia == 0 && personaje.energia < 10 ){
							personaje.energia ++;
							personaje.cooldownEnergia = 120;
						}	
		}
}