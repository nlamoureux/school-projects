package Assignment2;
// Nathan Lamoureux
import java.util.Scanner;

public class Assignment2_2 {
    public static void main(String[] args){
        System.out.println("This program calculates the volume of a cylinder.");
        //Creating the variables required
        double radius;
        double length;
        double volume;
        double area;
        final double pi = 3.14159;
        //Scanning numbers into the variables
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the radius:");

        radius = keyboard.nextDouble();

        System.out.println("Please enter the length:");

        length = keyboard.nextDouble();
        //Computing results
        area =  radius * radius * pi;

        volume = area * length;
        //Printing results
        System.out.println("The area of the cylinder is:" + area);
        System.out.println("The volume of the cylinder is:" + volume);



    }
}
