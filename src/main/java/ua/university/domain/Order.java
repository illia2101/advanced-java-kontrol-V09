package ua.university.domain;

import ua.university.OrderStatus;

public class Order {
    private final String id;
    private final OrderItem[] items;
    private OrderStatus status;
    private final Money total;

    public Order(String id, OrderItem[] items, Money total) {
        this.id = id;
        this.items = items.clone();
        this.status = OrderStatus.CREATED;
        this.total = total;
    }
    public String getId() {
        return id;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public Money getTotal() {
        return total;
    }
    public OrderStatus setStatus(OrderStatus status) {
        this.status = status;
        return status;
    }
    public OrderItem[] getItems() {
        return items.clone();
    }

}
