package aronque.backend.services;

import aronque.backend.entities.Client;
import aronque.backend.entities.Order;
import aronque.backend.repositories.ClientRepository;
import aronque.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private ClientRepository clientRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

    public List<Order> findByClient(Long id) {
        Client obj;
        if (clientRepository.findById(id).isPresent()) {
            obj = clientRepository.findById(id).get();
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
        return obj.getOrders();
    }
}
