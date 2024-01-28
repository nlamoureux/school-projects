package Assignment7;
//Nathan Lamoureux
import java.util.Scanner;

public class Question10_7 {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        //Creating a 10 space array/Account
        Account[] accounts = new Account[10];
        for(int i = 1; i< 11; i++) {
            accounts[i - 1] = new Account(i, 100.0);

        }
        //Logging into account
        System.out.print("Enter an id (1 - 10): ");
        int id = keyboard.nextInt();

        if (id < 1 || id > 10) {
            id = incorrectId(id);
        }
        //Displaying menu
        while (true) {
            menuDisplay();
            System.out.print("Enter a choice: ");
            int choice = keyboard.nextInt();
            if (choice == 4) {
                System.out.printf("%nEnter an id (1 - 10): ");
                id = keyboard.nextInt();

                if (id < 1 || id > 10) {
                    id = incorrectId(id);
                }
            }
            performChoice(id, choice, accounts);
        }
    }
        //creating function incorrectID
    public static int incorrectId(int id) {
        //Scanner in = new Scanner(System.in);
        while (id < 1 || id > 10) {
            System.out.print("Please enter a valid id: ");
            id = keyboard.nextInt();
            System.out.println();
        }
        return id;
    }
        //creating function performChoice
    public static void performChoice(int id, int choice, Account[] accounts) {
        //Scanner in = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.printf("The balance is $%.1f%n",
                        accounts[id - 1].getBalance());
                break;
            case 2:
                System.out.print("Enter the amount to withdraw: ");
                accounts[id - 1].withdraw(keyboard.nextDouble());
                break;
            case 3:
                System.out.print("Enter the amount to deposit: ");
                accounts[id - 1].deposit(keyboard.nextDouble());
                break;
            default:
                break;
        }
    }
        //creating function menuDisplay()
    public static void menuDisplay() {
        System.out.printf("%nMain menu%n");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
    }
}
        //creating the Account class
class Account {
    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 0.0;
    private java.util.Date dateCreated;

    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(int id, double balace) {
        this();
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getDateCreated() {
        return this.dateCreated.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12 ;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
