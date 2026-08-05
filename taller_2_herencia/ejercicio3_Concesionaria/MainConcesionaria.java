
public class MainConcesionaria {

    public static void main(String[] args) {
        Vehiculo[] inventario = new Vehiculo[3];

        inventario[0] = new Carro("Mazda", "3", 75000000, 4);
        inventario[1] = new Moto("Yamaha", "MT-03", 22000000, 321);
        inventario[2] = new Camioneta("Chevrolet", "Colorado", 130000000, 1200);

        System.out.println("=== Inventario de la concesionaria ===");
        for (Vehiculo vehiculo : inventario) {
            vehiculo.describir();
        }
    }
}
