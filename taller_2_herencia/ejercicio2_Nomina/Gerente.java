
public class Gerente extends Empleado {

    private final double extraGestion;

    public Gerente(String nombre, String documento, double salarioBase, double extraGestion) {
        super(nombre, documento, salarioBase);
        this.extraGestion = extraGestion;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + extraGestion;
    }
}
