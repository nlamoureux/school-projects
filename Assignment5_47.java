package Assignment5;
//Nathan Lamoureux
import java.util.Scanner;

public class Assignment5_47 {
    public static void main(String[] args) {


        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the first 12 digits of an ISBN as string: ");

        String s = keyboard.next();
        //Checking for a valid input
        if (s.length() != 12) {
            System.out.println(s + " is Invalid input");
            System.exit(0);
        }
        //Calculating ISBN
        int checkSum = 0;
        for (int i = 0; i < s.length(); i++) {

            if ((i + 1) % 2 == 0) {
                checkSum +=  (s.charAt(i) - '0') * 3;

            } else {
                checkSum  += s.charAt(i) - '0';
            }
        }
        checkSum %= 10;
        checkSum = 10 - checkSum;
        if (checkSum == 10) s += "0";
        else  s += checkSum;
        //Displaying result
        System.out.println("The ISBN-13 number is " + s);
    }
}
