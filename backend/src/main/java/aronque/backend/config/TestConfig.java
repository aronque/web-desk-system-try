package aronque.backend.config;

import aronque.backend.entities.Client;
import aronque.backend.entities.Order;
import aronque.backend.entities.OrderItem;
import aronque.backend.entities.Product;
import aronque.backend.repositories.ClientRepository;
import aronque.backend.repositories.OrderItemRepository;
import aronque.backend.repositories.OrderRepository;
import aronque.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client(null, "Vitor", "vitorsiwerskiaronque@gmail.com", "971498206", "Rua Olavo Bilac, 565 - Vila Euclides - SBC");
        Client c2 = new Client(null, "Raquel", "raquelmonari22@gmail.com", "349582305", "Rua Vera Cruz, 455 - Anchieta - SBC");
        Client c3 = new Client(null, "Percio", "percio_bt@yahoo.com.br", "9435612384", "Rua Olavo Bilac, 565 - Vila Euclides - SBC");
        clientRepository.saveAll(Arrays.asList(c1, c2, c3));

        Product p1 = new Product(null, "Pão", "Pão Francês", 0.50);
        Product p2 = new Product(null, "Cerveja", "Cerveja Bitelus", 12.00);
        Product p3 = new Product(null, "Frango Assado", "Frango Assado Frangolino com batata assada ou polenta frita", 37.00);
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Order o1 = new Order(null, Instant.now(), c1);
        Order o2 = new Order(null, Instant.now(), c1);
        Order o3 = new Order(null, Instant.now(), c2);
        Order o4 = new Order(null, Instant.now(), c3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

        OrderItem oi1 = new OrderItem(o1, p1, 1, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p2, 2, p2.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 1, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p1, 5, p1.getPrice());
        OrderItem oi5 = new OrderItem(o3, p2, 1, p2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));

    }
}
