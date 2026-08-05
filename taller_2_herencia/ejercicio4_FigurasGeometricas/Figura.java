
public abstract class Figura {

    private String color;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calcularArea();

    public void resumen() {
        System.out.printf("Color: %s | Area: %.2f%n", color, calcularArea());
    }
}
