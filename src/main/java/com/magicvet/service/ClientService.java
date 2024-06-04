package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private final static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private final static String NAME_PATTERN = "^[A-Z][a-z]+(-[A-Z][a-z]+)*";

    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if (emailIsValid(email)) {
            System.out.print("Firs name: ");
            String firstName = Main.SCANNER.nextLine();
            if (nameIsValid(firstName)) {
                System.out.print("Last name: ");
                String lastName = Main.SCANNER.nextLine();
                if (nameIsValid(lastName)) {
                    client = buildClient(email, firstName, lastName);
                    System.out.println("New client: " + client.getFirstName() + " "
                            + client.getLastName() + " ("
                            + client.getEmail() + ")");
                } else {
                    System.out.println("Provide last name is invalid.");
                }
            } else {
                System.out.println("Provide first name is invalid.");
            }
        } else {
            System.out.println("Provide email is invalid.");
        }

        return client;
    }

    private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        System.out.print("Location: ");
        String locationInput = Main.SCANNER.nextLine();
        client.setLocation(Client.Location.locationFromString(locationInput));

        return client;
    }

    private static boolean emailIsValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean nameIsValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
