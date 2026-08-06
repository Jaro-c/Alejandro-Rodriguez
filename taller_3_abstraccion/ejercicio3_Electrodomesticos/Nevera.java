
public class Nevera extends Electrodomestico {

    public Nevera(String marca) {
        super(marca);
    }

    @Override
    public void funcionPrincipal() {
        if (isEncendido()) {
            System.out.println(getMarca() + " esta enfriando los alimentos que tiene guardados.");
        } else {
            System.out.println(getMarca() + " esta apagada, enciendala primero para poder enfriar.");
        }
    }
}
