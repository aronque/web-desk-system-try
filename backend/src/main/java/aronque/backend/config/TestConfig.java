package aronque.backend.config;

import aronque.backend.entities.Product;
import aronque.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product(null, "Pão", "Pão Francês", 0.50);
        repository.save(p1);


    }
}
