package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Botonera {
	Image botoneraPRINCIPAL;
	Image boton1;
	Image boton2;
	Image boton3;
	Image boton4;
	Image borde;
	Image fondoBotonera;
	Image botonPRINCIPAL;
	int posAnchoB1;
	Image poderHielo;
	Image poderBolaFuego;
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
	}
	public void dibujar(Entorno e) {
		e.dibujarImagen(fondoBotonera, 910, 300, 0, 1);
		e.dibujarImagen(botoneraPRINCIPAL, 705, 300, 0,0.5);
		e.dibujarImagen(botonPRINCIPAL, 705, 45, 0,0.3);
		e.cambiarFont("Arial", 15, Color.BLACK, 1);
		e.escribirTexto("LISTA DE PODERES", 633, 50);
		e.dibujarImagen(boton1, 705, 120, 0,0.15);
		e.dibujarImagen(boton2, 705, 240, 0,0.15);
		e.dibujarImagen(boton3, 705, 360, 0,0.15);
		e.dibujarImagen(boton4, 705, 480, 0,0.15);
		// Poder 1:
		e.cambiarFont("Bahnschrift SemiBold", 11, Color.RED,1);
		e.escribirTexto("BOLA FUEGO", 695, 123);
		// Poder 2:
		e.cambiarFont("Bahnschrift SemiBold", 9, Color.CYAN,1);
		e.escribirTexto("CONGELACIÓN", 695, 243);
		// Poder 3:
		e.cambiarFont("Bahnschrift SemiBold", 11, Color.DARK_GRAY,1);
		e.escribirTexto("Super Bomb", 694, 363);
		// Poder 4:
		e.cambiarFont("Bahnschrift SemiBold", 11, Color.DARK_GRAY,1);
		e.escribirTexto("Mega Bomb", 694, 483);
		e.dibujarImagen(poderHielo, 658, 240, 0, 0.08);
		e.dibujarImagen(poderBolaFuego, 655, 120, 0, 0.08);
		
	}
}
