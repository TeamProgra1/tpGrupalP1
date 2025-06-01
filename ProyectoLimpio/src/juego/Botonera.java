package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Botonera {
	Image botoneraPRINCIPAL,boton1,boton2,boton3,boton4,borde,fondoBotonera,botonPRINCIPAL,poderHielo,poderBolaFuego;
	double ancho1,alto1,ancho2,alto2,bordeSup1,bordeInf1,bordeDer1,bordeIzq1,bordeSup2,bordeInf2,bordeDer2,bordeIzq2,escala;
	double x1,y1,x2,y2;
	public Botonera() {
		fondoBotonera = Herramientas.cargarImagen("fondoBOTONERA.jpg");
		botoneraPRINCIPAL = Herramientas.cargarImagen("fondoBOTONERA 2.0.jpg");
		botonPRINCIPAL = Herramientas.cargarImagen("botonPRINCIPAL.png");
		boton1 = Herramientas.cargarImagen("BotonPoder1.png");
		boton2 = Herramientas.cargarImagen("BotonPoder2.png");
		escala = 0.2;
		this.ancho1 = this.boton1.getWidth(null)/2*escala;
		this.alto1 = this.boton1.getHeight(null)/2*escala;
		this.bordeInf1 = y1 + this.alto1 / 2;
		this.bordeSup1 = y1 - this.alto1 / 2;
		this.bordeIzq1 = x1 - this.ancho1 / 2;
		this.bordeDer1 = x1 + this.ancho1 / 2;
		//
		this.ancho2 = this.boton2.getWidth(null)/2*escala;
		this.alto2 = this.boton2.getHeight(null)/2*escala;
		this.bordeInf2 = y2 + this.alto2 / 2;
		this.bordeSup2 = y2 - this.alto2 / 2;
		this.bordeIzq2 = x2 - this.ancho2 / 2;
		this.bordeDer2 = x2 + this.ancho2 / 2;
	}
	public void dibujar(double x1,double y1,double x2,double y2,Entorno e) {
		e.dibujarImagen(fondoBotonera, 910, 300, 0, 1);
		e.dibujarImagen(botoneraPRINCIPAL, 705, 300, 0,0.5);
		e.dibujarImagen(botonPRINCIPAL, 705, 45, 0,0.3);
		e.cambiarFont("Felix Titling", 15, Color.BLACK, 1);
		e.escribirTexto("LISTA DE PODERES", 633, 50);
		e.dibujarImagen(boton1, x1,y1 , 0,escala);
		e.dibujarImagen(boton2, x2, y2, 0,escala);
		// Poder 1:
		e.cambiarFont("Felix Titling", 11, Color.BLACK,1);
		e.escribirTexto("BOMBA DE AGUA", 656, 205);
		// Poder 2:
		e.cambiarFont("Felix Titling", 12, Color.BLACK,1);
		e.escribirTexto("BOLA DE FUEGO", 654, 305);
		// Estadisticas - Jugador
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("HP:", 690, 400);
		e.cambiarFont("Bahnschrift SemiBold", 14, Color.WHITE,1);
		e.escribirTexto("MANA:", 675, 450);
		
	}
}
