package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rayo{
	double x,y,ancho,alto,escala;
	int daño = 2;
	Image poder1;
	public Rayo(Entorno e) {
		poder1 = Herramientas.cargarImagen("rayo.png");
		escala = 0.5;
		ancho = this.poder1.getWidth(null)*escala;
		alto = this.poder1.getHeight(null)*escala;
		
	}
	public void dibujar(double x,double y,Entorno e) {
		e.dibujarImagen(poder1,x, y, 0,escala);
	}
	public void alcanzoAlEnemigo1(Enemigo enemigo,double posicionMouseX,double posicionMouseY) {
		if (enemigo != null) {
			double rango = 70;
			
			if (enemigo.x >= posicionMouseX - rango / 2 && enemigo.x <= posicionMouseX + rango / 2 && enemigo.y >= posicionMouseY - rango / 2 && enemigo.y <= posicionMouseY + rango / 2) {
				enemigo.fueAlcanzado1 = true;
			}
		}
	}
}
