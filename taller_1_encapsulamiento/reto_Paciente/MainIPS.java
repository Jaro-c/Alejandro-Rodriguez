
public class MainIPS {

    public static void main(String[] args) {

        Paciente paciente = new Paciente("CC-1020304050", "Alejandro Rodriguez", 34, "O+");
        System.out.println("Paciente creado correctamente.");

        try {
            String diagnosticoFiltrado = paciente.consultarDiagnostico("clave-cualquiera");
            System.out.println("Esto no deberia imprimirse: " + diagnosticoFiltrado);
        } catch (AccesoNoAutorizadoException error) {
            System.out.println("Intento de consulta no autorizada bloqueado: " + error.getMessage());
        }

        try {
            paciente.actualizarDiagnostico("Hipertension arterial controlada", "MED-2026");
            System.out.println("Diagnostico actualizado por el medico tratante.");
        } catch (AccesoNoAutorizadoException | DatoClinicoInvalidoException error) {
            System.out.println("No se pudo actualizar el diagnostico: " + error.getMessage());
        }

        try {
            String diagnosticoAutorizado = paciente.consultarDiagnostico("MED-2026");
            System.out.println("Diagnostico (acceso autorizado): " + diagnosticoAutorizado);
        } catch (AccesoNoAutorizadoException error) {
            System.out.println("No deberia fallar con la clave correcta: " + error.getMessage());
        }

        paciente.agregarAlergia("Penicilina");
        paciente.agregarAlergia("Polen");
        paciente.agregarAlergia("Mariscos");
        System.out.println("El paciente tiene alergias registradas: " + paciente.tieneAlergias());

        try {
            Paciente pacienteInvalido = new Paciente("CC-9988776655", "Prueba Erronea", 40, "Z+");
            System.out.println("Esto no deberia crearse: " + pacienteInvalido);
        } catch (DatoClinicoInvalidoException error) {
            System.out.println("Tipo de sangre rechazado correctamente: " + error.getMessage());
        }

        try {
            Paciente pacienteEdadInvalida = new Paciente("CC-1111111111", "Otro Caso", 150, "A+");
            System.out.println("Esto no deberia crearse: " + pacienteEdadInvalida);
        } catch (DatoClinicoInvalidoException error) {
            System.out.println("Edad rechazada correctamente: " + error.getMessage());
        }

        System.out.println("\nResumen final del paciente:");
        System.out.println(paciente);
        System.out.println("Documento: " + paciente.getDocumento());
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Edad: " + paciente.getEdad());
        System.out.println("Tipo de sangre: " + paciente.getTipoSangre());
        System.out.print("Alergias: ");
        String[] alergiasPaciente = paciente.getAlergias();
        for (String alergia : alergiasPaciente) {
            System.out.print(alergia + " ");
        }
        System.out.println();
    }
}
