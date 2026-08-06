
public class MainNotificaciones {

    public static void main(String[] args) {

        NotificacionEmail notificacionEmail = new NotificacionEmail(
                "Sofia Martinez", "Su pedido ha sido despachado.", "sofia.martinez@correo.com");
        NotificacionSMS notificacionSMS = new NotificacionSMS(
                "Andres Lopez", "Su codigo de verificacion es 4821.", "3115678901");
        NotificacionWhatsApp notificacionWhatsApp = new NotificacionWhatsApp(
                "Valentina Cruz", "Recuerde que su cita es manana a las 9am.", "3204567890");

        Notificacion[] notificaciones = { notificacionEmail, notificacionSMS, notificacionWhatsApp };

        System.out.println("=== Enviando notificaciones por distintos canales ===");
        for (Notificacion notificacion : notificaciones) {
            notificacion.enviar();
            System.out.println("-----");
        }
    }
}
