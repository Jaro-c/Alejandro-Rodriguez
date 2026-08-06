
// El PDF pide primero crear esta clase SIN el metodo calcularArea() para
// comprobar que Java no deja compilar. El error que se ve en ese caso es:
//   Cuadrado.java: error: Cuadrado is not abstract and does not override
//   abstract method calcularArea() in Figura
// Es decir: si una clase hereda de una clase abstracta y no implementa todos
// sus metodos abstractos, esa clase tambien tendria que declararse abstract.
// Abajo queda ya la version arreglada, implementando calcularArea().
public class Cuadrado extends Figura {

    private final double lado;

    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
