public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    public static final int MAX_CAGES = 25;
    private int animalCount = 0;

    public Zoo(String name, String city, int nbrCages) {
        this.nbrCages = Math.min(nbrCages, MAX_CAGES);
        this.animals = new Animal[this.nbrCages];
        this.name = name;
        this.city = city;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull() || searchAnimal(animal) != -1) {
            return false;
        }
        animals[animalCount++] = animal;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animals in " + name + ":");
        for (int i = 0; i < animalCount; i++) {
            Animal a = animals[i];
            System.out.println("Name: " + a.name + ", Family: " + a.family + ", Age: " + a.age + ", Mammal: " + a.isMammal);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) return false;
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[--animalCount] = null;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount > z2.animalCount) ? z1 : z2;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public void displayZoo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of Cages: " + nbrCages);
    }

    @Override
    public String toString() {
        return "Zoo: " + name + " in " + city + " (" + animalCount + "/" + nbrCages + " animals)";
    }
}