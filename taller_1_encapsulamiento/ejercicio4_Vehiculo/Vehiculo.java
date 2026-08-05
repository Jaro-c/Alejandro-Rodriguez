
public class Vehiculo {

    private static final int TOPE_VELOCIDAD = 200;
    private static final int PISO_VELOCIDAD = 0;
    private static final int PASO_KMH = 10;

    private String placa;
    private String marca;
    private String modelo;
    private int velocidadActual;
    private double kilometrajeTotal;

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = PISO_VELOCIDAD;
        this.kilometrajeTotal = 0.0;
    }

    public boolean acelerar() {
        if (velocidadActual >= TOPE_VELOCIDAD) {
            System.out.println("[" + placa + "] acelerar rechazado, ya esta en el tope de " + TOPE_VELOCIDAD + " km/h");
            return false;
        }

        int candidato = velocidadActual + PASO_KMH;
        velocidadActual = Math.min(candidato, TOPE_VELOCIDAD);
        kilometrajeTotal += velocidadActual / 100.0;

        System.out.println("[" + placa + "] acelera a " + velocidadActual + " km/h (odometro: " + kilometrajeTotal + " km)");
        return true;
    }

    public boolean frenar() {
        if (velocidadActual <= PISO_VELOCIDAD) {
            System.out.println("[" + placa + "] frenar rechazado, el vehiculo ya esta detenido");
            return false;
        }

        int candidato = velocidadActual - PASO_KMH;
        velocidadActual = Math.max(candidato, PISO_VELOCIDAD);

        System.out.println("[" + placa + "] frena a " + velocidadActual + " km/h");
        return true;
    }

    public void reset() {
        velocidadActual = PISO_VELOCIDAD;
        System.out.println("[" + placa + "] reset aplicado, velocidad en " + PISO_VELOCIDAD + " km/h");
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public double getKilometrajeTotal() {
        return kilometrajeTotal;
    }
}
