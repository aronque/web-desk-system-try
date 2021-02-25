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
import java.util.HashSet;
import java.util.Set;

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
        clientRepository.save(c1);

        Product p1 = new Product(null, "Pão", "Pão Francês", 0.50);
        productRepository.save(p1);

        Order o1 = new Order(null, Instant.now(), c1);
        Set<OrderItem> list = new HashSet<>();
        OrderItem oi1 = new OrderItem(o1, p1, 1, p1.getPrice());
        list.add(oi1);

        o1.setProductList(list);
        orderRepository.save(o1);
    }
}
