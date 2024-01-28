package Assignment2;
//Nathan Lamoureux
import java.util.Scanner;

public class Assignment2_1 {
    public static void main(String[] args) {
        double temp; //Creates the temperature variable
        Scanner keyboard = new Scanner(System.in); //Creates the scanner
        System.out.println("Please enter a temperature in degrees Celsius:"); //Prompts the user to enter a temperature
        temp = keyboard.nextDouble(); //Reads user input

        temp = (9 / 5) * temp + 32; //Calculates the temp in Fahrenheit

        System.out.println("The temperature in Fahrenheit is " + temp); //Prints calculated temperature

    }
}
