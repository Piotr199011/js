package com.example.cinema;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ShowtimeSelector {
    public static void selectShowtime(Repertoire repertoire, String selectedCity, User loggedInUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybrano miasto: " + selectedCity);
        System.out.println("Wybrano opcję: Pokaż repertuar.");

        // Wybór dnia seansu
        System.out.println("Wybierz dzień seansu (0 = dzisiaj, 1 = jutro, ..., 6 = za 6 dni): ");
        int dayOffset = scanner.nextInt();
        LocalDate selectedDate = LocalDate.now().plusDays(dayOffset);
        System.out.println("Wybrano dzień: " + selectedDate.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")));

        // Wyświetlanie dostępnych filmów
        System.out.println("Dostępne filmy:");
        List<String> movies = repertoire.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }

        // Wybór filmu
        System.out.println("Wybierz numer filmu: ");
        int movieChoice = scanner.nextInt();
        String selectedMovie = movies.get(movieChoice - 1);
        System.out.println("Wybrano film: " + selectedMovie);

        // Wyświetlanie dostępnych godzin seansów
        System.out.println("Dostępne godziny seansów: ");
        List<LocalTime> times = repertoire.getShowtimesForMovie(selectedMovie);
        for (int i = 0; i < times.size(); i++) {
            System.out.println((i + 1) + ". " + times.get(i));
        }

        // Wybór godziny seansu
        System.out.println("Wybierz godzinę seansu: ");
        int timeChoice = scanner.nextInt();
        LocalTime selectedTime = times.get(timeChoice - 1);
        System.out.println("Wybrano seans: " + selectedMovie + " o godzinie " + selectedTime + " dnia " + selectedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        scanner.nextLine(); // Oczyszczenie bufora po odczytaniu liczby

        String fullName;
        if (loggedInUser != null) {
            fullName = loggedInUser.getFirstName() + " " + loggedInUser.getLastName();
        } else {
            System.out.println("Podaj imię i nazwisko osoby rezerwującej: ");
            fullName = scanner.nextLine();
        }
        List<String> selectedSeats = SeatSelector.selectSeats(scanner);

        System.out.println("======================");
        System.out.println("PODSUMOWANIE REZERWACJI:");
        System.out.println("Miasto: " + selectedCity);
        System.out.println("Film: " + selectedMovie);
        System.out.println("Data: " + selectedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Godzina: " + selectedTime);
        System.out.println("Rezerwujący: " + fullName);
        System.out.println("Miejsca: " + String.join(", ", selectedSeats));
        System.out.println("======================");
    }
}
