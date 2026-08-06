
public class MainNomina {

    public static void main(String[] args) {

        EmpleadoFijo administradora = new EmpleadoFijo("Diana Ortiz", "1091334455", 1800000);
        EmpleadoPorHoras tecnico = new EmpleadoPorHoras("Julian Perez", "1093445566", 96, 12000);
        EmpleadoFreelance disenador = new EmpleadoFreelance("Camila Rios", "1094556677", 0, 380000);

        Empleado[] nomina = { administradora, tecnico, disenador };

        System.out.println("=== Nomina del mes: tres formas distintas de pagar ===");
        for (Empleado empleado : nomina) {
            empleado.mostrarRecibo();
        }
    }
}
