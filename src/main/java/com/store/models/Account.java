package com.store.models;

public class Account {

    private String accountName;
    private double accountBalance;

    public Account(String accountName) {
        this.accountName = accountName;
        this.accountBalance = 0;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
