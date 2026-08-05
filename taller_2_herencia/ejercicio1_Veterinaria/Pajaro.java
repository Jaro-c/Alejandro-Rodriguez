
public class Pajaro extends Animal {

    public Pajaro(String nombre, int edad) {
        super(nombre, "Pajaro", edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " canta: Pio pio!");
    }

    public void volar() {
        System.out.println(getNombre() + " alza vuelo y se pierde entre las ramas.");
    }
}
