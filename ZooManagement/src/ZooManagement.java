import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter zoo name:");
        String zooName = input.nextLine();
        System.out.println("Enter number of cages:");
        int nbrCages = input.nextInt();
        input.close();

        Zoo myZoo = new Zoo(zooName, "Tunis", nbrCages);
        System.out.println(zooName + " has " + myZoo.getNbrCages() + " cages.");

        // Testing addAnimal
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        System.out.println("Added lion: " + myZoo.addAnimal(lion));

        // Adding beyond capacity
        for (int i = 0; i < 30; i++) {
            Animal a = new Animal("Species" + i, "Animal" + i, i, true);
            if (!myZoo.addAnimal(a)) {
                System.out.println("Failed to add animal " + i);
            }
        }

        myZoo.displayAnimals();

        // Testing search
        Animal dummyLion = new Animal("", "Simba", 0, false);
        System.out.println("Simba found at index: " + myZoo.searchAnimal(dummyLion));

        // Testing duplicate
        Animal simba2 = new Animal("Felidae", "Simba", 3, true);
        System.out.println("Add duplicate: " + myZoo.addAnimal(simba2));

        // Testing remove
        System.out.println("Remove Simba: " + myZoo.removeAnimal(dummyLion));
        myZoo.displayAnimals();

        // Test zoo comparison
        Zoo zoo2 = new Zoo("Smaller Zoo", "City", 5);
        Zoo bigger = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("Larger zoo: " + bigger);
    }
}