
public class Gas extends ServicioPublico {

    private static final double TARIFA_POR_METRO_CUBICO = 2100;
    private static final double CARGO_FIJO = 5000;

    public Gas(String numeroContrato, String titular, double consumoDelMes) {
        super(numeroContrato, titular, consumoDelMes);
    }

    @Override
    public double calcularFactura() {
        return (getConsumoDelMes() * TARIFA_POR_METRO_CUBICO) + CARGO_FIJO;
    }
}
