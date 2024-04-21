package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[A-Z][a-z]+(-[A-Z][a-z]+)*";

    public Main() {
    }

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }

    }

    static boolean auth() {
        boolean accepted = false;

        for(int i = 0; i < 3; ++i) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            }

            System.out.println("Access denied. Please check your password.");
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        if (emailIsValid(email)) {
            System.out.print("Firs name: ");
            String firstName = SCANNER.nextLine();
            if (nameInvalid(firstName)) {
                System.out.print("Last name: ");
                String lastName = SCANNER.nextLine();
                if (nameInvalid(lastName)) {
                    Client client = buildClient(email, firstName, lastName);
                    System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
                } else {
                    System.out.println("Provide last name is invalid.");
                }
            } else {
                System.out.println("Provide first name is invalid.");
            }
        } else {
            System.out.println("Provide email is invalid.");
        }

    }

    static boolean nameInvalid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.email = email;
        client.firstName = firstName;
        client.lastName = lastName;
        return client;
    }

    static boolean emailIsValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
