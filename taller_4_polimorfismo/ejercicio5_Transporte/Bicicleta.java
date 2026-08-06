
public class Bicicleta extends Vehiculo {

    public Bicicleta(String placa) {
        super(placa);
    }

    @Override
    public void mover() {
        System.out.println("La bicicleta " + getPlaca() + " avanza a pedaleo por el carril bici.");
    }
}
