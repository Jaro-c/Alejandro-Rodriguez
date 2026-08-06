
public class MainAgencia {

    public static void main(String[] args) {
        ReservaVuelo vueloABogota = new ReservaVuelo(1, "Vuelo Medellin - Bogota", false, 250.0);
        ReservaVuelo vueloAMadrid = new ReservaVuelo(2, "Vuelo Medellin - Madrid", true, 8200.0);
        ReservaHotel hotelEnCartagena = new ReservaHotel(3, "Hotel frente al mar en Cartagena", 4, 280000);
        ReservaBusIntermunicipal busAManizales = new ReservaBusIntermunicipal(
                4, "Bus intermunicipal a Manizales", "Medellin", "Manizales", 65000);
        ReservaHotel hotelEnSanAndres = new ReservaHotel(5, "Hotel con desayuno en San Andres", 3, 350000);

        Reserva[] carritoDeReservas = {
            vueloABogota, vueloAMadrid, hotelEnCartagena, busAManizales, hotelEnSanAndres
        };

        System.out.println("=== Carrito de reservas de la agencia de viajes ===");
        double totalDelCarrito = 0;
        for (Reserva reserva : carritoDeReservas) {
            double precioDeLaReserva = reserva.calcularPrecio();
            System.out.printf("Reserva #%d - %s -> Precio: %.2f%n",
                    reserva.getId(), reserva.getDescripcion(), precioDeLaReserva);

            if (reserva instanceof ReservaVuelo) {
                ReservaVuelo vueloDetectado = (ReservaVuelo) reserva;
                String tipoDeVuelo = vueloDetectado.esInternacional() ? "internacional" : "nacional";
                System.out.println("   -> Este vuelo es de tipo " + tipoDeVuelo + ".");
            }

            totalDelCarrito += precioDeLaReserva;
            System.out.println("-----");
        }

        System.out.printf("Total a pagar por todo el carrito: %.2f%n", totalDelCarrito);
    }
}
