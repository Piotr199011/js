package com.example.cinema;

public class User{
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String username;
        private String password;

        public User(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.username = username;
            this.password = password;
        }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "Imię: " + firstName +
                    ", Nazwisko: " + lastName +
                    ", Email: " + email +
                    ", Telefon: " + phoneNumber +
                    ", Nazwa użytkownika: " + username;
        }
}
