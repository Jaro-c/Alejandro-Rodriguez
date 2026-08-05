
public class Enfermero extends PersonalIPS {

    private Turno turno;

    private static final double BONO_NOCTURNO = 200000;

    public Enfermero(String documento, String nombre, double salarioBase, Turno turno) {
        super(documento, nombre, salarioBase);
        this.turno = turno;
    }

    @Override
    public double calcularSalarioMensual() {
        if (turno == Turno.NOCHE) {
            return salarioBase + BONO_NOCTURNO;
        }
        return salarioBase;
    }
}
