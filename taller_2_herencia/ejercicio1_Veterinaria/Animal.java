
public abstract class Animal {

    private final String nombre;
    private final String especie;
    private int edad;

    protected Animal(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public void comer() {
        System.out.println(nombre + " esta comiendo.");
    }

    public void dormir() {
        System.out.println(nombre + " esta durmiendo.");
    }

    public void presentarse() {
        System.out.println("Hola, soy " + nombre + ", una/un " + especie
                + " de " + edad + " anios.");
    }

    public abstract void hacerSonido();
}
