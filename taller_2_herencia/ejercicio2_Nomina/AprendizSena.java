
public class AprendizSena extends Empleado {

    private static final double PORCENTAJE_APOYO = 0.5;

    public AprendizSena(String nombre, String documento, double salarioBase) {
        super(nombre, documento, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * PORCENTAJE_APOYO;
    }
}
