
public class NotificacionEmail extends Notificacion {

    private final String correo;

    public NotificacionEmail(String destinatario, String mensaje, String correo) {
        super(destinatario, mensaje);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando correo a " + correo + ": " + getMensaje());
        registrarEnvio();
    }
}
