package com.example.cinema;
import java.util.Scanner;

public class UserDetailsCollector {
        public static User collectUserDetails(Scanner scanner) {
                System.out.println("Podaj imię: ");
                String firstName = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email: ");
                String email = scanner.nextLine();
                System.out.println("Podaj numer telefonu: ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Podaj nazwę użytkownika: ");
                String username = scanner.nextLine();
                System.out.println("Podaj hasło: ");
                String password = scanner.nextLine();

                return new User(firstName, lastName, email, phoneNumber, username, password);
        }}
