
public abstract class MedioPago {

    private final double monto;

    protected MedioPago(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public abstract void procesarPago();

    public void mostrarMonto() {
        System.out.printf("Monto a pagar: $%.2f%n", monto);
    }
}
