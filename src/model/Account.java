package model;

public class Account {
    private int custId;
    private String accountNumber;
    private int balance;

    public Account(int custId, String accountNumber, int balance) {
        this.custId = custId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "--------------\n"+
                "Account" +
                "Customer Id=" + custId +
                "Account Number=" + accountNumber +
                "Balance=" + balance +
                "--------------";
    }
}
