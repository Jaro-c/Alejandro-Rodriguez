
public class Reserva {

    private int id;
    private String descripcion;

    public Reserva(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double calcularPrecio() {
        return 0;
    }
}
