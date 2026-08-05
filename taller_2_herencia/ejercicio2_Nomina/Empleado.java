
public abstract class Empleado {

    private final String nombre;
    private final String documento;
    private final double salarioBase;

    public Empleado(String nombre, String documento, double salarioBase) {
        this.nombre = nombre;
        this.documento = documento;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();

    public void mostrarInfo() {
        System.out.printf(
                "Nombre: %s | Documento: %s | Salario a pagar: $%.2f%n",
                nombre, documento, calcularSalario());
    }
}
