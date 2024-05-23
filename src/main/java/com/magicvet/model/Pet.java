package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pet {

    protected static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet() { }

    public Pet(String type, String sex, String age, String name, String ownerName, HealthState healthState) {
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.ownerName = ownerName;
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return  "{type = " + type
                + ", age = " + age
                + ", name = " + name
                + ", sex = " + sex
                + ", health state = " + healthState
                + ", registrationDate = " + registrationDate.format(FORMATTER) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public enum HealthState {

        EXCELLENT(3),
        NORMAL(2),
        BAD(1),
        UNKNOWN(0);

        private final int value;

        HealthState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
