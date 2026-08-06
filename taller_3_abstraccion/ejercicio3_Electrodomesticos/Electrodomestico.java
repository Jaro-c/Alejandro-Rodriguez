
public abstract class Electrodomestico {

    private final String marca;
    private boolean encendido;

    protected Electrodomestico(String marca) {
        this.marca = marca;
        this.encendido = false;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void encender() {
        encendido = true;
        System.out.println(marca + " se encendio correctamente.");
    }

    public void apagar() {
        encendido = false;
        System.out.println(marca + " se apago.");
    }

    public abstract void funcionPrincipal();
}
