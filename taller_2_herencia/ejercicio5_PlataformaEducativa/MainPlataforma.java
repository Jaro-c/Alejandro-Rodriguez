
public class MainPlataforma {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("Laura Gomez", "laura.gomez@correo.com", 4);
        Instructor instructor = new Instructor("Carlos Perez", "carlos.perez@correo.com", "Programacion Java");
        Administrador administrador = new Administrador("Marta Diaz", "marta.diaz@correo.com", NivelPermiso.TOTAL);

        Usuario[] usuarios = { estudiante, instructor, administrador };

        for (Usuario usuario : usuarios) {
            usuario.iniciarSesion();
            System.out.println("-----");
        }
    }
}
