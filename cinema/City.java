package com.example.cinema;

import java.util.Scanner;

public class City {
    public static String selectCity(Scanner scanner) {
        System.out.println("1. Warszawa");
        System.out.println("2. Kraków");
        System.out.println("3. Wrocław");

        System.out.print("Wybierz miasto: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); //
        switch (choice) {
            case 1:
                return "Warszawa";
            case 2:
                return "Kraków";
            case 3:
                return "Wrocław";
            default:
                System.out.println("Nieprawidłowy wybór, domyślnie ustawiono Warszawę.");
                return "Warszawa";
        }
    }
}