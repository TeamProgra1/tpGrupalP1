package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
	
public class GameOver {
	Image gameOver;
	int x,y,alto,ancho,izq,der,arr,abajo;
	public GameOver() {
		gameOver = Herramientas.cargarImagen("gameover.png");
	}
	public void dibujar(Entorno e,boolean t) {
		if (t == true) {
			e.dibujarImagen(this.gameOver, 400, 300, 0,1.75);
		}
		}
	}
