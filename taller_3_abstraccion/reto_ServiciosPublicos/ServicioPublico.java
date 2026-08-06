
public abstract class ServicioPublico {

    private final String numeroContrato;
    private final String titular;
    private final double consumoDelMes;

    protected ServicioPublico(String numeroContrato, String titular, double consumoDelMes) {
        this.numeroContrato = numeroContrato;
        this.titular = titular;
        this.consumoDelMes = consumoDelMes;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public String getTitular() {
        return titular;
    }

    public double getConsumoDelMes() {
        return consumoDelMes;
    }

    public abstract double calcularFactura();

    public void emitirRecibo() {
        System.out.println("=== Recibo de servicio publico ===");
        System.out.println("Contrato: " + numeroContrato);
        System.out.println("Titular: " + titular);
        System.out.printf("Consumo del mes: %.2f%n", consumoDelMes);
        System.out.printf("Total a pagar: $%.2f%n", calcularFactura());
    }
}
