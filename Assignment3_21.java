package Assignment3;
//Nathan Lamoureux
import java.util.Scanner;
public class Assignment3_21 {
     public static void main(String[] args) {
         System.out.println("This program determines the day of the week!");
         //Implementing the necessary variables/scanner
         Scanner keyboard = new Scanner(System.in);
         int year;
         int month;
         int day;
         int weekday;
         //prompting the user for the date
         System.out.println("Please enter the year:");
         year = keyboard.nextInt();

         System.out.println("Please enter the month (1-12):");
         month = keyboard.nextInt();

         System.out.println("Please enter the day (1-31):");
         day = keyboard.nextInt();
         //Converting January and Febuary to their correct numbers if necessary
         if (month == 1){
             month = 13;
             year = year - 1;
         } else if (month == 2) {
             month = 14;
             year = year - 1;
         }
         //Calculating the day
         weekday = (day + ((26 * (month + 1))/10) + (year%100) + ((year%100)/4) + ((year/100)/4) + 5 * (year/100) )%7;
         //Printing the output
         switch (weekday) {
             case 0: System.out.println("The day of the week is Saturday."); break;
             case 1: System.out.println("The day of the week is Sunday."); break;
             case 2: System.out.println("The day of the week is Monday."); break;
             case 3: System.out.println("The day of the week is Tuesday."); break;
             case 4: System.out.println("The day of the week is Wednesday."); break;
             case 5: System.out.println("The day of the week is Thursday"); break;
             case 6: System.out.println("The day of the week is Friday."); break;

         }
    }
}
