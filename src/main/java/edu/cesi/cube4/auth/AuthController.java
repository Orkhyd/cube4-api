package edu.cesi.cube4.auth;
import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.repository.AdminRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminRepo adminRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO.LoginRequest userLogin) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            userLogin.getUsername().toLowerCase(),
                            userLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            AuthUser userDetails = (AuthUser) authentication.getPrincipal();
            log.info("Token requested for user :{}", authentication.getAuthorities());
            String token = authService.generateToken(authentication);

            AuthDTO.Response response = new AuthDTO.Response("User logged in successfully", token);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            log.error("Login failed for user: {}", userLogin.getUsername(), e);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Login failed: Incorrect username or password");
        } catch (Exception e) {
            log.error("Login error for user: {}", userLogin.getUsername(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Login error: Internal server error");
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody AuthDTO.SignupRequest signUpRequest) {
        if (adminRepo.findByUsername(signUpRequest.getUsername().toLowerCase()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }

        Admin newUser = new Admin();
        newUser.setUsername(signUpRequest.getUsername().toLowerCase());
        newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        adminRepo.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }

}