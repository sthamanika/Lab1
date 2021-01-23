package lab;
import java.util.Scanner;
public class BankTest {


    public static void main(String[] args) {
        BankAccount = null;
        int options;


        do {
            System.out.println("");
            System.out.println("");
            System.out.println("Options to create account");
            System.out.println("\t 1: Create an Account");
            System.out.println("\t 2: Create an Account with balance");
            System.out.println("\t 3: Exit");
            System.out.println();


            Scanner input = new Scanner(System.in);
            System.out.println("Enter your option");
            options = input.nextInt();

            String name;
            double balance;
            switch (options) {
                case 1:
                    System.out.println("Enter account holder's name: ");
                    name = input.next();
                    account = new BankAccount(name);
                    account.displayInfo();
                    account.showMenu();
                    break;
                case 2:
                    System.out.println("Enter account holder's name: ");
                    name = input.next();
                    System.out.println("Enter starting balance: ");
                    balance = input.nextDouble();
                    account = new BankAccount(name, balance);
                    account.displayInfo();
                    account.showMenu();
                    break;
                case 3:
                    System.out.println("BYe bye");
                    break;
                default:
                    System.out.println("n/a");
            }
        }while (options != 3);

                
                
            }
        }
    }

}
