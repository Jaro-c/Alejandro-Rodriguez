
public class Bus extends Vehiculo {

    public Bus(String placa) {
        super(placa);
    }

    @Override
    public void mover() {
        System.out.println("El bus " + getPlaca() + " avanza por su ruta parando en cada paradero.");
    }

    public void abrirPuertas() {
        System.out.println("El bus " + getPlaca() + " abre sus puertas para que suban los pasajeros.");
    }
}
