package com.example.cinema;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static Map<String, User> users = new HashMap<>();

    public static void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public static User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
