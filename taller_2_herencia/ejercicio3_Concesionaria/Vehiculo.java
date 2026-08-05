
public class Vehiculo {

    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public String obtenerDescripcion() {
        return marca + " " + modelo + " - $" + String.format("%,.0f", precio);
    }

    public void describir() {
        System.out.println(obtenerDescripcion());
    }
}
