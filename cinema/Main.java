package com.example.cinema;
import java.util.Scanner;
import static com.example.cinema.Menu.*;

public class Main {
    private static Repertoire repertoire = new Repertoire();
    private static String selectedCity = null;
    private static User loggedInUser = null;

    public static void main(String[] args) {
        MovieData.initializeRepertoire(repertoire);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=========================");
            System.out.println("   MULTIPLEKS MENU   ");
            System.out.println("=========================");
            System.out.println("1. Miasto");
            System.out.println("2. Zarejestruj nowego użytkownika");
            System.out.println("3. Zaloguj się");
            System.out.println("4. Pokaż repertuar");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Proszę podać poprawny numer opcji.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Wybierz miasto:");
                    selectedCity = City.selectCity(scanner);
                    CityMenu.displayCityMenu(selectedCity, repertoire, loggedInUser);
                    break;
                case 2:
                    registerNewMember(scanner);
                    break;
                case 3:
                    login(scanner);
                    break;
                case 4:
                    showRepertoire(scanner);
                    break;
                case 5:
                    System.out.println("Dziękujemy za skorzystanie z programu Multipleks. Do zobaczenia!");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
