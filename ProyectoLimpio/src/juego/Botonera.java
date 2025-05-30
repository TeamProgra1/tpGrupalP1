package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Botonera {
	Image botoneraPRINCIPAL,boton1,boton2,boton3,boton4,borde,fondoBotonera,botonPRINCIPAL,poderHielo,poderBolaFuego;
	double ancho,alto,bordeSup,bordeInf,escala;
	
	public Botonera() {
		fondoBotonera = Herramientas.cargarImagen("fondoBOTONERA.jpg");
		botoneraPRINCIPAL = Herramientas.cargarImagen("fondoBOTONERA 2.0.jpg");
		botonPRINCIPAL = Herramientas.cargarImagen("botonPRINCIPAL.png");
		boton1 = Herramientas.cargarImagen("BotonPoder1.png");
		boton2 = Herramientas.cargarImagen("BotonPoder2.png");
		boton3 = Herramientas.cargarImagen("BotonPoder3.png");
		boton4 = Herramientas.cargarImagen("BotonPoder4.png");
		poderBolaFuego = Herramientas.cargarImagen("poderBolaFuego.png");
		poderHielo = Herramientas.cargarImagen("poderHielo.png");
		this.escala = 0.15;
		this.ancho = this.boton1.getWidth(null)/2 * this.escala;
		this.alto = this.boton1.getHeight(null)/2*this.escala;
	}
	public void dibujar(Entorno e) {
		e.dibujarImagen(fondoBotonera, 910, 300, 0, 1);
		e.dibujarImagen(botoneraPRINCIPAL, 705, 300, 0,0.5);
		e.dibujarImagen(botonPRINCIPAL, 705, 45, 0,0.3);
		e.cambiarFont("Arial", 15, Color.BLACK, 1);
		e.escribirTexto("LISTA DE PODERES", 633, 50);
		e.dibujarImagen(boton1, 705, 120, 0,0.15);
		e.dibujarImagen(boton2, 705, 210, 0,0.15);
		e.dibujarImagen(boton3, 705, 300, 0,0.15);
		e.dibujarImagen(boton4, 705, 400, 0,0.15);
		// Poder 1:
		e.cambiarFont("Bahnschrift SemiBold", 11, Color.RED,1);
		e.escribirTexto("BOLA FUEGO", 695, 124);
		// Poder 2:
		e.cambiarFont("Bahnschrift SemiBold", 10, Color.CYAN,1);
		e.escribirTexto("CONGELACIÓN", 695, 214);
		// Poder 3:
		e.cambiarFont("Bahnschrift SemiBold", 11, Color.DARK_GRAY,1);
		e.escribirTexto("Super Bomb", 695, 303);
		// Poder 4:
		e.cambiarFont("Bahnschrift SemiBold", 11, Color.DARK_GRAY,1);
		e.escribirTexto("Mega Bomb", 700, 403);
		e.dibujarImagen(poderHielo, 658, 210, 0, 0.08);
		e.dibujarImagen(poderBolaFuego, 655, 120, 0, 0.08);
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("HP:", 690, 450);
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("MANA:", 675, 500);
		
	}
}
