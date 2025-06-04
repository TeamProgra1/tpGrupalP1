package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Personaje {
	double x,y,alto,ancho,escala,bordIn,bordSu,bordIz,bordDe;
	Image imagen,imagen2;
	int vida,energia,cooldownEnergia;
	int kills = 0;
	boolean poderActivo = false;
	boolean poderActivo2 = false;
	boolean consumirEnergia,consumirEnergia2,victoria;
	
	public Personaje(double x,double y) {
		this.vida = 100;
		this.energia = 10;
		this.x=x;
		this.y=y;
		this.imagen = Herramientas.cargarImagen("MAGOPOSIZ.png");
		this.imagen2 = Herramientas.cargarImagen("MAGOPOSDER.png");
		this.escala = 0.11;
		this.alto = this.imagen.getHeight(null) * this.escala;
		this.ancho = this.imagen.getWidth(null) * this.escala;
		this.bordIn = y + this.alto / 2;
		this.bordSu = y - this.alto / 2;
		this.bordIz = x - this.ancho / 2;
		this.bordDe = x + this.ancho / 2;
	}
	
	public void dibujar(Entorno e,boolean a) {
		if (a == false) {
			e.dibujarImagen(this.imagen, this.x, this.y, 0,this.escala);
		}else {
			e.dibujarImagen(this.imagen2, this.x, this.y, 0,this.escala);
		}
	}
	
	public void mover(int vertical,int horizontal) {
			this.x += horizontal;
			this.y += vertical;
			this.bordIn = y + this.alto / 2;
			this.bordSu = y - this.alto / 2;
			this.bordIz = x - this.ancho / 2;
			this.bordDe = x + this.ancho / 2;
			
	}
	public void limitarMovimiento() {
		if (this.x >= 555.0) {
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
	public void puntuacion(Enemigo enemigo,BombaFuego bombaFuego) {
		if (enemigo != null) {
			if(enemigo.fueAlcanzado || enemigo.fueAlcanzado1) {
				this.kills++;
			}
			if (this.kills == 70) {
				this.victoria = true;
				}
			}
		}
		
	}
