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



