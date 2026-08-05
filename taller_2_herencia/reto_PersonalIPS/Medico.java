
public class Medico extends PersonalIPS {

    private String especialidad;
    private int consultasDelMes;

    private static final double PAGO_POR_CONSULTA = 500000;

    public Medico(String documento, String nombre, double salarioBase,
                  String especialidad, int consultasDelMes) {
        super(documento, nombre, salarioBase);
        this.especialidad = especialidad;
        this.consultasDelMes = consultasDelMes;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioBase + (PAGO_POR_CONSULTA * consultasDelMes);
    }
}
