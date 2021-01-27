package takeout;

import java.util.Scanner;
import javax.print.attribute.standard.MediaSizeName;
import javax.xml.bind.SchemaOutputResolver;


public class Takeout {

    public static void main(String[] args) {
        // Get input from user
        Scanner sc = new Scanner(System.in);
        boolean isWrongMenuChoice = false;

        System.out.println("How many people do you have? ");
        int numberOfPeople = sc.nextInt();
        if (numberOfPeople < 10 || numberOfPeople > 100) {
            System.out.println("Number of people are invalid");
            System.exit(0);
        }

        do {

            //Start Ordering Food
            System.out.println("TAKEOUT MENU");
            Takeout.displayMainMenu();


            System.out.println("Choose what type of food you'd like to order: ");
            String mealType = sc.next();

            switch (mealType) {
                case "1":
                    Takeout.displayItalianFoodMenu();
                    int[] feedItalianFood = {5,7,4};
                    double[] priceItalian = {17.99,15.99,12.99};
                    int opt = Takeout.foodChoice(feedItalianFood,priceItalian);
                    Takeout.finalPrice(feedItalianFood,priceItalian, opt, numberOfPeople);
                    isWrongMenuChoice = false;
                    break;

                case "2":
                    Takeout.displayChineseFoodMenu();
                    int[] feedChineseFood = {7,7,5};
                    double[] priceChinese = {18.99, 18.99, 10.99};
                    opt = Takeout.foodChoice(feedChineseFood, priceChinese);
                    Takeout.finalPrice(feedChineseFood, priceChinese, opt, numberOfPeople);
                    isWrongMenuChoice = false;
                    break;

                case "3":
                    Takeout.displayAmericanFoodMenu();
                    int[] feedAmericanFood = {8,5,10};
                    double[] priceAmerican = {21.99, 22.99 , 26.99};
                    opt = Takeout.foodChoice(feedAmericanFood,priceAmerican);
                    Takeout.finalPrice(feedAmericanFood, priceAmerican, opt, numberOfPeople);
                    isWrongMenuChoice = false;
                    break;

                default:
                    System.out.println("Wrong meal type. Please choose correct meal type");
                    isWrongMenuChoice = true;
            }
        }while(isWrongMenuChoice);
    }

    public static void displayMainMenu() {
        String[] foodMenu = {"Italian", "Chinese", " American"};
        System.out.println("-------------------------");
        for (int i = 0; i < foodMenu.length; i++) {
            System.out.println((i + 1) + ". " + foodMenu[i]);


        }
    }

    public static void displayItalianFoodMenu() {
        String[] italianFood = {"Lasagna Tray", "Pizza Pack", "Gazpacho Soup, salad and bread sticks pack"};
        System.out.println("------------------");
        for (int i = 0; i < italianFood.length; i++) {
            System.out.println((i + 1) + ". " + italianFood[i]);
        }
    }

    public static void displayChineseFoodMenu() {
        String[] chineseFood = {"Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls)", "Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls)", "Shrimp Fried Rice Tray (includes 10 egg rolls)"};
        System.out.println("------------------");
        for (int i = 0; i < chineseFood.length; i++) {
            System.out.println((i + 1) + ". " + chineseFood[i]);
        }

    }

    public static void displayAmericanFoodMenu() {
        String[] americanFood = {"Hamburger and Hot Dog Tray - includes buns and condiments", "Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces", "Barbeque Tray - includes buns and peach cobbler"};
        System.out.println("------------------");
        for (int i = 0; i < americanFood.length; i++) {
            System.out.println((i + 1) + ". " + americanFood[i]);
        }
    }

    public static int determineTrays(int people, int feeds) {
        int trays = (int) (Math.round((people / feeds + 0.5)));
        return trays;
    }

    public static double getSubtotal(double price, int trays) {
        double subTotal = (trays * price);
        return subTotal;
    }

    public static double getTax(double subTotal, double taxRate) {
        double tax = subTotal * taxRate;
        return tax;
    }

    public static double getTip(double subTotal, double tipRate) {
        double tip = subTotal * tipRate;
        return tip;
    }

    public static double getGrandTotal(double subTotal, double tax, double tip) {
        double total = subTotal + tax + tip;
        return total;
    }

    public static double pricePerPerson(double grandTotal, int people) {
        return grandTotal / people;
    }

    public static int determineLeftOvers(int feeds, int trays, int people) {
        return ((trays * feeds) - people);
    }

    //Display food trays menu
    public static int foodChoice(int[] feed, double[] prices) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSE ONE");
        System.out.println("-----------");
        for (int i = 0; i < feed.length; i++) {
            System.out.println((i + 1) + " - feeds " + feed[i] + " - " + prices[i]);
        }
        System.out.println("Enter choice: ");
        int opt = sc.nextInt();
        if (opt <= 0 || opt > feed.length) {
            System.exit(0);
        }
        return opt;
    }

    public static void finalPrice(int[] feeds, double[] prices, int choice, int guestCount) {
        int trays = Takeout.determineTrays(guestCount, feeds[choice - 1]);
        double subTotal = Takeout.getSubtotal(prices[choice - 1], trays);
        double tax = Takeout.getTax(subTotal, .07);
        double tip = Takeout.getTip(subTotal, .20);
        double grandTotal = Takeout.getGrandTotal(subTotal, tax, tip);
        System.out.println("You need " + trays + " trays");
        System.out.println("Feed: " + feeds[choice - 1]);
        System.out.printf("Price for " + guestCount + " people (" + trays + " trays):$ %.2f\n", subTotal);
        System.out.printf("Tax: $ %.2f\n", tax);
        System.out.printf("Tip: $ %.2f\n", tip);
        System.out.printf("Total (Food, Tax, Tip): $ %.2f\n", grandTotal);
        System.out.printf("Price per person: $ %.2f\n",
                Takeout.pricePerPerson(grandTotal,
                        guestCount));
        System.out.println("Left over servings for the delivery person: " +
                Takeout.determineLeftOvers(feeds[choice - 1], trays, guestCount));


    }


    }





























































































