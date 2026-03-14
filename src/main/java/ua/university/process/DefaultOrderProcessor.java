package ua.university.process;

import ua.university.domain.Order;
import ua.university.exception.AppException;
import ua.university.payment.PaymentMethod;

public class DefaultOrderProcessor extends OrderProcessorTemplate{
    private final PaymentMethod paymentMethod;
    public DefaultOrderProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    @Override
    protected void validate(Order order) {
        if(order == null){
            throw new AppException("Order is null");
        }
    }
    @Override
    protected void calculate(Order order) {
        order.getTotal().applyDiscount();
    }
    @Override
    protected void pay(Order order) {
        paymentMethod.pay(order.getTotal().getAmount());
    }
}
