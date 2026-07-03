package com.example.Medicine.Drug_OS.Configurations;


import com.example.Medicine.Drug_OS.Entity.AdminUser;
import com.example.Medicine.Drug_OS.Reposit.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner createAdmin(UserRepository repository,
                                  PasswordEncoder encoder) {

        return args -> {

            if (repository.findByUsername("admin") == null) {

                AdminUser admin = new AdminUser();

                admin.setName("System Administrator");
                admin.setUsername("admin");
                admin.setEmail("admin@gmail.com");
                admin.setPassword(encoder.encode("admin123"));
                admin.setPhoneNumber("0711111111");
                admin.setAddress("Colombo");

                repository.save(admin);


                System.out.println("ADMIN USER CREATED SUCCESSFULLY");
                System.out.println("Username : admin");
                System.out.println("Password : admin123");

            }

        };
    }

}