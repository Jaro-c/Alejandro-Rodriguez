
public class NotificacionSMS extends Notificacion {

    private final String celular;

    public NotificacionSMS(String destinatario, String mensaje, String celular) {
        super(destinatario, mensaje);
        this.celular = celular;
    }

    public String getCelular() {
        return celular;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS al celular " + celular + ": " + getMensaje());
        registrarEnvio();
    }
}
