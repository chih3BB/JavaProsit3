import java.util.Arrays;

public class Zoo {
    private final int MAX_ANIMALS = 25;
    Animal[] animals;
    String name;
    String city;
    int animalCount;

    Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[MAX_ANIMALS];
        this.animalCount = 0;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter plus d'animaux.");
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                System.out.println("L'animal existe déjà dans le zoo.");
                return false;
            }
        }
        animals[animalCount++] = animal;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animaux du zoo " + name + " :");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i].name);
        }
    }

    public int searchAnimal(String name) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal.name);
        if (index == -1) {
            System.out.println("Animal non trouvé.");
            return false;
        }
        animals[index] = animals[animalCount - 1]; // Remplacement par le dernier animal
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= MAX_ANIMALS;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }

    public void displayZoo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of Animals: " + animalCount);
    }
}
