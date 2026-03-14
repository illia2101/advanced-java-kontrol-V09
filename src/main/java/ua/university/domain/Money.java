package ua.university.domain;

import java.util.Objects;

public class Money {

    private final double amount;

    public Money(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public Money applyDiscount() {
        if (amount >= 20000) {
            return new Money(amount * 0.9);
        }
        return this;
    }
    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(amount);

    }
}
