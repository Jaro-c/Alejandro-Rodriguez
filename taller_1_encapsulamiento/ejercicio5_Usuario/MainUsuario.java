
public class MainUsuario {

    public static void main(String[] args) {

        Usuario cuenta = new Usuario("alejandro.rodriguez", "clave2024");
        System.out.println("Usuario creado: " + cuenta.getNombreUsuario());

        try {
            cuenta.cambiarPassword("abcdefg");
            System.out.println("Clave cambiada correctamente.");
        } catch (PasswordDebilException e) {
            System.out.println("No se pudo cambiar la clave: " + e.getMessage());
        }

        boolean loginOk = cuenta.verificarPassword("clave2024");
        System.out.println("Login con clave correcta -> " + loginOk);

        for (int i = 1; i <= 3; i++) {
            try {
                boolean resultado = cuenta.verificarPassword("claveIncorrecta" + i);
                System.out.println("Intento fallido #" + i + " -> " + resultado);
            } catch (CuentaBloqueadaException e) {
                System.out.println("Intento #" + i + " rechazado: " + e.getMessage());
            }
        }

        try {
            cuenta.verificarPassword("clave2024");
        } catch (CuentaBloqueadaException e) {
            System.out.println("Intento #4 -> Cuenta bloqueada: " + e.getMessage());
        }
    }
}
