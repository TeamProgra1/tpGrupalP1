package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Personaje {
	double x,y,bordeInf,bordeSup,bordeDer,bordeIzq,escala,alto,ancho;
	Image imagen,imagen2;
	
	public Personaje(double x,double y) {
		this.x=x;
		this.y=y;
		this.imagen = Herramientas.cargarImagen("MAGOPOSIZ.png");
		this.imagen2 = Herramientas.cargarImagen("MAGOPOSDER.png");
		escala = 0.14;
		this.alto = this.imagen.getHeight(null)*escala;
		this.ancho = this.imagen.getWidth(null)*escala;
		bordeIzq = x - this.ancho/2;
		bordeDer = x + this.ancho/2;
		bordeSup = y - this.alto/2;
		bordeInf = y + this.alto/2;
	}
	
	public void dibujar(Entorno e,boolean a) {
		if (a == false) {
			e.dibujarImagen(this.imagen, this.x, this.y, 0,escala);
		}else {
			e.dibujarImagen(this.imagen2, this.x, this.y, 0,escala);
		}
	}
	
	public void mover(int vertical,int horizontal) {
			this.x += horizontal;
			this.y += vertical;
			bordeIzq = x - this.ancho/2;
			bordeDer = x + this.ancho/2;
			bordeSup = y - this.alto/2;
			bordeInf = y + this.alto/2;
			
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
