
public class MainEmpresa {

    public static void main(String[] args) {

        Empleado[] nomina = {
                new Vendedor("Laura Gomez", "1091234567", 1300000, 450000),
                new Gerente("Carlos Pena", "1090123456", 3200000, 900000),
                new AprendizSena("Alejandro Rodriguez", "1005678912", 1160000)
        };

        System.out.println("=== Nomina Empresa de Cucuta ===");
        for (Empleado empleado : nomina) {
            empleado.mostrarInfo();
        }
    }
}
