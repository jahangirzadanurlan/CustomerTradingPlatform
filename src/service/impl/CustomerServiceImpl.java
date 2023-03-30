package service.impl;

import designPattern.CustomerBuilder;
import model.Account;
import model.Customer;
import model.CustomerAccount;
import model.Transaction;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;
import util.InputUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        customerRepository =new CustomerRepositoryImpl();
    }


    @Override
    public void createCustomer() {
        customerRepository.createCustomer(fillCustomer());
        System.out.println("---------|Creating is successfully|---------");
    }

    private Customer fillCustomer() {
        String name= InputUtil.requiredInputString("Enter the name: ");
        String surname=InputUtil.requiredInputString("Enter the surname: ");
        String phone =InputUtil.requiredInputString("Enter the phone: ");

        return new CustomerBuilder()
                .withCust_name(name)
                .withCust_surname(surname)
                .withPhone(phone)
                .build();
    }

    @Override
    public void createAccount(){
        int custId= InputUtil.requiredInputInt("Enter the customer id: ");
        if (checkId(custId)){
            customerRepository.createAccount(fillAccount(custId));
            System.out.println("---------|Creating is successfully|---------");
            CustomerAccount customer=showAccounts().stream().filter(i->i.getCust_id()==custId).findFirst().orElse(null);
            System.out.println("This is "+customer.getCust_name()+" card number: "+customer.getAccount_number());
        }else {
            System.out.println("This id does not have an account");
        }
    }
    //Id olmasini yoxlayir
    public boolean checkId(int custId){
        Customer customer=showCustomers().stream()
                .filter(i->i.getId()==custId)
                .findFirst()
                .orElse(null);
        if (customer!=null){
            return true;
        }else{
            return false;
        }
    }
    private Account fillAccount(int custId){
        Random random=new Random();
        long cardNumber = 100000000L + (long)(random.nextDouble() * 900000000L);
        String accountNumber=String.valueOf(cardNumber);
        int balance =0;

        return new Account(custId,accountNumber,balance);
    }

    //Her pul emeliyatindan sonra bu metod cagrilacaq
    @Override
    public void addTransaction(String accountId,String type,double amount) {
        customerRepository.addTransaction(fillTransaction(accountId,type,amount));

    }

    private Transaction fillTransaction(String accountId,String type,double amount) {
        LocalDate date1=LocalDate.now();
        Date date=Date.valueOf(date1);

        return new Transaction(accountId,date.toLocalDate(),type,amount);
    }
    //Accountun olmasini yoxlayiram
    public boolean checkAccount(String accountNumber){
        CustomerAccount customerAccount=showAccounts().stream()
                .filter(i->i.getAccount_number().equals(accountNumber))
                .findFirst()
                .orElse(null);
        if (customerAccount!=null){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void deposit() {
        String accountNumber=InputUtil.requiredInputString("Enter the card number: ");
        if (checkAccount(accountNumber)){
            int money=InputUtil.requiredInputInt("Depozit amount: ");
            if (money > 0) {
                customerRepository.deposit(money,accountNumber);
                addTransaction(accountNumber,"Depozit",money);
                System.out.println("---------|Deposit is successfully|---------");
            }else {
                System.out.println("Money cannot be negative");
            }
        }else {
            System.out.println("There is no such account");
        }
    }

    @Override
    public void takeMoney() {
        String accountNumber=InputUtil.requiredInputString("Enter the card number: ");
        if (checkAccount(accountNumber)){
            int money=InputUtil.requiredInputInt("Spend amount: ");
            if (money>0){
                //money'in balansdan boyuk olmamasini yoxlayiram
                CustomerAccount customerAccount = showAccounts().stream()
                        .filter(i -> i.getAccount_number().equals(accountNumber) && i.getBalance() > money)
                        .findFirst()
                        .orElse(null);
                if (customerAccount!=null){
                    customerRepository.takeMoney(money,accountNumber);
                    addTransaction(accountNumber,"Spend",money);
                    System.out.println("---------|Spend is successfully|---------");
                }else {
                    System.out.println("---------|There is no such amount in the account|---------");
                }
            }else {
                System.out.println("Money cannot be negative");
            }
        }else {
            System.out.println("There is no such account");
        }
    }

    @Override
    public void moneyTransfer() {
        String accountNumber1=InputUtil.requiredInputString("Enter your card number: ");
        if (checkAccount(accountNumber1)){
            String accountNumber2=InputUtil.requiredInputString("Enter the card number to be transferred: ");
            if (checkAccount(accountNumber2)){
                int money=InputUtil.requiredInputInt("Transfer amount: ");
                if (money>0){
                    //money'in balansdan boyuk olmamasini yoxlayiram
                    CustomerAccount customerAccount = showAccounts().stream()
                            .filter(i -> i.getAccount_number().equals(accountNumber1) && i.getBalance() > money)
                            .findFirst()
                            .orElse(null);
                    if (customerAccount!=null){
                        customerRepository.moneyTransfer(money,accountNumber1,accountNumber2);
                        addTransaction(accountNumber1,"Transfer",money);
                        System.out.println("---------|Transfer is successfully|---------");
                    }else {
                        System.out.println("---------|There is no such amount in the account|---------");
                    }
                }else {
                    System.out.println("Money cannot be negative");
                }
            }else {
                System.out.println("There is no such account");
            }
        }else {
            System.out.println("There is no such account");
        }
    }

    @Override
    public void deleteAccount() {
        String accountNumber=InputUtil.requiredInputString("Enter the card number: ");
        if (checkAccount(accountNumber)){
            String check=InputUtil.requiredInputString("Are you sure to delete the card?(y/n)").toLowerCase();
            if (check.equalsIgnoreCase("y")){
                customerRepository.deleteAccount(accountNumber);
                System.out.println("Deleting is successfully");
            }else if (check.equalsIgnoreCase("n")){
                System.out.println("Your card has not been deleted :)");
            }else {
                System.out.println("Wrong option! ");
            }
        }else {
            System.out.println("There is no such account");
        }
    }

    @Override
    public List<Transaction> transactionHistories() {
        String accountNumber=InputUtil.requiredInputString("Enter the number of the card for which you want to see the transaction date: ");
        return customerRepository.transactionHistories(accountNumber);
    }

    @Override
    public List<CustomerAccount> showAccounts() {
        return customerRepository.showAccounts();
    }
    @Override
    public List<Customer> showCustomers() {
        return customerRepository.showCustomers();
    }
}
