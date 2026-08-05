
public class MainProducto {

    public static void main(String[] args) {
        Producto teclado = new Producto("P-100", "Teclado mecánico", 150000.0, 20);
        System.out.println("Producto registrado: " + teclado);

        try {
            teclado.vender(5);
            System.out.println("Venta de 5 unidades OK -> " + teclado);
        } catch (OperacionInvalidaException e) {
            System.out.println("No se pudo vender: " + e.getMessage());
        }

        try {
            teclado.vender(100);
            System.out.println("Venta de 100 unidades OK -> " + teclado);
        } catch (OperacionInvalidaException e) {
            System.out.println("No se pudo vender: " + e.getMessage());
        }

        try {
            teclado.reabastecer(30);
            System.out.println("Reabastecido con 30 unidades -> " + teclado);
        } catch (OperacionInvalidaException e) {
            System.out.println("No se pudo reabastecer: " + e.getMessage());
        }

        try {
            teclado.aplicarDescuento(15);
            System.out.println("Descuento del 15% aplicado -> precio actual: " + teclado.getPrecio());
        } catch (OperacionInvalidaException e) {
            System.out.println("No se pudo aplicar el descuento: " + e.getMessage());
        }

        try {
            teclado.aplicarDescuento(150);
            System.out.println("Descuento del 150% aplicado -> precio actual: " + teclado.getPrecio());
        } catch (OperacionInvalidaException e) {
            System.out.println("No se pudo aplicar el descuento: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Estado final: " + teclado);
        System.out.println("Precio final: " + teclado.getPrecio());
        System.out.println("Stock final: " + teclado.getStock());
        System.out.println("¿Hay stock disponible? " + teclado.hayStock());
    }
}
