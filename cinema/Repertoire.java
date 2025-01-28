package com.example.cinema;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repertoire {
    private Map<String, List<LocalTime>> movieShowtimes;
    public Repertoire() {
        movieShowtimes = new HashMap<>();
    }

    public void addMovie(String movieTitle, List<LocalTime> showtimes) {
        movieShowtimes.put(movieTitle, showtimes);
    }

    public List<String> getMovies() {
        return new ArrayList<>(movieShowtimes.keySet());
    }
    public List<LocalTime> getShowtimesForMovie(String movieTitle) {
        return movieShowtimes.getOrDefault(movieTitle, new ArrayList<>());
    }

    public void displayRepertoire() {
        if (movieShowtimes.isEmpty()) {
            System.out.println("Repertuar jest pusty.");
            return;
        }

        for (Map.Entry<String, List<LocalTime>> entry : movieShowtimes.entrySet()) {
            System.out.println("Film: " + entry.getKey());
            System.out.println("Godziny seansów: " + entry.getValue());
        }
    }
}