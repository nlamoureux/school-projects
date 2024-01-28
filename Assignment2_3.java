package Assignment2;
//Nathan Lamoureux
import java.util.Scanner;
public class Assignment2_3 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        //Creating necessary variables
        float feet;
        float meters;
        //Writing numbers to the variables
        System.out.println("This program converts feet to meters.");

        System.out.println("Please enter a number in feet:");

        feet = keyboard.nextFloat();
        //Computing results
        meters = (float) (feet * 0.305);
        //Printing results
        System.out.println(feet + " feet is " + meters + " meters.");
    }
}
