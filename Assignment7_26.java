package Assignment6;
//Nathan Lamoureux
import java.util.Scanner;
public class Assignment7_26 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user to enter two lists

        System.out.print("Enter list1: ");
        int[] list1 = new int[keyboard.nextInt()];
        for (int i = 0; i < list1.length; i++)
            list1[i] = keyboard.nextInt();

        System.out.print("Enter list2: ");
        int[] list2 = new int[keyboard.nextInt()];
        for (int i = 0; i < list2.length; i++)
            list2[i] = keyboard.nextInt();

        // Display whether the two are strictly identical

        System.out.println("Two lists are" + (equals(list1, list2) ? " " : " not ")
                + "strictly identical");
    }
    // equals returns true is the two arrays are indentical. False otherwise.

    public static boolean equals(int[] list1, int[] list2) {
        if (list1.length != list2.length)
            return false;

        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i])
                return false;
        }
        return true;
    }
}
