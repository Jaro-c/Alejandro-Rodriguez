
public class MotoTaxi extends Vehiculo {

    public MotoTaxi(String placa) {
        super(placa);
    }

    @Override
    public void mover() {
        System.out.println("La mototaxi " + getPlaca() + " se escurre entre el trafico por las calles del barrio.");
    }

    public void recogerPasajero() {
        System.out.println("La mototaxi " + getPlaca() + " se detiene a recoger a su pasajero en la esquina.");
    }
}
