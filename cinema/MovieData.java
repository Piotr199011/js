package com.example.cinema;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MovieData {
    public static void initializeRepertoire(Repertoire repertoire) {
        List<LocalTime> inceptionTimes = new ArrayList<>();
        inceptionTimes.add(LocalTime.of(14, 0));
        inceptionTimes.add(LocalTime.of(18, 0));
        inceptionTimes.add(LocalTime.of(21, 30));
        repertoire.addMovie("Incepcja", inceptionTimes);

        List<LocalTime> avatarTimes = new ArrayList<>();
        avatarTimes.add(LocalTime.of(15, 0));
        avatarTimes.add(LocalTime.of(19, 0));
        avatarTimes.add(LocalTime.of(22, 0));
        repertoire.addMovie("Avatar", avatarTimes);

        List<LocalTime> interstellarTimes = new ArrayList<>();
        interstellarTimes.add(LocalTime.of(13, 0));
        interstellarTimes.add(LocalTime.of(17, 0));
        interstellarTimes.add(LocalTime.of(20, 30));
        repertoire.addMovie("Interstellar", interstellarTimes);

        List<LocalTime> tenetTimes = new ArrayList<>();
        tenetTimes.add(LocalTime.of(12, 30));
        tenetTimes.add(LocalTime.of(16, 30));
        tenetTimes.add(LocalTime.of(20, 0));
        repertoire.addMovie("Tenet", tenetTimes);
    }
}
