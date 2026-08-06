
public class MainHogar {

    public static void main(String[] args) {

        Televisor televisor = new Televisor("Samsung");
        Nevera nevera = new Nevera("LG");
        Lavadora lavadora = new Lavadora("Whirlpool");

        Electrodomestico[] electrodomesticos = { televisor, nevera, lavadora };

        System.out.println("=== Probando la nevera SIN encenderla primero ===");
        nevera.funcionPrincipal();

        System.out.println("=== Encendiendo todos los electrodomesticos del hogar ===");
        for (Electrodomestico aparato : electrodomesticos) {
            aparato.encender();
            aparato.funcionPrincipal();
            System.out.println("-----");
        }

        System.out.println("=== Metodo propio de la lavadora ===");
        lavadora.centrifugar();

        System.out.println("=== Apagando la television ===");
        televisor.apagar();
        televisor.funcionPrincipal();
    }
}
