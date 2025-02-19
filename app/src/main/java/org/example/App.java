/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.example.domain.entities.Loan;
import org.example.domain.entities.LoanProduct;
import org.example.domain.types.Installment;
import org.example.domain.types.Money;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        LoanProduct lp = new LoanProduct("Дастгирии оила", 1000, 1000000, 30, 365, 1, 10, 30);
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        Money loanAmount = new Money(1000);
        Loan l = new Loan(lp, 180, loanAmount, calendar.getTime());
        Installment[] installments = l.calculateInstallments();

        for (Installment instl : installments) {
            System.out.println(instl);
        }
    }
}
