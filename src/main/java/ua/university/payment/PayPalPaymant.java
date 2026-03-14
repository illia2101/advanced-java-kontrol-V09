package ua.university.payment;

public class PayPalPaymant implements PaymentMethod {
    @Override
    public void pay(double amount) {
        if(amount < 300){
            throw new IllegalArgumentException("PayPal amount must be greater than 300");
        }
    }
}
