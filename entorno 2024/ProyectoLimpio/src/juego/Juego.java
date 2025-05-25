package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje p1;
	private Enemigo e1;
	
	// Variables y métodos propios de cada grupo
	// .s..
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "DEMO en clase", 800, 600);
		this.p1 = new Personaje(300,400);
		this.e1 = new Enemigo(300,400);
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		this.p1.dibujar(entorno);
		this.e1.dibujar(entorno);
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			this.p1.mover(-1,0);
		}
		if(entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			this.p1.mover(1,0);
		}
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			this.p1.mover(0,1);
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			this.p1.mover(0,-1);
		}
		
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
