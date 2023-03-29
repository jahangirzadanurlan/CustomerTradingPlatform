package repository;

import model.Account;
import model.Customer;
import model.CustomerAccount;
import model.Transaction;

import java.util.List;
import java.util.Objects;

public interface CustomerRepository {
    boolean createCustomer(Customer customer);
    boolean createAccount(Account account);
    boolean addTransaction(Transaction transaction);
    boolean deposit(double money,String accountNumber);
    boolean takeMoney(double money,String accountNumber);
    boolean moneyTransfer(double money,String accountNumber1,String accountNumber2);
    boolean deleteAccount(String accountNumber);
    List<Transaction> transactionHistories(String accountNumber);
    List<CustomerAccount> showAccounts();
    List<Customer> showCustomers();


}
