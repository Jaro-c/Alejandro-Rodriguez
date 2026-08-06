
public class MainAreas {

    public static void main(String[] args) {
        Cuadrado patio = new Cuadrado(4.0);
        Circulo mesaRedonda = new Circulo(3.0);
        Triangulo techo = new Triangulo(6.0, 2.5);
        Rectangulo salon = new Rectangulo(5.0, 8.0);
        Rectangulo bodega = new Rectangulo(3.0, 4.5);

        Figura[] figurasDelPlano = { patio, mesaRedonda, techo, salon, bodega };

        System.out.println("=== Areas individuales de cada figura ===");
        double areaTotalAcumulada = 0;
        for (Figura figura : figurasDelPlano) {
            double areaActual = figura.calcularArea();
            System.out.printf("%s -> Area: %.2f%n", figura.getClass().getSimpleName(), areaActual);
            areaTotalAcumulada += areaActual;
        }

        System.out.printf("Area total del plano completo: %.2f%n", areaTotalAcumulada);

        System.out.println("=== Reto extra: encontrar la figura con mayor area ===");
        Figura figuraConMayorArea = encontrarMayorArea(figurasDelPlano);
        System.out.printf("La figura con mayor area es %s con %.2f%n",
                figuraConMayorArea.getClass().getSimpleName(), figuraConMayorArea.calcularArea());
    }

    public static Figura encontrarMayorArea(Figura[] figuras) {
        Figura figuraGanadora = figuras[0];
        for (Figura figura : figuras) {
            if (figura.calcularArea() > figuraGanadora.calcularArea()) {
                figuraGanadora = figura;
            }
        }
        return figuraGanadora;
    }
}
