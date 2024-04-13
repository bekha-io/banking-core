package org.example.domain.entities;

import java.util.Date;

import org.example.domain.types.Installment;
import org.example.domain.types.Money;

public class Loan {
    private LoanProduct loanProduct;
    private int duration;
    private Money amount;
    private float interest;
    private Installment[] installments;
    private Date issuedAt;

    public Loan(LoanProduct lp, int duration, Money amount, Date issuedAt) {
        this.loanProduct = lp;
        this.amount = amount;
        this.duration = duration;
        this.issuedAt = issuedAt;
    }

    public Date isssuedAt() {
        return this.issuedAt;
    }

    public Installment[] getInstallments() {
        return this.installments;
    }

    public Installment[] calculateInstallments() {
        return this.loanProduct.calculateInstallments(this);
    }

    public float getInterest() {
        return this.loanProduct.getMinInterest();
    }

    public Money getAmount() {
        return this.amount;
    }

    public int getDuration() {
        return this.duration;
    }
}