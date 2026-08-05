
public class CuentaBancaria {

    private final String codigoCuenta;
    private final String propietario;
    private double disponible;

    public CuentaBancaria(String codigoCuenta, String propietario) {
        this.codigoCuenta = codigoCuenta;
        this.propietario = propietario;
        this.disponible = 0.0;
    }

    public String getNumeroCuenta() {
        return codigoCuenta;
    }

    public String getTitular() {
        return propietario;
    }

    public double getSaldo() {
        return disponible;
    }

    public void depositar(double cantidad) {
        validarMontoPositivo(cantidad);
        disponible += cantidad;
    }

    public void retirar(double cantidad) {
        validarMontoPositivo(cantidad);
        asegurarFondosPara(cantidad, "retirar");
        disponible -= cantidad;
    }

    public void transferir(CuentaBancaria destino, double cantidad) {
        if (destino == null) {
            throw new IllegalArgumentException("La cuenta destino no puede ser nula");
        }
        validarMontoPositivo(cantidad);
        asegurarFondosPara(cantidad, "transferir a " + destino.getNumeroCuenta());

        this.disponible -= cantidad;
        destino.disponible += cantidad;
    }

    private void validarMontoPositivo(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor a cero (se recibio " + cantidad + ")");
        }
    }

    private void asegurarFondosPara(double cantidad, String operacion) {
        if (cantidad > disponible) {
            throw new SaldoInsuficienteException(
                    "Cuenta " + codigoCuenta + " no tiene fondos suficientes para "
                            + operacion + " (disponible: " + disponible
                            + ", solicitado: " + cantidad + ")");
        }
    }

    @Override
    public String toString() {
        return "Cuenta " + codigoCuenta + " [" + propietario + "] saldo=" + disponible;
    }
}
