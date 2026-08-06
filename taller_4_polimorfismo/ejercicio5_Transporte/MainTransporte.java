
public class MainTransporte {

    public static void main(String[] args) {
        Bus busUrbano = new Bus("BUS-101");
        Taxi taxiAmarillo = new Taxi("TAX-202");
        Bicicleta bicicletaDeMontanha = new Bicicleta("BIC-303");
        MotoTaxi mototaxiUno = new MotoTaxi("MTX-404");
        MotoTaxi mototaxiDos = new MotoTaxi("MTX-505");

        Vehiculo[] flotaDeTransporte = {
            busUrbano, taxiAmarillo, bicicletaDeMontanha, mototaxiUno, mototaxiDos
        };

        System.out.println("=== Recorrido de toda la flota ===");
        for (Vehiculo vehiculo : flotaDeTransporte) {
            vehiculo.mover();

            if (vehiculo instanceof Bus) {
                Bus busDetectado = (Bus) vehiculo;
                busDetectado.abrirPuertas();
            }

            if (vehiculo instanceof MotoTaxi) {
                MotoTaxi mototaxiDetectada = (MotoTaxi) vehiculo;
                mototaxiDetectada.recogerPasajero();
            }

            System.out.println("-----");
        }
    }
}
