
import java.util.Random;

public class PagoEfectivo extends MedioPago {

    private static final Random GENERADOR = new Random();

    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public void procesarPago() {
        int codigoRecaudo = 100000 + GENERADOR.nextInt(900000);
        System.out.printf(
                "Se genero el codigo de recaudo %d, paguelo en un punto Efecty por $%.2f.%n",
                codigoRecaudo, getMonto());
    }
}
