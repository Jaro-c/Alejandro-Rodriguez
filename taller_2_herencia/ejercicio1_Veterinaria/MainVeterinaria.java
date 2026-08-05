
public class MainVeterinaria {

    public static void main(String[] args) {
        Perro firulais = new Perro("Firulais", 3);
        Gato michi = new Gato("Michi", 2);
        Pajaro piolin = new Pajaro("Piolin", 1);

        Animal[] animales = { firulais, michi, piolin };

        System.out.println("=== Recorrido general de la veterinaria ===");
        for (Animal mascota : animales) {
            mascota.presentarse();
            mascota.comer();
            mascota.dormir();
            mascota.hacerSonido();
            System.out.println("-----");
        }

        System.out.println("=== Habilidades propias de cada especie ===");
        firulais.perseguirCola();
        michi.ronronear();
        piolin.volar();
    }
}
