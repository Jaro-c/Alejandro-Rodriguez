
public class ReservaHotel extends Reserva {

    private int noches;
    private double precioPorNoche;

    public ReservaHotel(int id, String descripcion, int noches, double precioPorNoche) {
        super(id, descripcion);
        this.noches = noches;
        this.precioPorNoche = precioPorNoche;
    }

    public int getNoches() {
        return noches;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    @Override
    public double calcularPrecio() {
        return noches * precioPorNoche;
    }
}
