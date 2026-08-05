
public abstract class PersonalIPS {

    protected String documento;
    protected String nombre;
    protected double salarioBase;

    public PersonalIPS(String documento, String nombre, double salarioBase) {
        this.documento = documento;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalarioMensual();

    public void registrarAsistencia() {
        System.out.println(nombre + " (doc. " + documento + ") registro asistencia hoy.");
    }

    public void mostrarInfo() {
        System.out.printf("Documento: %s | Nombre: %s | Salario mensual: $%,.0f%n",
                documento, nombre, calcularSalarioMensual());
    }
}
