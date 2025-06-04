package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

	public class Enemigo {
		int vida;
		boolean fueAlcanzado1 = false;
		boolean fueAlcanzado = false;
		boolean alcanzoAlMago = false;
		boolean muerto = false;
		double x,y;
		Image murcielago;
		
		public Enemigo(double x,double y) {
			this.vida = 1;
			this.x=x;
			this.y=y;
			this.murcielago = Herramientas.cargarImagen("MURCIELAGO.gif");
		}
		
		public void dibujar(Entorno e) {
			e.dibujarImagen(this.murcielago, this.x, this.y, 0,0.41);
		}
			public void moverHacia(double px, double py) {
				if (this.murcielago != null) {
					double dx = px - this.x;
				    double dy = py - this.y;
				    double distancia = Math.sqrt(dx * dx + dy * dy);
				    double desviacion = 0.2;
				    dx += (Math.random() - 0.5)*desviacion;
				    dy += (Math.random() - 0.6)*desviacion;

				    if (distancia > 1) {
				        double moverX = dx / distancia;
				        double moverY = dy / distancia;
				        this.x += moverX * Math.random();
				        this.y += moverY * Math.random();
				    }else {
				    	if (murcielago != null && distancia <= 5) {
				    			this.alcanzoAlMago = true;
				    		}else {
				    			this.alcanzoAlMago = false;
				    }
				    }
				}
		}
	}