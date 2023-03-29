package model;

public class Customer {
    private int id;
    private String cust_name;
    private String cust_surname;
    private String phone;

    public Customer(String cust_name, String cust_surname, String phone) {
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.phone = phone;
    }

    public Customer(int id, String cust_name, String cust_surname, String phone) {
        this.id = id;
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "--------------\n"+
                "Customer name=" + cust_name + "\n" +
                "Customer surname=" + cust_surname + "\n" +
                "Phone=" + phone +
                "--------------";
    }
}
