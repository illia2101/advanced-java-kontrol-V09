package ua.university.service;

import ua.university.OrderStatus;
import ua.university.domain.Order;
import ua.university.process.OrderProcessorTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class OrderService {
    private static final Logger log = Logger.getLogger(OrderProcessorTemplate.class.getName());
    private final Map<String, Order> storage = new HashMap<>();

    public Optional<Order> findById(String orderId) {
        log.info("Order find by id " + orderId);
        return Optional.ofNullable(storage.get(orderId));

    }
    public void save(Order order) {
        log.info("Saving order " + order.getId());
        storage.put(order.getId(), order);
    }
    public void returnOrder(Order order) {
        if (order.getStatus() == OrderStatus.DELIVERED) {
            order.setStatus(OrderStatus.RETURNED);
        }
    }
}
