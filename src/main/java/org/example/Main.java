package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENTAGE = 100;

        int loanAmount = 0;
        float monthlyInterestRate = 0;
        int numOfPayments = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Loan amount requested: ");
            loanAmount = scanner.nextInt();
            if (loanAmount >= 1_000 && loanAmount <= 1_000_000)
                break;
            System.out.print("Enter amount between £1,000 and £1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
                break;
            }
            System.out.print("Enter a value greater then 0 and less than or equal to 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            int periodYears = scanner.nextInt();
            if (periodYears >= 1 && periodYears <= 30) {
                numOfPayments = periodYears * 12;
                break;
            }
            System.out.print("Enter a value between 0 and 30");
        }

        double monthlyMortgage = loanAmount *
                (monthlyInterestRate* Math.pow(1 + monthlyInterestRate, numOfPayments))
                /(Math.pow(1 + monthlyInterestRate, numOfPayments)-1);

        String monthlyMortgageInGBP = NumberFormat.getCurrencyInstance().format(monthlyMortgage);

        System.out.print("Your monthly mortgage is: " + monthlyMortgageInGBP);
    }
}