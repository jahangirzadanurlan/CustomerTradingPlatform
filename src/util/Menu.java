package util;

import service.impl.CustomerServiceImpl;

public class Menu {
    public static int homePage() {
        System.out.println("---------| Home Page |---------");
        System.out.println("""
                0.Exit
                1.Add customer
                2.Create account
                3.Login
                4.Show accounts""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static int loginPage() {
        System.out.println("---------| Login Page |---------");
        System.out.println("""
                1.Money transaction
                2.Transaction histories
                3.Delete account""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static int moneyTransaction() {
        System.out.println("---------| Money Transaction |---------");
        System.out.println("""
                1.Deposit
                2.Take money
                3.Money transfer""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static void start(){
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        while (true) {
            int choose = homePage();
            if (choose == 0) {
                System.out.println("Bye bye..");
                System.exit(-1);
            } else if (choose == 1) {
                customerService.createCustomer();
            } else if (choose==2) {
                customerService.createAccount();
            } else if (choose == 3) {
                int password=InputUtil.requiredInputInt("Eter admin password(1234): ");
                if (password==1234){
                    int a = loginPage();
                    if (a == 1) {
                        int b=moneyTransaction();
                        if(b==1){
                            System.out.println("---------------");
                            customerService.deposit();
                            System.out.println("---------------");
                        } else if (b==2) {
                            System.out.println("---------------");
                            customerService.takeMoney();
                            System.out.println("---------------");
                        } else if (b==3) {
                            System.out.println("---------------");
                            customerService.moneyTransfer();
                            System.out.println("---------------");
                        }else {
                            System.out.println("Wrong option!");
                        }
                        System.out.println("---------------");
                    } else if (a == 2) {
                        System.out.println("---------------");
                        System.out.println(customerService.transactionHistories());
                        System.out.println("---------------");
                    } else if (a==3) {
                        System.out.println("---------------");
                        customerService.deleteAccount();
                        System.out.println("---------------");
                    } else {
                        System.out.println("Wrong option!!!");
                    }
                }else {
                    System.out.println("Wrong password!!!");
                }
            }else if (choose==4){
                System.out.println(customerService.showAccounts());
            }
            else {
                System.out.println("Wrong oprion!!!");
            }
        }
    }
}
