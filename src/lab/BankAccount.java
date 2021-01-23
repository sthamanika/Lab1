package lab;

import java.util.Scanner;

public class BankAccount {
        public String name;
        public double balance;
        public static int accNum = 100;


        public BankAccount(String name)
        {
                this.name = name;
                balance = 0;
                accNum++;

        }

        public BankAccount(String name, double balance)
        {
                this.name = name;
                this.balance = balance;
                accNum++;

        }



        public void deposit(double amount){
                balance = balance + amount;

        }

        public void deposit(double amount, double interestRate)
        {
                balance = balance + amount + (balance + interestRate / 100);
        }

        public void withdrawal(double amount)
        {
                balance = balance - amount;

        }

        public void withdrawal (double amount, double fee)
        {
                balance = balance - amount- fee;
        }

        public void showMenu() {
                double amount, rate;
                double fee = 0;
                
                int option;


                do {
                        System.out.println("Please select an option!");
                        System.out.println("\t 1. Deposit ");
                        System.out.println("\t 2. Deposit amount with interest rate");
                        System.out.println("\t 3. Withdraw");
                        System.out.println("\t 4. Withdraw amount with withdrawal fee");
                        System.out.println("\t 5. Exit");
                        System.out.println();

                        System.out.println("Enter your option");
                        Scanner input = new Scanner(System.in);
                        option = input.nextInt();


                        switch (option) {
                                case 1:
                                        System.out.println("$$$$$$$$$$$$");
                                        System.out.println("Enter the amount you want to deposit");
                                        amount = input.nextDouble();
                                        deposit(amount);
                                        break;
                                case 2:
                                        System.out.println("$$$$$$$$$$$$");
                                        System.out.println("Enter the amount you want to deposit");
                                        amount = input.nextDouble();
                                        System.out.println("Enter the interest rate");
                                        rate = input.nextDouble();
                                        deposit(amount, rate);
                                        break;
                                case 3:
                                        System.out.println("$$$$$$$$$$$$");
                                        System.out.println("Enter the amount you want to withdraw");
                                        amount = input.nextDouble();
                                        withdrawal(amount);
                                        break;
                                case 4:
                                        System.out.println("$$$$$$$$$$$$");
                                        System.out.println("Enter the amount you want to withdraw");
                                        amount = input.nextDouble();
                                        System.out.println("Enter the withdrawal fee");
                                        rate = input.nextDouble();
                                        withdrawal(amount, fee);
                                        break;
                                case 5:
                                        System.out.println("THANK YOU!!");
                                        break;
                                default:
                                        System.out.println("n/a");
                        }
                }while (option!= 5);

                        }

                        public void displayInfo()
                        {
                                System.out.println("Account name: " + name);
                                System.out.println("Account Number: " + accNum);


                        }
                        public void displayBalance()
                        {
                                System.out.printf("Account Balance: %.3f\n", balance);
                        }
}



