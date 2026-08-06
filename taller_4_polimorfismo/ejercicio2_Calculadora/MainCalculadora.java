
public class MainCalculadora {

    public static void main(String[] args) {
        Calculadora calculadoraGeneral = new Calculadora();

        System.out.println("=== Sobrecarga con enteros ===");
        int sumaDosEnteros = calculadoraGeneral.sumar(4, 7);
        System.out.println("sumar(4, 7) = " + sumaDosEnteros);

        int sumaTresEnteros = calculadoraGeneral.sumar(4, 7, 10);
        System.out.println("sumar(4, 7, 10) = " + sumaTresEnteros);

        System.out.println("=== Sobrecarga con decimales ===");
        double sumaDosDecimales = calculadoraGeneral.sumar(3.5, 2.25);
        System.out.println("sumar(3.5, 2.25) = " + sumaDosDecimales);

        System.out.println("=== Sobrecarga con texto ===");
        String saludoConcatenado = calculadoraGeneral.sumar("Hola", "mundo");
        System.out.println("sumar(\"Hola\", \"mundo\") = " + saludoConcatenado);

        System.out.println("=== Sobrecarga mixta: entero mas decimal ===");
        double sumaMixta = calculadoraGeneral.sumar(5, 2.75);
        System.out.println("sumar(5, 2.75) = " + sumaMixta);

        System.out.println("=== Sobrecarga con arreglo de enteros ===");
        int[] listaDeNumeros = { 10, 20, 30, 40 };
        int sumaDelArreglo = calculadoraGeneral.sumar(listaDeNumeros);
        System.out.println("sumar(listaDeNumeros) = " + sumaDelArreglo);
    }
}
