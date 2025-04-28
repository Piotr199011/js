package com.example.cinema;
import java.util.Scanner;

public class Menu {
    private static Repertoire repertoire = new Repertoire();
    private static String selectedCity = null;
    private static User loggedInUser = null;

    public static void login(Scanner scanner) {
        System.out.println("Podaj nazwę użytkownika: ");
        String username = scanner.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        User user = UserManager.authenticate(username, password);

        if (user != null) {
            loggedInUser = user;
            System.out.println("Udało ci się zalogować!");
            displayLoggedInMenu(scanner);
        } else {
            System.out.println("Nieprawidłowa nazwa użytkownika lub hasło. Spróbuj ponownie.");
        }
    }

    private static void displayLoggedInMenu(Scanner scanner) {
        MovieData.initializeRepertoire(repertoire);

        int choice;
        do {
            System.out.println("=========================");
            System.out.println("   MENU ZALOGOWANEGO UŻYTKOWNIKA   ");
            System.out.println("=========================");
            System.out.println("1. Pokaż repertuar");
            System.out.println("2. Wyloguj");
            System.out.println("5. Wyjdź");
            System.out.print("Wybierz opcję: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Proszę podać poprawny numer opcji.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showRepertoire(scanner);
                    break;
                case 2:
                    System.out.println("Wylogowano pomyślnie.");
                    loggedInUser = null;
                    return;
                case 5:
                    System.out.println("Powrót do głównego menu...");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        } while (choice != 5);
    }

    static void showRepertoire(Scanner scanner) {
        MovieData.initializeRepertoire(repertoire);

        if (selectedCity == null || selectedCity.isEmpty()) {
            System.out.println("Wybierz miasto:");
            selectedCity = City.selectCity(scanner);
        }
        ShowtimeSelector.selectShowtime(repertoire, selectedCity, loggedInUser);
    }

    public static boolean isUserLoggedIn() {
        return loggedInUser != null;
    }

    public static void registerNewMember(Scanner scanner) {
        MovieData.initializeRepertoire(repertoire);

        User newUser = UserDetailsCollector.collectUserDetails(scanner);
        UserManager.registerUser(newUser);
        System.out.println("Zarejestrowano nowego użytkownika: " + newUser.toString());

        displayPostRegistrationMenu(scanner);
    }

    private static void displayPostRegistrationMenu(Scanner scanner) {
        MovieData.initializeRepertoire(repertoire);

        int choice;

        do {
            System.out.println("=========================");
            System.out.println("   MENU PO REJESTRACJI   ");
            System.out.println("=========================");
            System.out.println("1. Pokaż repertuar");
            System.out.println("2. Logowanie");
            System.out.println("5. Wyjdź");
            System.out.print("Wybierz opcję: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Proszę podać poprawny numer opcji.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (selectedCity == null || selectedCity.isEmpty()) {
                        System.out.println("Wybierz miasto:");
                        selectedCity = City.selectCity(scanner);
                    }
                    ShowtimeSelector.selectShowtime(repertoire, selectedCity, loggedInUser);
                    break;
                case 2:
                    login(scanner);
                    if (isUserLoggedIn()) {
                        return;
                    }
                    break;
                case 5:
                    System.out.println("Powrót do głównego menu...");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        } while (choice != 5);
    }
}
