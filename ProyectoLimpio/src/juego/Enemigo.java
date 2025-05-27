package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

	public class Enemigo {
		double x,y;
		Image imagen2;
		
		public Enemigo(double x,double y) {
			this.x=x;
			this.y=y;
			this.imagen2 = Herramientas.cargarImagen("MURCIELAGO.gif");
		}
		
		public void dibujar(Entorno e) {
			e.dibujarImagen(this.imagen2, this.x, this.y, 0,0.5);
		}

		public void moverHacia(double px, double py) {
			double dx = px - this.x;
		    double dy = py - this.y;
		    double distancia = Math.sqrt(dx * dx + dy * dy);

		    if (distancia > 1) {
		        double moverX = dx / distancia;
		        double moverY = dy / distancia;
		        this.x += moverX * Math.random();
		        this.y += moverY * Math.random();
		    }
		}
}