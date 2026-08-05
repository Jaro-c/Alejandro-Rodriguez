
public class Usuario {

    private static final int LIMITE_INTENTOS = 3;
    private static final int LARGO_MINIMO_CLAVE = 8;

    private String nombreUsuario;
    private String claveActual;
    private int intentosFallidos;
    private boolean bloqueado;

    public Usuario(String nombreUsuario, String passwordInicial) {
        this.nombreUsuario = nombreUsuario;
        this.intentosFallidos = 0;
        this.bloqueado = false;
        cambiarPassword(passwordInicial);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void cambiarPassword(String nueva) {
        if (!cumpleFormatoValido(nueva)) {
            throw new PasswordDebilException(
                "La contrasena debe tener al menos " + LARGO_MINIMO_CLAVE
                + " caracteres y contener al menos un numero.");
        }
        this.claveActual = nueva;
    }

    public boolean verificarPassword(String intento) {
        if (bloqueado) {
            throw new CuentaBloqueadaException(
                "Cuenta bloqueada por exceso de intentos fallidos. Contacte al administrador.");
        }

        boolean coincide = claveActual.equals(intento);

        if (coincide) {
            intentosFallidos = 0;
        } else {
            intentosFallidos++;
            if (intentosFallidos >= LIMITE_INTENTOS) {
                bloqueado = true;
            }
        }

        return coincide;
    }

    private boolean cumpleFormatoValido(String clave) {
        if (clave == null || clave.length() < LARGO_MINIMO_CLAVE) {
            return false;
        }
        boolean tieneNumero = false;
        for (char c : clave.toCharArray()) {
            if (Character.isDigit(c)) {
                tieneNumero = true;
                break;
            }
        }
        return tieneNumero;
    }
}
