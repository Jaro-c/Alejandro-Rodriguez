
public class MainVehiculo {

    public static void main(String[] args) {
        Vehiculo moto = new Vehiculo("ABC123", "Yamaha", "FZ25");

        System.out.println("Vehiculo creado: " + moto.getPlaca() + " " + moto.getMarca() + " " + moto.getModelo());
        System.out.println("Velocidad inicial: " + moto.getVelocidadActual() + " km/h");

        System.out.println("\n--- Fase de aceleracion ---");
        for (int i = 1; i <= 4; i++) {
            boolean aplicado = moto.acelerar();
            System.out.println("Intento " + i + " -> aplicado: " + aplicado);
        }

        System.out.println("\n--- Fase de frenado ---");
        moto.frenar();
        moto.frenar();

        System.out.println("\nVelocidad final: " + moto.getVelocidadActual() + " km/h");
        System.out.println("Kilometraje total: " + moto.getKilometrajeTotal() + " km");

        System.out.println("\n--- Reset ---");
        moto.reset();
        System.out.println("Velocidad tras reset: " + moto.getVelocidadActual() + " km/h");
        System.out.println("Kilometraje tras reset (no cambia): " + moto.getKilometrajeTotal() + " km");

        System.out.println("\n--- Forzando el limite maximo ---");
        boolean llegoAlTope = false;
        int intentos = 0;
        while (!llegoAlTope && intentos < 30) {
            llegoAlTope = !moto.acelerar();
            intentos++;
        }
        System.out.println("Se alcanzo el rechazo por tope tras " + intentos + " llamadas a acelerar()");
        System.out.println("Velocidad en el tope: " + moto.getVelocidadActual() + " km/h");
        System.out.println("Kilometraje final acumulado: " + moto.getKilometrajeTotal() + " km");
    }
}
