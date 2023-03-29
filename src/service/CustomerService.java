package service;

import model.Account;
import model.Customer;
import model.CustomerAccount;
import model.Transaction;

import java.util.List;

public interface CustomerService {
    void createCustomer();
    void createAccount();
    void addTransaction(String accountId,String type,double amount);
    void deposit();
    void takeMoney();
    void moneyTransfer();
    void deleteAccount();
    List<Transaction> transactionHistories();
    List<CustomerAccount> showAccounts();
    List<Customer> showCustomers();
}
