package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class BombaFuego{
	double x,y,ancho,alto,escala;
	int daño = 2;
	Image poder1;
	public BombaFuego(Entorno e) {
		poder1 = Herramientas.cargarImagen("bombaFuego.gif");
		escala = 0.2;
		ancho = this.poder1.getWidth(null)*escala;
		alto = this.poder1.getHeight(null)*escala;
		
	}
	public void dibujar(double x,double y,Entorno e) {
		e.dibujarImagen(poder1,x, y, 0,escala);
	}
	public boolean alcanzoAlEnemigo(Enemigo enemigo,double posicionMouseX,double posicionMouseY) {
		if (enemigo != null) {
			double rango = 50;
			
			if (enemigo.x >= posicionMouseX - rango / 2 && enemigo.x <= posicionMouseX + rango / 2 && enemigo.y >= posicionMouseY - rango / 2 && enemigo.y <= posicionMouseY + rango / 2) {
				enemigo.fueAlcanzado = true;
			}
		}
		return enemigo.fueAlcanzado;
	}
}
