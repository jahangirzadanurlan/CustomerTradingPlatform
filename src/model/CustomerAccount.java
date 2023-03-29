package model;

public class CustomerAccount {
    private int id;
    private int cust_id;
    private String cust_name;
    private String cust_surname;
    private String account_number;
    private double balance;

    public CustomerAccount(int id,int cust_id, String cust_name, String cust_surname, String account_number, double balance) {
        this.id = id;
        this.cust_id=cust_id;
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.account_number = account_number;
        this.balance = balance;
    }

    public CustomerAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_surname() {
        return cust_surname;
    }

    public void setCust_surname(String cust_surname) {
        this.cust_surname = cust_surname;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "--------------\n"+
                "Id=" + id +"\n"+
                "Customer name=" + cust_name + "\n" +
                "Customer surname=" + cust_surname + "\n" +
                "Card number=" + account_number + "\n" +
                "Balance=" + balance+"\n"+
                "--------------";
    }
}
