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
			this.imagen2 = Herramientas.cargarImagen("murci.png");
		}
		
		public void dibujar(Entorno e) {
			e.dibujarImagen(this.imagen2, this.x, this.y, 0,0.10);
		}

}
