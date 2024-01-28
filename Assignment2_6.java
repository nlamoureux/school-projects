package Assignment2;
//Nathan Lamoureux
import java.util.Scanner;

public class Assignment2_6 {
    public static void main(String[] args){
        System.out.println("this program adds the digits in a integer and displays the result.");
        //creating the necessary variables
        int integer;
        int int1;
        int int2;
        int int3;
        int total;
        //scanning integers into the variables
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a integer between 0 and 1000:");

        integer = keyboard.nextInt();
        //calculating the sum of the integers
        int1 = integer % 10;

        int2 = integer / 10;

        int2 = int2 % 10;

        int3 = integer / 100;

        int3 = int3 % 10;

        total = int1 + int2 + int3;
        //printing the result
        System.out.println("The sum of the digits is " + total);


    }
}
