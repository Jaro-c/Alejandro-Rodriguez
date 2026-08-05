
public class Perro extends Animal {

    public Perro(String nombre, int edad) {
        super(nombre, "Perro", edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " ladra: Guau guau!");
    }

    public void perseguirCola() {
        System.out.println(getNombre() + " gira sin parar persiguiendo su propia cola.");
    }
}
