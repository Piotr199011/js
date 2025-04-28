package com.example.cinema;
import java.time.LocalTime;

public class MovieSchedule {
    private String movie;
    private LocalTime time;

    public MovieSchedule(String movie, LocalTime time) {
        this.movie = movie;
        this.time = time;
    }

    public String getMovie() {
        return movie;
    }

    public LocalTime getTime() {
        return time;
    }
}
