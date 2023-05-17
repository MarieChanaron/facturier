package fr.mariech.facturier;

import fr.mariech.facturier.entity.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FacturierApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FacturierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Admin admin = new Admin("admin@my-invoice.fr", passwordEncoder.encode("qwerty"));
    }
}
