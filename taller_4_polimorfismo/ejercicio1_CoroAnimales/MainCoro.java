
public class MainCoro {

    public static void main(String[] args) {
        Perro firulais = new Perro("Firulais");
        Gato michi = new Gato("Michi");
        Vaca lola = new Vaca("Lola");
        Loro paco = new Loro("Paco");
        Loro rio = new Loro("Rio");

        Animal[] coroDeAnimales = { firulais, michi, lola, paco, rio };

        System.out.println("=== Coro de animales de la granja ===");
        for (Animal animal : coroDeAnimales) {
            animal.hacerSonido();
        }
        System.out.println("=== Fin del coro: cada animal sono con su propia voz ===");
    }
}
