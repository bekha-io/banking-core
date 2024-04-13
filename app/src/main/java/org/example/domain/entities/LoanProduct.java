package org.example.domain.entities;

import java.util.Calendar;
import java.util.Date;

import org.example.domain.types.Installment;
import org.example.domain.types.Money;

// LoanProduct represents a loan product with configurable and customizable loan terms and conditions
public class LoanProduct {
    public final String name;
    private int minAmount;
    private int maxAmount;
    private int maxDuration;
    private int minDuration;
    private float minInterest;
    private float maxInterest;

    private int daysBetweenInstallments;

    public LoanProduct(String name, int minAmount, int maxAmount, int minDuration, int maxDuration,
            float minInterest, float maxInterest, int daysBetweenInstallments) {
        this.name = name;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minInterest = minInterest;
        this.maxInterest = maxInterest;
        this.daysBetweenInstallments = daysBetweenInstallments;
    }

    public float getDaysBetweenInstallments() {
        return this.daysBetweenInstallments;
    }

    public float getMaxInterest() {
        return this.maxInterest;
    }

    public float getMinInterest() {
        return this.minInterest;
    }

    public int getMaxDuration() {
        return this.maxDuration;
    }

    public int getMinDuration() {
        return this.minDuration;
    }

    public int getMaxAmount() {
        return this.maxAmount;
    }

    public int getMinAmount() {
        return this.minAmount;
    }

    public Installment[] calculateInstallments(Loan l) {
        int duration = l.getDuration();
        int durationInMonths = duration / 30;

        float interest = l.getInterest();
        float monthlyInterest = interest / 12;

        Money amount = l.getAmount();

        float monthlyPayment = (float) (amount.getAmount() * monthlyInterest
                / (1 - Math.pow(1 + monthlyInterest, -durationInMonths)));

        int remainingAmount = amount.getAmount();
        Date previousInstallmentDate = l.isssuedAt();
        Installment[] installments = new Installment[durationInMonths];
        for (int i = 0; i < durationInMonths; i++) {
            float currInterest = remainingAmount * monthlyInterest;
            float principal = monthlyPayment - currInterest;
            remainingAmount -= principal;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(previousInstallmentDate);
            calendar.add(Calendar.DAY_OF_WEEK, this.daysBetweenInstallments);
            previousInstallmentDate = calendar.getTime();

            Money currentPayment = new Money((int) monthlyPayment);
            Money remainPayment = new Money((int) remainingAmount);
            installments[i] = new Installment(previousInstallmentDate, currentPayment, remainPayment, false, null);
        }

        return installments;
    }
}
