package ua.university.payment;

public class BankTransferPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Cannot pay less than 0");
        }
        double fee = amount * 1.02;
    }
}
