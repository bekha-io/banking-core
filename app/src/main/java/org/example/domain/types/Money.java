package org.example.domain.types;

import java.util.Currency;

public class Money {
    private int amount;
    private Currency currency;

    // Default constructor
    public Money(int amount) {
        this.amount = amount;
        this.currency = Currency.getInstance("USD"); // USD by default
    }

    public void add(Money source) {
        amount += source.amount;
    }

    public void sub(Money source) {
        amount -= source.amount;
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", (float) amount / 100, currency);
    }
}
