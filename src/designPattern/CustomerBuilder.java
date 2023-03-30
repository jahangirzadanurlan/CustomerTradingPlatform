package designPattern;

import model.Customer;

public class CustomerBuilder {
    private int id;
    private String cust_name;
    private String cust_surname;
    private String phone;

    public CustomerBuilder withId(int id){
        this.id=id;
        return this;
    }
    public CustomerBuilder withCust_name(String cust_name){
        this.cust_name=cust_name;
        return this;
    }
    public CustomerBuilder withCust_surname(String cust_surname){
        this.cust_surname=cust_surname;
        return this;
    }
    public CustomerBuilder withPhone(String phone){
        this.phone=phone;
        return this;
    }
    public Customer build(){
        return new Customer(id,cust_name,cust_surname,phone);
    }

}
