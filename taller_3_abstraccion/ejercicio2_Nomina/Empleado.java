
public abstract class Empleado {

    private final String nombre;
    private final String documento;

    protected Empleado(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public abstract double calcularPago();

    public void mostrarRecibo() {
        System.out.printf(
                "Recibo de pago -> Nombre: %s | Documento: %s | Total a pagar: $%.2f%n",
                nombre, documento, calcularPago());
    }
}
