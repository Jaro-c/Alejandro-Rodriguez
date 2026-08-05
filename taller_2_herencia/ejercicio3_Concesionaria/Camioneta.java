
public class Camioneta extends Vehiculo {

    private double capacidadCarga;

    public Camioneta(String marca, String modelo, double precio, double capacidadCarga) {
        super(marca, modelo, precio);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    @Override
    public String obtenerDescripcion() {
        StringBuilder textoCompleto = new StringBuilder(super.obtenerDescripcion());
        textoCompleto.append(" | Capacidad de carga: ").append(capacidadCarga).append(" kg");
        return textoCompleto.toString();
    }
}
