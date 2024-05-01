package main.java.com.magicvet;

import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.comparator.PetNameComparator;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class Sandbox {

    public static void main(String[] args) {
        Pet[] pets = {
                new Pet("Cat","male","22","Zero", "Bill"),
                new Pet("Cat","female","13","Lucky", "Anna"),
                new Pet("Cat","male","4","Jerry", "John"),
                new Pet("Cat","female","6","Sara", "Tommy"),
                new Pet("Cat","male","15","Tom", "Colin"),
                new Pet("Cat","female","3","Annabel", "Trump"),

        };

        System.out.println("Sort age:");
        Arrays.sort(pets, new PetAgeComparator());

        for (Pet pet : pets) {
            System.out.println(pet);
        }

        System.out.println("\nSort name:");
        Arrays.sort(pets, new PetNameComparator());

        for (Pet pet : pets) {
            System.out.println(pet);
        }

    }
}
