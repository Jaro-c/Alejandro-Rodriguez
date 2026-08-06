
public class ReservaBusIntermunicipal extends Reserva {

    private String origen;
    private String destino;
    private double precioFijo;

    public ReservaBusIntermunicipal(int id, String descripcion, String origen, String destino, double precioFijo) {
        super(id, descripcion);
        this.origen = origen;
        this.destino = destino;
        this.precioFijo = precioFijo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public double calcularPrecio() {
        return precioFijo;
    }
}
