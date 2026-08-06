
// CONSTRUYE TU MISMO: la tercera forma de notificar, siguiendo el mismo
// contrato del padre pero recibiendo el numero de WhatsApp del destinatario.
public class NotificacionWhatsApp extends Notificacion {

    private final String numeroWhatsApp;

    public NotificacionWhatsApp(String destinatario, String mensaje, String numeroWhatsApp) {
        super(destinatario, mensaje);
        this.numeroWhatsApp = numeroWhatsApp;
    }

    public String getNumeroWhatsApp() {
        return numeroWhatsApp;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando WhatsApp a " + numeroWhatsApp + ": " + getMensaje());
        registrarEnvio();
    }
}
