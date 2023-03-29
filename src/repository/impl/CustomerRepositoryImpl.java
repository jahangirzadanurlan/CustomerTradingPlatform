package repository.impl;

import model.Account;
import model.Customer;
import model.CustomerAccount;
import model.Transaction;
import queries.customerQuery;
import repository.CustomerRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static repository.DBConnection.connect;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public boolean createCustomer(Customer customer) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.CREATE_CUSTOMER);
            preparedStatement.setString(1,customer.getCust_name());
            preparedStatement.setString(2,customer.getCust_surname());
            preparedStatement.setString(3,customer.getPhone());

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createAccount(Account account) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.CREATE_ACCOUNT);
            preparedStatement.setInt(1,account.getCustId());
            preparedStatement.setString(2,account.getAccountNumber());
            preparedStatement.setInt(3,account.getBalance());

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.ADD_TRANSACTION);
            preparedStatement.setString(1,transaction.getAccount_id());
            preparedStatement.setDate(2, Date.valueOf(transaction.getDate()));
            preparedStatement.setString(3,transaction.getType());
            preparedStatement.setDouble(4,transaction.getAmount());

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deposit(double money,String accountNumber) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.DEPOSIT);
            preparedStatement.setDouble(1,money);
            preparedStatement.setString(2,accountNumber);

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean takeMoney(double money, String accountNumber) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.TAKE_MONEY);
            preparedStatement.setDouble(1,money);
            preparedStatement.setString(2,accountNumber);

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean moneyTransfer(double money, String accountNumber1, String accountNumber2) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.MONEY_TRANSFER);
            preparedStatement.setDouble(1,money);
            preparedStatement.setString(2,accountNumber1);
            preparedStatement.setDouble(3,money);
            preparedStatement.setString(4,accountNumber2);

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String accountNumber) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.DELETE_ACCOUNT);
            preparedStatement.setString(1,accountNumber);

            int val=preparedStatement.executeUpdate();

            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Transaction> transactionHistories(String accountNumber) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.TRANSACTION_HISTORIES);
            preparedStatement.setString(1,accountNumber);

            List<Transaction> accounts=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String  id=resultSet.getString("account_number");
                Date date=resultSet.getDate("date");
                String type=resultSet.getString("type");
                double amount=resultSet.getDouble("amount");

                accounts.add(new Transaction(id,date.toLocalDate(),type,amount));
            }
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerAccount> showAccounts() {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.SHOW_ACCOUNTS);

            List<CustomerAccount> customers=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int cust_id=resultSet.getInt("cust_id");
                String cust_name=resultSet.getString("cust_name");
                String cust_surname=resultSet.getString("cust_surname");
                String account_number=resultSet.getString("account_number");
                double balance=resultSet.getDouble("balance");
                customers.add(new CustomerAccount(id,cust_id,cust_name,cust_surname,account_number,balance));
            }

            return customers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> showCustomers() {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(customerQuery.SHOW_CUSTOMERS);

            List<Customer> customers=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String cust_name=resultSet.getString("cust_name");
                String cust_surname=resultSet.getString("cust_surname");
                String cust_phone=resultSet.getString("phone");
                customers.add(new Customer(id,cust_name,cust_surname,cust_phone));
            }

            return customers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
