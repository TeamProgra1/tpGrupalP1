package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Piedra {
		Image piedra;
		double x,y,alto,ancho,escala,bordIn,bordSu,bordIz,bordDe;
		public Piedra(double x,double y) {
			this.x=x;
			this.y=y;
			this.piedra = Herramientas.cargarImagen("piedra.png");
			this.escala = 0.15;
			this.alto = this.piedra.getHeight(null) * this.escala;
			this.ancho = this.piedra.getWidth(null) * this.escala;
			this.bordIn = y + this.alto / 3.5;
			this.bordSu = y - this.alto / 1.5;
			this.bordIz = x - this.ancho / 1.5;
			this.bordDe = x + this.ancho /1.5;
		}
		public void dibujar(Entorno e) {
				e.dibujarImagen(this.piedra, this.x,this.y,0,this.escala);
			}
		}
