
public abstract class Figura {

    private final String nombre;

    protected Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularArea();

    public void mostrar() {
        System.out.printf("Figura: %-12s | Area: %.2f%n", nombre, calcularArea());
    }
}
