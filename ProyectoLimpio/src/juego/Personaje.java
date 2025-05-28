package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Personaje {
	double x;
	double y;
	Image imagen;
	Image imagen2;
	Image imagen3;
	
	public Personaje(double x,double y) {
		this.x=x;
		this.y=y;
		this.imagen = Herramientas.cargarImagen("MAGOPOSIZ.png");
		this.imagen2 = Herramientas.cargarImagen("MAGOPOSDER.png");
	}
	
	public void dibujar(Entorno e,boolean a) {
		if (a == false) {
			e.dibujarImagen(this.imagen, this.x, this.y, 0,0.14);
		}else {
			e.dibujarImagen(this.imagen2, this.x, this.y, 0,0.14);
		}
	}
	
	public void mover(int vertical,int horizontal) {
			this.x += horizontal;
			this.y += vertical;
	}
	public void limitarMovimiento() {
		if (this.x >= 550.0) {
			this.x -= 2;
		}else {
			if(this.y >= 550.0) {
				this.y -= 2;
			}else {
				if (this.x <= 50) {
					this.x += 2;
				}else {
					if (this.y <= 50) {
						this.y += 2;
					}
				}
			}
		}
	}
}
