package Assignment2;
//Nathan Lamoureux
import java.util.Scanner;

public class Assignment2_5 {
    public static void main(String[] args){
        System.out.println("This program calculates and displays tips at certain rates.");
        //creating the necessary variables
        float subtotal;
        float rate;
        float gratuity;
        float total;
        //scanning numbers into the variables
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the subtotal:");

        subtotal = keyboard.nextFloat();

        System.out.println("Please enter the gratuity rate:");

        rate = keyboard.nextFloat();
        //calculating the gratuity and total
        gratuity = subtotal * (rate/100);

        total = subtotal + gratuity;
        //printing the gratuity and total
        System.out.println("The gratuity is " + gratuity + " and the total is " + total);
    }
}
