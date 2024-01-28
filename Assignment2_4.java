package Assignment2;
//Nathan Lamoureux
import java.util.Scanner;

public class Assignment2_4 {
    public static void main(String[] args){
        System.out.println("This program converts pounds into kilograms.");
        //creating the scanner and variables
        Scanner keyboard = new Scanner(System.in);
        float pounds;
        float kilograms;
        //scanning the number of pounds
        System.out.println("Please enter a number of pounds:");

        pounds = keyboard.nextFloat();
        //calculating kilograms
        kilograms = (float) (pounds * 0.454);
        //printing result
        System.out.println(pounds + " pounds is " + kilograms + " kilograms.");
    }
}
