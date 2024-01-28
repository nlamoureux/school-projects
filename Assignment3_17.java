package Assignment3;
//Nathan Lamoureux
import java.util.Scanner;

public class Assignment3_17 {
    public static void main(String[] args) {
        System.out.println("Let's play Rock-Paper-Scissors!");

        Scanner keyboard = new Scanner(System.in);
        //Getting input from the player
        System.out.println("Your move. Rock(0), Paper(1), Scissors(2).");

        double player = keyboard.nextDouble();
        //Generating a random number for the computer
        int rand = (int) (Math.random() * 3);
        //Determining what the opponent's move is
        if (rand == 0) {

            System.out.println("Opponent move: Rock");

        } else if (rand == 1) {

            System.out.println("Opponent move: Paper");
        } else if (rand ==2) {

            System.out.println("Opponent move: Scissors");
        }
        //Determining winner and outputting results
        if(player == rand){

            System.out.println("It's a tie!");
        } else if((player == 0 && rand == 2) || (player == 1 && rand == 0) || (player == 2 && rand == 1)) {

            System.out.println("You Win!");
        } else {

            System.out.println("You lose!");
        }
    }
}


