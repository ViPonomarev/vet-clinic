package main.java.com.magicvet;

import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {
        Pet[] pets = {
                new Pet("Cat","male","22","Zero", "Bill", Pet.HealthState.EXCELLENT),
                new Pet("Cat","female","13","Lucky", "Anna", Pet.HealthState.BAD ),
                new Pet("Dog","male","4","Jerry", "John", Pet.HealthState.NORMAL),
                new Pet("Cat","female","6","Sara", "Tommy", Pet.HealthState.BAD),
                new Pet("Dog","male","15","Tom", "Colin", Pet.HealthState.NORMAL),
                new Pet("Cat","female","3","Annabel", "Trump", Pet.HealthState.EXCELLENT),

        };

        Dog[] dogs = {
                new Dog(Dog.Size.M),
                new Dog(Dog.Size.S),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XL),
                new Dog(Dog.Size.XS),
                new Dog(Dog.Size.S),

        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        System.out.println("Sort dog size:");

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("\nSort pet name:");

        for (Pet pet : pets) {
            System.out.println(pet);
        }

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return Integer.parseInt(o1.getAge()) - Integer.parseInt(o2.getAge());
            }
        });

        System.out.println("\nSort pet age:");

        for (Pet pet : pets) {
            System.out.println(pet);
        }

        Arrays.sort(pets, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getHealthState().getValue() - o2.getHealthState().getValue();
            }
        });

        System.out.println("\nSort pet health state:");

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
