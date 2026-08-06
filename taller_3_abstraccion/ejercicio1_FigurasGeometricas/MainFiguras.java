
public class MainFiguras {

    public static void main(String[] args) {

        // Figura f = new Figura("X"); // ERROR: no se puede instanciar una clase abstracta

        Circulo circulo = new Circulo(4.0);
        Triangulo triangulo = new Triangulo(6.0, 3.5);
        Rectangulo rectangulo = new Rectangulo(5.0, 2.0);
        Cuadrado cuadrado = new Cuadrado(4.0);

        Figura[] figuras = { circulo, triangulo, rectangulo, cuadrado };

        System.out.println("=== Reporte de areas del taller de figuras ===");
        for (Figura figura : figuras) {
            figura.mostrar();
        }
    }
}
