
public class MainTienda {

    public static void main(String[] args) {

        TarjetaCredito tarjetaCredito = new TarjetaCredito(150000, "4589123478563214");
        PagoEfectivo pagoEfectivo = new PagoEfectivo(65000);
        PagoPSE pagoPSE = new PagoPSE(230000, "Bancolombia");

        MedioPago[] mediosPago = { tarjetaCredito, pagoEfectivo, pagoPSE };

        System.out.println("=== Cierre de caja de la tienda: tres formas de pagar ===");
        for (MedioPago medio : mediosPago) {
            medio.mostrarMonto();
            medio.procesarPago();
            System.out.println("-----");
        }
    }
}
