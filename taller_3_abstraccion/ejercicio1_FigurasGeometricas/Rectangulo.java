
// CONSTRUYE TU MISMO: figura pedida por el taller para practicar la herencia
// de una clase abstracta implementando el metodo calcularArea() por cuenta propia.
public class Rectangulo extends Figura {

    private final double ancho;
    private final double alto;

    public Rectangulo(double ancho, double alto) {
        super("Rectangulo");
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }
}
