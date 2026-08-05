
public class Instructor extends Usuario {

    private String especialidad;

    public Instructor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    @Override
    public void iniciarSesion() {
        super.iniciarSesion();
        System.out.println("Panel del instructor - especialidad: " + especialidad);
    }
}
