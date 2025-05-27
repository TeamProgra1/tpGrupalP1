package juego;

public class calcularArea {
    private double ancho;
    private double alto;

    public calcularArea(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double calcularArea2() {
        return ancho * alto;
    }
}

