
public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String marca, String modelo, double precio, int cilindraje) {
        super(marca, modelo, precio);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override
    public String obtenerDescripcion() {
        String textoBase = super.obtenerDescripcion();
        return textoBase + " | Cilindraje: " + cilindraje + "cc";
    }
}
