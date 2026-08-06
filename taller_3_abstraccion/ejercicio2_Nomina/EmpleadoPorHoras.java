
public class EmpleadoPorHoras extends Empleado {

    private final double horasTrabajadas;
    private final double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, String documento, double horasTrabajadas, double tarifaPorHora) {
        super(nombre, documento);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    @Override
    public double calcularPago() {
        return horasTrabajadas * tarifaPorHora;
    }
}
