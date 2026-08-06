
public class Loro extends Animal {

    public Loro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " repite sin parar: Hola, hola, hola!");
    }
}
