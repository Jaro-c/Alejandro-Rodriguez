
public class MainFiguras {

    public static void main(String[] args) {
        Figura[] figuras = {
            new Circulo("Rojo", 5.0),
            new Rectangulo("Azul", 4.0, 6.0),
            new Triangulo("Verde", 8.0, 3.0)
        };

        for (Figura figura : figuras) {
            figura.resumen();
        }
    }
}
