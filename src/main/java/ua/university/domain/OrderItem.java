package ua.university.domain;

public class OrderItem {
    private final String product;
    private final int quantity;
    public OrderItem(String product, int quantity) {
        if(quantity < 1 || quantity > 5) {
            throw new IllegalArgumentException("Quantity must be between 1 and 5");
        }
        this.product = product;
        this.quantity = quantity;
    }
    public String getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
}
