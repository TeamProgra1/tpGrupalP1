package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	private Entorno entorno;
	private Menu menu;
	private Personaje p1;
	private Fondo f;
	private GameOver g;
	private Win w;
	private Rayo rayo;
	private Botonera b;
	private Enemigo e;
	private Enemigo enemigos[];
	private boolean iniciaJuego;
	private int enemigosActivos;
	private int enemigosVivos;
	private int enemigosMuertos;
	private BombaFuego bombaFuego;
	private Piedra piedra[];
	private boolean izq,der,arr,aba;
	private BarrasJugador barrasJugador;
	private boolean estadoDelPoder;
	private boolean estadoDelPoder2;
	private boolean estaSeleccionado;
	private boolean estaSeleccionado2;
	private boolean termina;
	private boolean gano;
	private  boolean estaEncima;
	private int duracionPoder = 0;
	private int xPoder = 0;
	private int yPoder = 0;
	private int duracionPoder2 = 0;
	private int xPoder2 = 0;
	private int yPoder2 = 0;
	
	Juego()
	{
		this.entorno = new Entorno(this, "DEMO en clase", 800, 600);
		this.menu = new Menu();
		this.f = new Fondo();
		this.p1 = new Personaje(300,400);
		this.b = new Botonera();
		this.w = new Win();
		this.g = new GameOver();
		this.rayo = new Rayo(entorno);
		this.enemigos = new Enemigo[100];
		this.enemigosActivos = enemigos.length/2;
		this.enemigosVivos = 0;
		this.enemigosMuertos = 0;
		this.bombaFuego = new BombaFuego(entorno);
		this.piedra = new Piedra[4];
		this.piedra[0] = new Piedra(150,200);
		this.piedra[1] = new Piedra(450,200);
		this.piedra[2] = new Piedra(450,450);
		this.piedra[3] = new Piedra(150,450);
		this.barrasJugador = new BarrasJugador();
		this.aba = false;
		this.arr = false;
		this.der = false;
		this.izq = false;
		this.estaSeleccionado = false;
		this.estadoDelPoder = false;
		this.termina = false;
		this.estaEncima = false;
		
		// Posicion de los Enemigos
		for (int i = 0; i < enemigos.length; i++) {
					int pos = (int) (Math.random()*10);
					int pos2 = (int) (Math.random()*10);
				if (pos == 0 || pos == 1 || pos == 2 || pos2 == 0 || pos2 == 1 || pos2 == 2) {
					double x = -50;
					double y = Math.random() * 560;
					enemigos[i] = new Enemigo(x,y);
				}else {
					if (pos == 3 || pos == 4 || pos == 5|| pos2 == 3 || pos2 == 4 || pos2 == 5) {
						double x = 575;
						double y = Math.random() * 800;
						enemigos[i] = new Enemigo(x,y);
					}else {
						if (pos == 6 || pos == 7 || pos == 8|| pos2 == 6 || pos2 == 7 || pos2 == 8) {
							double x = Math.random()*360;
							double y = -50;
							enemigos[i] = new Enemigo(x,y);
					}else {
						double x = Math.random() * 500;
						double y = 650;
						enemigos[i] = new Enemigo(x,y);
						}
					}
				}
		}
		this.entorno.iniciar();
        }
	public void tick()
	{
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
		int mouseX = entorno.mouseX();
		int mouseY = entorno.mouseY();
		if (mouseX >= menu.izq && mouseX<= menu.der &&
		        mouseY >= menu.arr && mouseY <= menu.abajo) {
					estaEncima = true;
		}else {
			estaEncima = false;
		}
		this.menu.dibujar(entorno,this.estaEncima);
		botonesMenu();
		if (iniciaJuego == true) {
			this.f.dibujar(entorno);
			this.b.dibujar(p1,entorno,this.estaSeleccionado,this.estaSeleccionado2);
			this.barrasJugador.dibujar(entorno,p1);	
			this.piedra[0].dibujar(entorno);
			this.piedra[1].dibujar(entorno);
			this.piedra[2].dibujar(entorno);
			this.piedra[3].dibujar(entorno);
			this.p1.dibujar(entorno, direccion);

			for (Enemigo e1 : enemigos) {
				if (e1 != null) {
					e1.dibujar(entorno);
					}
			}	
			for (int i = 0; i < enemigos.length; i++) {
			    Enemigo e = enemigos[i];

			    if (e != null) {
			    	enemigosVivos++;
			        double aleatorio = Math.random() * 10;

			        if (aleatorio < 7) {
			            e.moverHacia(p1.x, p1.y);
			        } else {
			            e.moverHacia(-p1.x, -p1.y);
			        }

			        e.dibujar(entorno);

			        if (e.alcanzoAlMago) {
			            this.barrasJugador.bajaLaVida(p1, e, entorno);
			            enemigos[i] = null;
			            enemigosMuertos++;
			        }else if (enemigos[i].fueAlcanzado || enemigos[i].fueAlcanzado1) {
			        	enemigos[i] = null;
			        	enemigosMuertos++;
			        }
			    }
			}
			if (enemigosMuertos == enemigosActivos) {
			    for (int k = 0; k < enemigos.length; k++) {
			    	if (enemigos[k] == null) {
			        	int pos = (int) (Math.random()*10);
						int pos2 = (int) (Math.random()*10);
						if (pos == 0 || pos == 1 || pos == 2 || pos2 == 0 || pos2 == 1 || pos2 == 2) {
							double x = -50;
							double y = Math.random() * 560;
							enemigos[k] = new Enemigo(x,y);
						}else {
							if (pos == 3 || pos == 4 || pos == 5|| pos2 == 3 || pos2 == 4 || pos2 == 5) {
								double x = 575;
								double y = Math.random() * 800;
								enemigos[k] = new Enemigo(x,y);
							}else {
								if (pos == 6 || pos == 7 || pos == 8|| pos2 == 6 || pos2 == 7 || pos2 == 8) {
									double x = Math.random()*360;
									double y = -50;
									enemigos[k] = new Enemigo(x,y);
							}else {
								double x = Math.random() * 500;
								double y = 650;
								enemigos[k] = new Enemigo(x,y);
							}
						}
			        }
			    	}
			    	enemigos[k].dibujar(entorno);
			        enemigosActivos++;
			    }
			    enemigosMuertos = 0;
			}
			for (int k = 0;k < enemigos.length;k++) {
				if (enemigos[k] != null) {
			        this.bombaFuego.alcanzoAlEnemigo(enemigos[k], xPoder, yPoder);
			        this.rayo.alcanzoAlEnemigo1(enemigos[k], xPoder2, yPoder2);
			        this.p1.puntuacion(enemigos[k], bombaFuego);
			        }
				}
		}
			seleccionPoderes1();
			seleccionPoderes2();
			
			if (this.duracionPoder > 0) {
				this.bombaFuego.dibujar(this.xPoder, this.yPoder, entorno);
				this.duracionPoder--;
			}
			if (this.estadoDelPoder) {
				this.barrasJugador.bajaLaEnergia(p1);
			}
			if (this.duracionPoder2 > 0) {
				this.rayo.dibujar(this.xPoder2, this.yPoder2, entorno);
				this.duracionPoder2--;
			}
			if (this.estadoDelPoder2) {
				this.barrasJugador.bajaLaEnergia(p1);
			}
		    
		    
			this.aba = false;
			this.arr = false;
			this.der = false;
			this.izq = false;
			ganoElJuego(p1);
			this.w.dibujar(entorno, gano);
		    terminaElJuego(p1,this.termina);
			this.g.dibujar(entorno,termina);
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
	void botonesMenu() {
		if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
		    int mouseX = entorno.mouseX();
		    int mouseY = entorno.mouseY();

		    if (mouseX >= menu.izq && mouseX <= menu.der &&
		        mouseY >= menu.arr && mouseY <= menu.abajo) {
		        	this.iniciaJuego = true;
		    }
		}
	}
	//
	void seleccionPoderes1() {
    	if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)){
			int mouseX = entorno.mouseX();
			int mouseY = entorno.mouseY();
		    if (mouseX >= b.bordeIzq && mouseX <= b.bordeDer &&
			        mouseY >= b.bordeArriba && mouseY <= b.bordeAbajo) {
		    		this.estaSeleccionado = true;
		    	}	
		    	else { if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && this.estaSeleccionado){
		    			if (mouseX <= 600 && mouseY <= 600) {
		    				if (p1.energia > 0) {
		    					this.estadoDelPoder = true;
			    				p1.poderActivo = true;
			    				p1.consumirEnergia = true;
			    		        this.xPoder = mouseX;
			    		        this.yPoder = mouseY;
			    		        this.duracionPoder = 30;
			    				this.estaSeleccionado = false;
			    				}
			    			}else {
			    				this.estaSeleccionado = false;
			    				this.estadoDelPoder = false;
			    			}
		    				}			
		    	}
		    			
		    		}
		    	}
	void seleccionPoderes2() {
    	if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)){
			int mouseX = entorno.mouseX();
			int mouseY = entorno.mouseY();
		    if (mouseX >= b.bordeIzq1 && mouseX <= b.bordeDer1 &&
			        mouseY >= b.bordeArriba1 && mouseY <= b.bordeAbajo1) {
		    		this.estaSeleccionado2 = true;
		    	}	
		    	else { if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && this.estaSeleccionado2){
		    			if (mouseX <= 600 && mouseY <= 600) {
		    				if (p1.energia > 0) {
		    					this.estadoDelPoder2 = true;
			    				p1.poderActivo2 = true;
			    				p1.consumirEnergia2 = true;
			    		        this.xPoder2 = mouseX;
			    		        this.yPoder2 = mouseY;
			    		        this.duracionPoder2 = 30;
			    				this.estaSeleccionado2 = false;
			    				}
			    			}else {
			    				this.estaSeleccionado2 = false;
			    				this.estadoDelPoder2 = false;
			    			}
		    	}
		    	}
    	}
	}
	public boolean terminaElJuego(Personaje personaje,boolean termina) {
		if (personaje.vida > 0) {
			this.termina = false;
		}else {if(personaje.vida == 0) {
			this.termina = true;
		}
		}
		return termina;
	}
	public boolean ganoElJuego(Personaje personaje) {
		if (personaje.victoria) {
			this.gano = true;
		}else {
			this.gano = false;
		}
		return gano;
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}