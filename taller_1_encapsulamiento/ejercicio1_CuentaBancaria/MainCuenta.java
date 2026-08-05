
public class MainCuenta {

    public static void main(String[] args) {
        CuentaBancaria cuentaCamilo = new CuentaBancaria("1011-2233", "Camilo Vargas");
        CuentaBancaria cuentaDiana = new CuentaBancaria("1011-4499", "Diana Restrepo");

        cuentaCamilo.depositar(500000);
        System.out.println("Deposito realizado -> " + cuentaCamilo);

        try {
            cuentaCamilo.transferir(cuentaDiana, 150000);
            System.out.println("Transferencia exitosa.");
            System.out.println("  " + cuentaCamilo);
            System.out.println("  " + cuentaDiana);
        } catch (IllegalArgumentException | SaldoInsuficienteException error) {
            System.out.println("No se pudo transferir: " + error.getMessage());
        }

        try {
            cuentaCamilo.transferir(cuentaDiana, 999999999);
            System.out.println("Esto no deberia imprimirse.");
        } catch (SaldoInsuficienteException error) {
            System.out.println("Transferencia rechazada: " + error.getMessage());
        }

        try {
            cuentaCamilo.depositar(-100);
        } catch (IllegalArgumentException error) {
            System.out.println("Deposito rechazado: " + error.getMessage());
        }

        try {
            cuentaDiana.retirar(-50);
        } catch (IllegalArgumentException error) {
            System.out.println("Retiro rechazado: " + error.getMessage());
        }

        try {
            cuentaDiana.retirar(10000000);
        } catch (SaldoInsuficienteException error) {
            System.out.println("Retiro rechazado: " + error.getMessage());
        }

        System.out.println();
        System.out.println("Estado final:");
        System.out.println("  " + cuentaCamilo);
        System.out.println("  " + cuentaDiana);
    }
}
