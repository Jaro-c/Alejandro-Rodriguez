
public class Gato extends Animal {

    public Gato(String nombre, int edad) {
        super(nombre, "Gato", edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " maulla: Miau!");
    }

    public void ronronear() {
        System.out.println(getNombre() + " ronronea de gusto mientras lo acarician.");
    }
}
