package lab;

import java.util.Scanner;

public class BankTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("Please enter your account name: ");
        String name = input.nextLine();

        System.out.printf("Enter your balance: ");
        double balance = input.nextDouble();

        BankAccount ba = new BankAccount(name, balance);


        System.out.printf("Select an option: \n");
        System.out.printf("Enter 1 for deposit, 2 for withdrawal: ");
        int num = input.nextInt();

        if(num == 1)
        {
            System.out.printf("\nEnter the amount you want to deposit: ");
            double dep = input.nextDouble();
            System.out.printf("Enter the amount of interest rate: ");
            double interest = input.nextDouble();
            System.out.printf("");
            System.out.println(ba.toString());
            ba.depositFund(dep, interest);
            System.out.printf("\n");


        }
        if(num == 2)
        {
            System.out.printf("Enter the amount you want to withdraw: ");
            double wit = input.nextDouble();
            System.out.printf("Enter the deduction fee: ");
            double fee = input.nextDouble();
            System.out.printf("");
            System.out.println(ba.toString());
            ba.withdrawFund(wit, fee);
            System.out.printf("\n");
        }
    }

}
