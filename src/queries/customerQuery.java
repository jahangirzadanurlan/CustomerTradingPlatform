package queries;

public class Query {
    public static final String CREATE_CUSTOMER="INSERT INTO customer(cust_name,cust_surname,phone) "+
            "VALUES(?,?,?)";
    public static final String CREATE_ACCOUNT="INSERT INTO account(cust_id,account_number,balance) "+
            "VALUES(?,?,?)";
    public static final String ADD_TRANSACTION="INSERT INTO transaction(account_id,date,type,amount) "+
            "VALUES(?,?,?,?)";

    public static final String DEPOSIT="UPDATE account SET balance=balance+? WHERE account_number=?";
    public static final String TAKE_MONEY="UPDATE account SET balance=balance-? WHERE account_number=?";
    public static final String MONEY_TRANSFER="UPDATE account SET balance=balance+? WHERE account_number=?; "+
            "UPDATE account SET balance=balance-? WHERE account_number=?";
    public static final String  TRANSACTION_HISTORIES="SELECT id,date,type,amount FROM transaction WHERE account_number=?";

    public static final String SHOW_ACCOUNTS="SELECT c.id,c.cust_name,c.cust_surname,a.account_number,a.balance " +
            "FROM customer c " +
            "JOIN account a on c.id = a.cust_id WHERE a.status=1";

    public static final String DELETE_ACCOUNT="UPDATE account SET status=0 WHERE account_number=?";
}
