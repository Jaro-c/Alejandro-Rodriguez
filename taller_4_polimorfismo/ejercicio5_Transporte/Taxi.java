
public class Taxi extends Vehiculo {

    public Taxi(String placa) {
        super(placa);
    }

    @Override
    public void mover() {
        System.out.println("El taxi " + getPlaca() + " se desplaza directo hasta la direccion del pasajero.");
    }
}
