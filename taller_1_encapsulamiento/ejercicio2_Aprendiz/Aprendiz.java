
public class Aprendiz {

    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 5.0;
    private static final double NOTA_APROBATORIA = 3.5;
    private static final int EDAD_MINIMA = 0;
    private static final int EDAD_MAXIMA = 100;

    private final String numeroDocumento;
    private final String nombre;
    private int edad;
    private double notaFinal;
    private String correoInstitucional;

    public Aprendiz(String numeroDocumento, String nombre) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.edad = 0;
        this.notaFinal = 0.0;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            throw new DatoInvalidoException(
                "Edad fuera de rango: " + edad + ". Debe estar entre " + EDAD_MINIMA + " y " + EDAD_MAXIMA + " anios.");
        }
        this.edad = edad;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        if (notaFinal < NOTA_MINIMA || notaFinal > NOTA_MAXIMA) {
            throw new DatoInvalidoException(
                "Nota fuera de rango: " + notaFinal + ". Debe estar entre " + NOTA_MINIMA + " y " + NOTA_MAXIMA + ".");
        }
        this.notaFinal = notaFinal;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        if (correoInstitucional == null || !correoInstitucional.contains("@")) {
            throw new DatoInvalidoException(
                "Correo invalido: '" + correoInstitucional + "'. Debe contener el simbolo @.");
        }
        this.correoInstitucional = correoInstitucional;
    }

    public boolean haAprobado() {
        return notaFinal >= NOTA_APROBATORIA;
    }

    @Override
    public String toString() {
        return "Documento: " + numeroDocumento
            + " | Nombre: " + nombre
            + " | Edad: " + edad
            + " | Nota final: " + notaFinal
            + " | Correo: " + (correoInstitucional == null ? "(sin asignar)" : correoInstitucional)
            + " | Aprobo: " + (haAprobado() ? "Si" : "No");
    }
}
