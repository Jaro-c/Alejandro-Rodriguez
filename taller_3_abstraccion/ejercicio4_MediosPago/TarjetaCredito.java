
public class TarjetaCredito extends MedioPago {

    private final String numeroTarjeta;

    public TarjetaCredito(double monto, String numeroTarjeta) {
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    @Override
    public void procesarPago() {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4) {
            System.out.println("Tarjeta invalida, no se pudo procesar el cobro.");
            return;
        }
        String ultimosDigitos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        System.out.printf(
                "Validando tarjeta terminada en %s... cobro de $%.2f aprobado.%n",
                ultimosDigitos, getMonto());
    }
}
