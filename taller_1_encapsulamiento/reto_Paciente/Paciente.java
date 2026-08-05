
public class Paciente {

    private static final String CLAVE_MEDICO_AUTORIZADO = "MED-2026";

    private static final String[] TIPOS_SANGRE_VALIDOS = {
            "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"
    };

    private String documento;
    private String nombre;
    private int edad;
    private String tipoSangre;

    private String diagnostico;

    private String[] alergias;
    private int totalAlergias;

    public Paciente(String documento, String nombre, int edad, String tipoSangre) {
        this.documento = documento;
        this.nombre = nombre;
        setEdad(edad);
        setTipoSangre(tipoSangre);
        this.diagnostico = "Sin diagnostico registrado";
        this.alergias = new String[2];
        this.totalAlergias = 0;
    }

    private void setEdad(int edadPropuesta) {
        if (edadPropuesta < 0 || edadPropuesta > 120) {
            throw new DatoClinicoInvalidoException(
                    "Edad fuera de rango permitido (0-120): " + edadPropuesta);
        }
        this.edad = edadPropuesta;
    }

    private void setTipoSangre(String tipoPropuesto) {
        for (String valido : TIPOS_SANGRE_VALIDOS) {
            if (valido.equals(tipoPropuesto)) {
                this.tipoSangre = tipoPropuesto;
                return;
            }
        }
        throw new DatoClinicoInvalidoException(
                "Tipo de sangre invalido: " + tipoPropuesto);
    }

    private void validarClave(String claveMedico) {
        if (claveMedico == null || !claveMedico.equals(CLAVE_MEDICO_AUTORIZADO)) {
            throw new AccesoNoAutorizadoException(
                    "Clave de medico incorrecta: acceso al diagnostico denegado");
        }
    }

    public String consultarDiagnostico(String claveMedico) {
        validarClave(claveMedico);
        return diagnostico;
    }

    public void actualizarDiagnostico(String nuevoDiagnostico, String claveMedico) {
        validarClave(claveMedico);
        if (nuevoDiagnostico == null || nuevoDiagnostico.isBlank()) {
            throw new DatoClinicoInvalidoException("El diagnostico no puede estar vacio");
        }
        this.diagnostico = nuevoDiagnostico;
    }

    public boolean tieneAlergias() {
        return totalAlergias > 0;
    }

    public void agregarAlergia(String alergia) {
        if (alergia == null || alergia.isBlank()) {
            throw new DatoClinicoInvalidoException("La alergia no puede estar vacia");
        }
        if (totalAlergias == alergias.length) {
            crecerArregloAlergias();
        }
        alergias[totalAlergias] = alergia;
        totalAlergias++;
    }

    private void crecerArregloAlergias() {
        String[] arregloAmpliado = new String[alergias.length + 1];
        for (int i = 0; i < alergias.length; i++) {
            arregloAmpliado[i] = alergias[i];
        }
        alergias = arregloAmpliado;
    }

    public String[] getAlergias() {
        String[] copia = new String[totalAlergias];
        for (int i = 0; i < totalAlergias; i++) {
            copia[i] = alergias[i];
        }
        return copia;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    @Override
    public String toString() {
        StringBuilder listaAlergias = new StringBuilder();
        for (int i = 0; i < totalAlergias; i++) {
            listaAlergias.append(alergias[i]);
            if (i < totalAlergias - 1) {
                listaAlergias.append(", ");
            }
        }
        if (totalAlergias == 0) {
            listaAlergias.append("ninguna registrada");
        }

        return "Paciente{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", alergias=[" + listaAlergias + "]" +
                '}';
    }
}
