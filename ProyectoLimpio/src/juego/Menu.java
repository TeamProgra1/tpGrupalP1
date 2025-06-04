package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Menu {
	Image menu;
	Image botonSTART,botonSTART2;
	int x,y,alto,ancho,izq,der,arr,abajo;
	public Menu() {
		menu = Herramientas.cargarImagen("fondoMENU.gif");
		botonSTART = Herramientas.cargarImagen("botonSTART.png"); 
		botonSTART2 = Herramientas.cargarImagen("botonSTART_1.png"); 
		this.x = 400;
		this.y = 500;
		this.ancho = 105;
		this.alto = 50;
		this.izq = x - ancho/2;
		this.der = x + ancho/2;
		this.arr = y - alto/2;
		this.abajo = y + alto/2;
	}
	public void dibujar(Entorno e,boolean t) {
		e.dibujarImagen(menu, 400, 300, 0, 1.3);
		e.dibujarRectangulo(x, y, ancho , alto, 0, Color.GRAY);
		e.dibujarImagen(botonSTART,400, 500,0,0.3);
		if (t == true) {
			e.dibujarImagen(botonSTART2,400, 500,0,0.3);
		}
		e.cambiarFont("Felix Titling", 35, Color.YELLOW,1);
		e.escribirTexto("GONDOLF", 310, 66);
	}
}
