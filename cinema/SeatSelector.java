package com.example.cinema;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatSelector {
    private static final int ROWS = 5;
    private static final int SEATS_PER_ROW = 10;
    private static boolean[][] seats = new boolean[ROWS][SEATS_PER_ROW];
    private static boolean[][] vipSeats = new boolean[ROWS][SEATS_PER_ROW];

    static {
        for (int i = 0; i < ROWS; i++) {
            vipSeats[i][4] = true;
            vipSeats[i][5] = true;
        }
    }

    public static List<String> selectSeats(Scanner scanner) {
        System.out.println("Układ sali (O - wolne, X - zajęte, V - miejsce VIP):");
        displaySeats();

        List<String> selectedSeats = new ArrayList<>();
        while (true) {
            System.out.println("Wybierz miejsce (np. 1A) lub wpisz 'koniec', aby zakończyć wybór: ");
            String input = scanner.next().toUpperCase();

            if (input.equals("KONIEC")) {
                break;
            }

            if (isValidSeat(input)) {
                int row = input.charAt(0) - '1';
                int col = input.charAt(1) - 'A';

                if (!seats[row][col]) {
                    seats[row][col] = true;
                    selectedSeats.add(input + (vipSeats[row][col] ? " (VIP)" : ""));
                    System.out.println("Zarezerwowano miejsce: " + input + (vipSeats[row][col] ? " (VIP)" : ""));
                } else {
                    System.out.println("Miejsce " + input + " jest już zajęte. Wybierz inne.");
                }
            } else {
                System.out.println("Nieprawidłowe miejsce. Podaj poprawny format (np. 1A).");
            }

            displaySeats();
        }

        if (selectedSeats.isEmpty()) {
            System.out.println("Nie wybrano żadnych miejsc.");
        } else {
            System.out.println("Zarezerwowane miejsca: " + String.join(", ", selectedSeats));
        }

        return selectedSeats;
    }

    private static void displaySeats() {
        System.out.println("   A B C D E F G H I J");
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                if (seats[i][j]) {
                    System.out.print("X ");
                } else if (vipSeats[i][j]) {
                    System.out.print("V ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isValidSeat(String seat) {
        if (seat.length() != 2) return false;

        char row = seat.charAt(0);
        char col = seat.charAt(1);

        return row >= '1' && row <= '5' && col >= 'A' && col <= 'J';
    }
}

