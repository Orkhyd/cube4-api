package edu.cesi.cube4;

import edu.cesi.cube4.config.RsaKeyConfigProperties;
import edu.cesi.cube4.model.Admin;
import edu.cesi.cube4.repository.AdminRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class Cube4Application {

	public static void main(String[] args) {
		SpringApplication.run(Cube4Application.class, args);
	}

//	@Bean
//	public CommandLineRunner initializeUser(AdminRepo userRepository, BCryptPasswordEncoder passwordEncoder) {
//		return args -> {
//
//			Admin user = new Admin();
//			user.setUsername("exampleuser");
//			user.setPassword(passwordEncoder.encode("examplepassword"));
//
//			// Save the user to the database
//			userRepository.save(user);
//
//		};
//	}

}
