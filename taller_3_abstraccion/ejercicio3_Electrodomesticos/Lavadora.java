
// CONSTRUYE TU MISMO: ademas de implementar el metodo abstracto del padre,
// la lavadora tiene un metodo propio (centrifugar) que no existe en
// Electrodomestico ni en las otras hijas, solo disponible en esta subclase.
public class Lavadora extends Electrodomestico {

    public Lavadora(String marca) {
        super(marca);
    }

    @Override
    public void funcionPrincipal() {
        if (isEncendido()) {
            System.out.println(getMarca() + " esta lavando ropa a 40 grados C durante 45 minutos.");
        } else {
            System.out.println(getMarca() + " esta apagada, enciendala primero para lavar.");
        }
    }

    public void centrifugar() {
        if (isEncendido()) {
            System.out.println(getMarca() + " esta centrifugando la ropa a maxima velocidad.");
        } else {
            System.out.println(getMarca() + " esta apagada, enciendala primero para centrifugar.");
        }
    }
}
