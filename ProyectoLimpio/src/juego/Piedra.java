package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Piedra {
		Image piedra;
		double x, y,bordeIzq, bordeDer,bordeInf,bordeSup,escala,alto,ancho;
		public Piedra(double x,double y) {
			this.x = x;
			this.y = y;
			this.escala = 0.3;
			piedra = Herramientas.cargarImagen("piedra.png");
			this.alto = this.piedra.getHeight(null)*escala;
			this.ancho = this.piedra.getWidth(null)*escala;
			bordeIzq = x - this.ancho/2;
			bordeDer = x + this.ancho/2;
			bordeSup = y - this.alto/2;
			bordeInf = y + this.alto/2;
		}
		public void dibujar(Entorno e) {
				e.dibujarImagen(piedra, this.x,this.y,0,escala);
			}
		}
