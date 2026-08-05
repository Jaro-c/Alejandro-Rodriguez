
public class MainAprendiz {

    public static void main(String[] args) {
        Aprendiz aprendiz = new Aprendiz("1098765432", "Carlos Fernandez");

        try {
            aprendiz.setEdad(22);
        } catch (DatoInvalidoException error) {
            System.out.println("No se pudo asignar la edad: " + error.getMessage());
        }

        try {
            aprendiz.setNotaFinal(7.0);
        } catch (DatoInvalidoException error) {
            System.out.println("No se pudo asignar la nota: " + error.getMessage());
        }

        try {
            aprendiz.setNotaFinal(4.2);
        } catch (DatoInvalidoException error) {
            System.out.println("No se pudo asignar la nota: " + error.getMessage());
        }

        try {
            aprendiz.setCorreoInstitucional("carlos.fernandezsena.edu.co");
        } catch (DatoInvalidoException error) {
            System.out.println("No se pudo asignar el correo: " + error.getMessage());
        }

        try {
            aprendiz.setCorreoInstitucional("carlos.fernandez@sena.edu.co");
        } catch (DatoInvalidoException error) {
            System.out.println("No se pudo asignar el correo: " + error.getMessage());
        }

        System.out.println();
        System.out.println("--- Ficha final del aprendiz ---");
        System.out.println(aprendiz);
    }
}
