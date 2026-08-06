
public class EmpleadoFijo extends Empleado {

    private final double salarioMensual;

    public EmpleadoFijo(String nombre, String documento, double salarioMensual) {
        super(nombre, documento);
        this.salarioMensual = salarioMensual;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    @Override
    public double calcularPago() {
        return salarioMensual;
    }
}
