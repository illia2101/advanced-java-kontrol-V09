package ua.university.payment;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount){
        if(amount <= 0 || amount > 30000){
            throw new IllegalArgumentException("Card Payment amount must be between 0 and 30000");
        }
    }
}
