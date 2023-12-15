package edu.cesi.cube4.auth;

import lombok.Data;

public class AuthDTO {

    // Nested static class for login request
    @Data
    public static class LoginRequest {
        private String username;
        private String password;

        // Constructors, getters, and setters
    }

    @Data
    public static class SignupRequest {
        private String username;
        private String password;
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
