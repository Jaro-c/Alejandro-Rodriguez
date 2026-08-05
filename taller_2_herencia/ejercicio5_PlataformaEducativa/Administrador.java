
public class Administrador extends Usuario {

    private NivelPermiso nivelPermiso;

    public Administrador(String nombre, String correo, NivelPermiso nivelPermiso) {
        super(nombre, correo);
        this.nivelPermiso = nivelPermiso;
    }

    @Override
    public void iniciarSesion() {
        super.iniciarSesion();
        System.out.println("Panel de administracion - nivel de permiso: " + nivelPermiso);
    }
}
