package lab;

import java.util.Scanner;

public class BankAccount
{

        //instance variables
        private String Name;
        static int Num = 100;
        private double iniBalance;


        public String getAccName() {
                return Name;
        }
        public void setAccName(String accName) {
                Name = accName;
        }
        public double getIniBalance() {
                return iniBalance;
        }
        public void setIniBalance(double iniBalance) {
                this.iniBalance = iniBalance;
        }
        BankAccount(String name, double balance)
        {
                this.Name = name;
                this.iniBalance = balance;
                Num++;
        }
        BankAccount(String name)
        {
                this.Name = name;
        }
        public void withdrawFund(double amount)
        {
                amount = iniBalance - amount;
                System.out.printf("Your balance: $%.2f\n", amount);
        }
        public void withdrawFund(double amount, double fee)
        {
                if(amount > iniBalance)
                {
                        fee = (fee / 100) * amount ;
                        amount = iniBalance - amount - fee;
                        System.out.printf("Sorry You Don't Have Enough Balance!\nand Your Balance is $%.2f", amount);
                }
                else
                {
                        withdrawFund(amount);
                }
        }
        public void depositFund(double amount)
        {
                amount = iniBalance + amount ;
                System.out.printf("Your balance: $%.2f\n", amount);
        }
        public void depositFund(double amount, double interest)
        {
                if(amount >= iniBalance)
                {
                        interest = (interest / 100) * amount ;
                        amount = iniBalance + amount + interest;
                        System.out.printf("With Interest your Balance is $%.2f", amount);
                }
                else
                {
                        depositFund(amount);
                }
        }
        @Override
        public String toString()
        {
                return String.format("\nName: %s\nAccount Number: %d", getAccName(), Num);
        }

}