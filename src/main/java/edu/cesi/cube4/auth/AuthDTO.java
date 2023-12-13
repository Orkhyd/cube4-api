package edu.cesi.cube4.auth;

import lombok.Data;

public class AuthDTO {

    // Nested static class for login request
    @Data
    public static class LoginRequest {
        private String nomUtilisateur;
        private String motDePasse;

        // Constructors, getters, and setters
    }

    // Nested static class for login response
    @Data
    public static class Response {
        private String message;
        private String token;

        public Response(String message, String token) {
            this.message = message;
            this.token = token;
        }

        // Getters and setters
    }

    // Additional DTOs for other authentication-related data
}
