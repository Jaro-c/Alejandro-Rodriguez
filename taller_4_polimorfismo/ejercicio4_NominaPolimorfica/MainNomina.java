
public class MainNomina {

    public static void main(String[] args) {
        EmpleadoTiempoCompleto asistente = new EmpleadoTiempoCompleto("Carolina Reyes", 2200000);
        EmpleadoTiempoCompleto supervisor = new EmpleadoTiempoCompleto("Andres Gomez", 3100000);
        EmpleadoFreelance disenador = new EmpleadoFreelance("Laura Pinto", 4, 350000);
        EmpleadoFreelance desarrollador = new EmpleadoFreelance("Kevin Torres", 2, 900000);
        EmpleadoPorHoras mensajero = new EmpleadoPorHoras("Jorge Muriel", 80, 12000);
        EmpleadoPorHoras aseador = new EmpleadoPorHoras("Diana Cortes", 96, 9500);

        Empleado[] plantillaDeEmpleados = {
            asistente, supervisor, disenador, desarrollador, mensajero, aseador
        };

        System.out.println("=== Liquidacion de nomina del mes ===");
        double totalNomina = 0;
        for (Empleado empleado : plantillaDeEmpleados) {
            double pagoDelEmpleado = empleado.calcularSalario();
            System.out.printf("%s (%s) -> Pago: %.2f%n",
                    empleado.getNombre(), empleado.getClass().getSimpleName(), pagoDelEmpleado);
            totalNomina += pagoDelEmpleado;
        }

        System.out.println("-----");
        System.out.printf("Total de la nomina a desembolsar: %.2f%n", totalNomina);
    }
}
