
public class MainIPS {

    public static void main(String[] args) {

        Medico medico = new Medico("1001", "Dra. Laura Gomez", 2000000, "Pediatria", 20);
        Enfermero enfermero = new Enfermero("1002", "Enf. Carlos Ruiz", 1300000, Turno.NOCHE);
        Administrativo administrativo = new Administrativo("1003", "Ana Torres", 1500000, "Facturacion");

        PersonalIPS[] personal = { medico, enfermero, administrativo };

        for (PersonalIPS empleado : personal) {
            empleado.mostrarInfo();
            empleado.registrarAsistencia();
        }
    }
}
