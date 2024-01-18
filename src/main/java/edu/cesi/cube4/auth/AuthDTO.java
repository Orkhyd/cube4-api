package edu.cesi.cube4.auth;

import lombok.Data;

public class AuthDTO {

    @Data
    public static class LoginRequest {
        private String username;
        private String password;

    }

    @Data
    public static class SignupRequest {
        private String username;
        private String password;
    }

    @Data
    public static class Response {
        private Boolean connected;
        private String message;
        private String token;

        public Response(Boolean connected, String message, String token) {
            this.connected = connected;
            this.message = message;
            this.token = token;
        }
    }
}
