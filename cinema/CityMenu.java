package com.example.cinema;

import java.util.Scanner;

import static com.example.cinema.Menu.*;

public class CityMenu {

    public static void displayCityMenu(String selectedCity, Repertoire repertoire, User loggedInUser) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=========================");
            System.out.println("Prezentuje repertuar z miasta: " + selectedCity);
            System.out.println("=========================");
            System.out.println("1. Pokaż repertuar");
            System.out.println("2. Zarejestruj nowego użytkownika");
            System.out.println("3. Zaloguj się");
            System.out.println("5. Wyjście do głównego menu");
            System.out.print("Wybierz opcję: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Proszę podać poprawny numer opcji.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Oczyszczenie bufora po odczytaniu liczby

            switch (choice) {
                case 1:
                    ShowtimeSelector.selectShowtime(repertoire, selectedCity,loggedInUser);
                    break;
                case 2:
                    registerNewMember(scanner);
                    break;
                case 3:
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