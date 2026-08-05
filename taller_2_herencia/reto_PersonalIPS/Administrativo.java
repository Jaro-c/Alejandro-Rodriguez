
public class Administrativo extends PersonalIPS {

    private String area;

    public Administrativo(String documento, String nombre, double salarioBase, String area) {
        super(documento, nombre, salarioBase);
        this.area = area;
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioBase;
    }
}
