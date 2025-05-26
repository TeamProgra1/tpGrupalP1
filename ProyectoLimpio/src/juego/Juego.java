package juego;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
//import juego.NoSeleccionado;
//import juego.Seleccionado;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje p1;
	private Enemigo e1;
	private Fondo f;
	private Botonera b;
	//private Seleccionado s;
	//private NoSeleccionado notS;
	// Variables y métodos propios de cada grupo
	// .s..
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "DEMO en clase", 800, 600);
		this.f = new Fondo();
		this.p1 = new Personaje(300,400);
		this.e1 = new Enemigo(100,100);
		this.b = new Botonera();
		//this.s = new Seleccionado();
		//this.notS = new NoSeleccionado();
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
		this.f.dibujar(entorno);
		this.b.dibujar(entorno);
		this.e1.dibujar(entorno);
		boolean direccion = false;
		// boolean confirmarSelec = false;
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
		this.p1.dibujar(entorno, direccion);
		
		/* if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			confirmarSelec = true;
			this.s.dibujar(entorno,confirmarSelec);
		}else {
			confirmarSelec = false;
			this.s.dibujar(entorno, confirmarSelec);
		}*/
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
