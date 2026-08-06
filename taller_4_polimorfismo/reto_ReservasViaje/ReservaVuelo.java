
public class ReservaVuelo extends Reserva {

    private boolean internacional;
    private double distanciaKm;

    public ReservaVuelo(int id, String descripcion, boolean internacional, double distanciaKm) {
        super(id, descripcion);
        this.internacional = internacional;
        this.distanciaKm = distanciaKm;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public boolean esInternacional() {
        return internacional;
    }

    @Override
    public double calcularPrecio() {
        return distanciaKm * 500 + 150000;
    }
}
