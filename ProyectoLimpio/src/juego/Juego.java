package juego;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje p1;
	private Fondo f;
	private Botonera b;
	private Enemigo enemigos[];
	private Poderes poderes;
	// Variables y métodos propios de cada grupo
	// .s..
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "DEMO en clase", 800, 600);
		this.f = new Fondo();
		this.p1 = new Personaje(300,400);
		this.b = new Botonera();
		this.enemigos = new Enemigo[1];
		this.poderes = new Poderes();
		// Posicion de los Enemigos
		for (int i = 0; i < enemigos.length ; i++) {
			int pos = (int) (Math.random()*10);
			int pos2 = (int) (Math.random()*10);
			if (pos == 0 || pos == 1 || pos == 2 || pos2 == 0 || pos2 == 1 || pos2 == 2) {
				double x = -50;
				double y = Math.random() * 560;
				enemigos[i] = new Enemigo(x,y);
			}else {
				if (pos == 3 || pos == 4 || pos == 5|| pos2 == 3 || pos2 == 4 || pos2 == 5) {
					double x = 570;
					double y = Math.random() * 800;
					enemigos[i] = new Enemigo(x,y);
				}else {
					if (pos == 6 || pos == 7 || pos == 8|| pos2 == 6 || pos2 == 7 || pos2 == 8) {
						double x = Math.random()*360;
						double y = -50;
						enemigos[i] = new Enemigo(x,y);
				}else {
					double x = Math.random() * 480;
					double y = 650;
					enemigos[i] = new Enemigo(x,y);
				}
		}
		// Inicializar lo que haga falta para el juego
		// ...
		
		// Inicia el juego!
		this.entorno.iniciar();
				   }
			}
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
		this.f.dibujar(entorno);
		this.b.dibujar(entorno);
		boolean direccion = false;
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			this.p1.mover(-1,0);
		}
		if(entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			this.p1.mover(1,0);
		}
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			direccion = true;
			this.p1.mover(0,1);
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			this.p1.mover(0,-1);
		}
		for (Enemigo e : enemigos) {
			e.moverHacia(p1.x,p1.y);
			e.dibujar(entorno);
		}
		this.p1.dibujar(entorno, direccion);
		this.p1.limitarMovimiento();
		this.poderes.dibujar(entorno);
		// Seleccion de los poderes:
		boolean poderActivo = false;
		int mouseX = entorno.mouseX();
		int mouseY = entorno.mouseY();
		if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			
		}
}
	public void dibujar(Entorno e) {
		for (Enemigo e1 : enemigos) {
			e1.dibujar(entorno);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}