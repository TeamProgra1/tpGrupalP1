package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Poderes {
	double x,y,ancho,alto,escala,bordIn,bordSu,bordIz,bordDe;
	Image poder1;
	public Poderes() {
		poder1 = Herramientas.cargarImagen("BombaAgua.png");
		escala = 0.2;
		ancho = this.poder1.getWidth(null)/2*escala;
		alto = this.poder1.getHeight(null)/2*escala;
		this.bordIn = y + this.alto / 2;
		this.bordSu = y - this.alto / 2;
		this.bordIz = x - this.ancho / 2;
		this.bordDe = x + this.ancho / 2;
		
	}
	public void dibujar(double x,double y,Entorno e) {
		e.dibujarImagen(poder1,x, y, 0,escala);
	}
	public boolean alcanzoAlEnemigo(Enemigo enemigo) {
		if (enemigo.x >= x && enemigo.x <= ancho && enemigo.y >= y && enemigo.y <= alto) {
			return true;
		}
		return false;
	}
}
