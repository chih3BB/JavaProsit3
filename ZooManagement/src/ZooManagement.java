import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Création du zoo
        System.out.println("Donner le nom du zoo:");
        String zooName = input.nextLine();
        Zoo myZoo = new Zoo(zooName, "Tunis");

        // Ajout d'animaux
        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal tigre = new Animal("Félins", "Tigre", 4, true);
        Animal elephant = new Animal("Éléphantidés", "Éléphant", 10, false);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(tigre);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(lion); // Test d'ajout d'un doublon

        myZoo.displayZoo();
        myZoo.displayAnimals();

        // Recherche d'un animal
        System.out.println("Recherche de l'animal 'Tigre':");
        int index = myZoo.searchAnimal("Tigre");
        System.out.println("Indice de l'animal 'Tigre': " + index);

        // Suppression d'un animal
        System.out.println("Suppression de l'animal 'Tigre':");
        myZoo.removeAnimal(tigre);
        myZoo.displayAnimals();

        input.close();
    }
}
