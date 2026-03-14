import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import ua.university.OrderStatus;
import ua.university.domain.Money;
import ua.university.domain.Order;
import ua.university.domain.OrderItem;
import ua.university.payment.CardPayment;
import ua.university.payment.PayPalPaymant;
import ua.university.service.OrderService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderTests {

    @Test
    void createCorrectOrder() {
        OrderItem item = new OrderItem("Snickers", 2);
        assertEquals("Snickers",item.getProduct());
        assertEquals(2,item.getQuantity());
    }
    @Test
    void quantityIsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {new OrderItem("Snickers", 0);});
    }
    @Test
    void quantityIsGreaterThanFive() {
        assertThrows(IllegalArgumentException.class, () -> {new OrderItem("Snickers", 6);});
    }
    @Test
    void discountShouldApply() {
        Money money = new Money(20000);
        Money discounted = money.applyDiscount();
        assertEquals(18000, discounted.getAmount());
    }
    @Test
    void cardPaymentLimitExceeded() {

        CardPayment payment = new CardPayment();

        assertThrows(IllegalArgumentException.class, () -> {payment.pay(40000);});
    }
    @Test
    void paypalBelowMinimumShouldThrow() {

        PayPalPaymant payment = new PayPalPaymant();

        assertThrows(IllegalArgumentException.class, () -> {payment.pay(200);});
    }
    @Test
    void findNonExistingOrder() {

        OrderService service = new OrderService();

        Optional<Order> result = service.findById("999");

        assertTrue(result.isEmpty());
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void validQuantities(int q) {

        assertDoesNotThrow(() -> {
            new OrderItem("Item", q);
        });
    }
    @Test
    void deliveredCanBecomeReturned() {

        OrderItem item = new OrderItem("Book",1);
        Order order = new Order("1", new OrderItem[]{item}, new Money(100));

        order.setStatus(OrderStatus.DELIVERED);

        OrderService service = new OrderService();

        service.returnOrder(order);

        assertEquals(OrderStatus.RETURNED, order.getStatus());
    }






}
