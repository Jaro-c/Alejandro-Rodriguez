
public class MainServicios {

    public static void main(String[] args) {

        // ServicioPublico servicio = new ServicioPublico("C-001", "Alejandro", 10);
        // ERROR: cannot instantiate the type ServicioPublico
        // No se puede crear un objeto directamente de una clase abstracta porque
        // le falta la implementacion real de calcularFactura(); solo sus hijas
        // (Agua, Luz, Gas) saben como calcular su propia tarifa.

        Agua facturaAgua = new Agua("AC-4521", "Alejandro Rodriguez", 15);
        Luz facturaLuz = new Luz("LC-7789", "Alejandro Rodriguez", 250);
        Gas facturaGas = new Gas("GC-3390", "Alejandro Rodriguez", 12);

        ServicioPublico[] facturasDelMes = { facturaAgua, facturaLuz, facturaGas };

        System.out.println("=== Facturacion de servicios publicos del mes ===");
        for (ServicioPublico factura : facturasDelMes) {
            factura.emitirRecibo();
            System.out.println("-----");
        }
    }
}
