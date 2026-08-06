
// CONSTRUYE TU MISMO: PSE necesita simular tres pasos en orden: redirigir al
// banco del usuario, esperar la confirmacion, y por ultimo mostrar el
// resultado aprobado del pago.
public class PagoPSE extends MedioPago {

    private final String banco;

    public PagoPSE(double monto, String banco) {
        super(monto);
        this.banco = banco;
    }

    public String getBanco() {
        return banco;
    }

    @Override
    public void procesarPago() {
        System.out.println("Redirigiendo a la pagina de " + banco + " para autorizar el pago...");
        System.out.println("Esperando la confirmacion del banco...");
        System.out.printf("Pago por $%.2f aprobado por %s a traves de PSE.%n", getMonto(), banco);
    }
}
