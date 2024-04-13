package org.example.domain.types;

import java.util.Date;

public class Installment {
    public Date dateFor;
    public Money amount;
    public Money remainAmount;
    public boolean isPaid;
    public Date paidAt;

    public Installment(Date dateFor, Money amount, Money remainAmount, boolean isPaid, Date paidAt) {
        this.dateFor = dateFor;
        this.amount = amount;
        this.remainAmount = remainAmount;
        this.isPaid = isPaid;
        this.paidAt = paidAt;
    }

    @Override
    public String toString() {
        return String.format("Installment{dateFor=%s amount=%s remainAmount=%s isPaid=%s paidAt=%s}", dateFor, amount, remainAmount, isPaid, paidAt);
    }
}