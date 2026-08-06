
public abstract class Notificacion {

    private final String destinatario;
    private final String mensaje;

    protected Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public abstract void enviar();

    public void registrarEnvio() {
        System.out.println("LOG -> Notificacion registrada para " + destinatario
                + " con mensaje: \"" + mensaje + "\"");
    }
}
