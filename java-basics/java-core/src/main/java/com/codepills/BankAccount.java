package com.codepills;

public class BankAccount {

    private final String name;
    private final double amount;
    private final boolean closed;

    public BankAccount() {
        this.name = "";
        this.amount = 0;
        this.closed = true;
    }

    public BankAccount(final String name, final double amount, final boolean closed) {
        this.name = name;
        this.amount = amount;
        this.closed = closed;
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean isClosed() {
        return this.closed;
    }

}
