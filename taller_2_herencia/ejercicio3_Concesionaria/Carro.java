
public class Carro extends Vehiculo {

    private int numeroPuertas;

    public Carro(String marca, String modelo, double precio, int numeroPuertas) {
        super(marca, modelo, precio);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public String obtenerDescripcion() {
        StringBuilder textoCompleto = new StringBuilder(super.obtenerDescripcion());
        textoCompleto.append(" | Puertas: ").append(numeroPuertas);
        return textoCompleto.toString();
    }
}
