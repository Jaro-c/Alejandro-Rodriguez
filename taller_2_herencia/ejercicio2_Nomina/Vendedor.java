
public class Vendedor extends Empleado {

    private final double incentivoVentas;

    public Vendedor(String nombre, String documento, double salarioBase, double incentivoVentas) {
        super(nombre, documento, salarioBase);
        this.incentivoVentas = incentivoVentas;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + incentivoVentas;
    }
}
