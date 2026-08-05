
public class Estudiante extends Usuario {

    private int cursosInscritos;

    public Estudiante(String nombre, String correo, int cursosInscritos) {
        super(nombre, correo);
        this.cursosInscritos = cursosInscritos;
    }

    @Override
    public void iniciarSesion() {
        super.iniciarSesion();
        System.out.println("Tienes " + cursosInscritos + " curso(s) disponible(s) en tu panel de estudiante.");
    }
}
