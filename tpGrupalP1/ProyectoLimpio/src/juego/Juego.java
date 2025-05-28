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
	private Piedra piedra[];
	private boolean izq,der,arr,aba;
	private BarraDeVida BDV;
	// Variables y métodos propios de cada grupo
	// .s..
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "DEMO en clase", 800, 600);
		this.f = new Fondo();
		this.p1 = new Personaje(300,400);
		this.b = new Botonera();
		this.enemigos = new Enemigo[10];
		this.poderes = new Poderes();
		this.piedra = new Piedra[4];
		this.piedra[0] = new Piedra(150,200);
		this.piedra[1] = new Piedra(450,200);
		this.piedra[2] = new Piedra(450,450);
		this.piedra[3] = new Piedra(150,450);
		this.aba = false;
		this.arr = false;
		this.der = false;
		this.izq = false;
		//this.BDV = new BarraDeVida(700,600,0,0.3);
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
	}
		// Inicializar lo que haga falta para el juego
		// ...
		
		// Inicia el juego!
		this.entorno.iniciar();
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
		boolean direccion = false;
		this.p1.limitarMovimiento();
		for(int i = 0; i < piedra.length;i++) {
			colisionRoca(this.p1,this.piedra[i]);
		}
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA) && !this.arr) {
			this.p1.mover(-1,0);
		}
		if(entorno.estaPresionada(entorno.TECLA_ABAJO) && !this.aba) {
			this.p1.mover(1,0);
		}
		if(entorno.estaPresionada(entorno.TECLA_DERECHA) && !this.der) {
			direccion = true;
			this.p1.mover(0,1);
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && !this.izq) {
			this.p1.mover(0,-1);
		}
		
		// Seleccion de los poderes:
		/*boolean poderActivo = false;
		int mouseX = entorno.mouseX();
		int mouseY = entorno.mouseY();
		if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			
		}*/
				
		this.f.dibujar(entorno);
		this.b.dibujar(entorno);
		this.piedra[0].dibujar(entorno);
		this.piedra[1].dibujar(entorno);
		this.piedra[2].dibujar(entorno);
		this.piedra[3].dibujar(entorno);
		this.p1.dibujar(entorno, direccion);
		for (Enemigo e : enemigos) {
			double aleatorio = Math.random()*10;
			if (aleatorio < 7) {
				e.moverHacia(p1.x,p1.y);
			}else {
				int x1 = (int)Math.random()* entorno.ancho() - b.fondoBotonera.getWidth(null);
				int y1 = (int)Math.random()* entorno.alto() - b.fondoBotonera.getHeight(null);
				e.moverHacia(-p1.x,-p1.y);
			}
			e.dibujar(entorno);
		}
		
		this.poderes.dibujar(entorno);
		
		this.aba = false;
		this.arr = false;
		this.der = false;
		this.izq = false;
}
	public void dibujar(Entorno e) {
		for (Enemigo e1 : enemigos) {
			e1.dibujar(entorno);
		}
	}
	void colisionRoca(Personaje p1,Piedra p) {
		if(Math.abs(p1.bordIz - p.bordDe) < 1 && p1.bordSu < p.bordIn && p1.bordIn > p.bordSu){
			this.izq = true;
		}
		if(Math.abs(p1.bordDe - p.bordIz) < 1 && p1.bordSu < p.bordIn && p1.bordIn > p.bordSu) {
			this.der = true;
		}
		if(Math.abs(p1.bordIn - p.bordSu) < 1 && p1.bordDe > p.bordIz && p1.bordIz < p.bordDe) {
			this.aba = true;
		}
		if(Math.abs(p1.bordSu - p.bordIn) < 1 && p1.bordDe > p.bordIz && p1.bordIz < p.bordDe) {
			this.arr = true;
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}