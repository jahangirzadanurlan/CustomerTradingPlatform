package model;

import java.time.LocalDate;

public class Transaction {
    private String account_id;
    private LocalDate date;
    private String type;
    private double amount;

    public Transaction(String account_id, LocalDate date, String type, double amount) {
        this.account_id = account_id;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "account_id=" + account_id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
