package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Botonera {
	Image botoneraPRINCIPAL,boton1,boton2,boton3,boton4,borde,fondoBotonera,botonPRINCIPAL,poderHielo,poderBolaFuego;
	double ancho,alto,x,y,bordeIzq,bordeDer,bordeArriba,bordeAbajo,ancho1,alto1,x1,y1,bordeIzq1,bordeDer1,bordeArriba1,bordeAbajo1;
	public Botonera() {
		fondoBotonera = Herramientas.cargarImagen("fondoBOTONERA.jpg");
		botoneraPRINCIPAL = Herramientas.cargarImagen("fondoBOTONERA 2.0.jpg");
		botonPRINCIPAL = Herramientas.cargarImagen("botonPRINCIPAL.png");
		// Boton 1
		this.x = 703;
		this.y = 200;
		this.ancho = 105;
		this.alto = 45;
		this.bordeIzq = x - ancho/2;
		this.bordeDer = x + ancho/2;
		this.bordeArriba = y - ancho/2;;
		this.bordeAbajo = y + ancho/2;;
		// Boton 2
		this.x1 = 703;
		this.y1 = 300;
		this.ancho1 = 105;
		this.alto1 = 45;
		this.bordeIzq1 = x1 - ancho1/2;
		this.bordeDer1 = x1 + ancho1/2;
		this.bordeArriba1 = y1 - ancho1/2;;
		this.bordeAbajo1 = y1 + ancho1/2;;
	}
	public void dibujar(Personaje personaje,Entorno e,boolean selec,boolean selec2) {
		e.dibujarImagen(fondoBotonera, 910, 300, 0, 1);
		e.dibujarImagen(botoneraPRINCIPAL, 705, 300, 0,0.5);
		e.dibujarImagen(botonPRINCIPAL, 705, 45, 0,0.3);
		e.cambiarFont("Felix Titling", 15, Color.BLACK, 1);
		e.escribirTexto("LISTA DE PODERES", 633, 50);
		if (selec == true) {
			e.dibujarRectangulo(x,y,ancho,alto,0,Color.DARK_GRAY);
		}else {
			e.dibujarRectangulo(x,y,ancho,alto,0,Color.GRAY);
		}
		if (selec2 == true) {
			e.dibujarRectangulo(x1,y1,ancho1,alto1,0,Color.DARK_GRAY);
		}else {
			e.dibujarRectangulo(x1,y1,ancho1,alto1,0,Color.GRAY);
		}
		// Poder 1:
		e.cambiarFont("Felix Titling", 14, Color.BLACK,1);
		e.escribirTexto("BOMBA DE FUEGO", 656, 205);
		// Poder 2:
		e.cambiarFont("Felix Titling", 14, Color.BLACK,1);
		e.escribirTexto("RAYO", 654, 305);
		// Estadisticas - Jugador
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("HP:", 655, 400);
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("MANA:", 650, 450);
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("PUNTUACIÓN:" + personaje.kills , 650, 520);
	}
}
