
public class Agua extends ServicioPublico {

    private static final double TARIFA_POR_METRO_CUBICO = 3500;
    private static final double CARGO_FIJO = 8000;

    public Agua(String numeroContrato, String titular, double consumoDelMes) {
        super(numeroContrato, titular, consumoDelMes);
    }

    @Override
    public double calcularFactura() {
        return (getConsumoDelMes() * TARIFA_POR_METRO_CUBICO) + CARGO_FIJO;
    }
}
