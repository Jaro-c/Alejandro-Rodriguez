
public class Televisor extends Electrodomestico {

    private int canalActual;

    public Televisor(String marca) {
        super(marca);
        this.canalActual = 1;
    }

    public int getCanalActual() {
        return canalActual;
    }

    public void cambiarCanal(int canal) {
        this.canalActual = canal;
    }

    @Override
    public void funcionPrincipal() {
        if (isEncendido()) {
            System.out.println(getMarca() + " esta mostrando el canal " + canalActual + ".");
        } else {
            System.out.println(getMarca() + " esta apagado, enciendalo primero para ver television.");
        }
    }
}
