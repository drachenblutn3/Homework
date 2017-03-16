
/**
 * Java lesson 3. Homework 3 . Practice.
 *
 * @author Nikolay Gritskevich
 * @version 25 feb 2017
 */

import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        compare();

    }

    static void compare() {
        Random randnum = new Rendom();
        int r = randnum.nextInt(10);
        int counter = 0;
        int continuecounter = 0;
        Scaner randomScanner = new Scanner(System.in);
        do {
            System.out.println("\n\tLet's play a game! Guess a number from 0 to 10!\nYou have 3 attempts!\n\nWhats your answer?\n");
            int num1 = randomScanner.nextInt();
            while (counter < 3) {
                if (num1 == r) System.out.println("\n\n\tCongratulations! You won! You can think your special now.\n");
                else if (r < num1) {
                    counter++;
                    System.out.println("Go Higher!\nYou have " + (3 - counter) + " more attempts.\n");
                } else if (r > num1) {
                    counter++;
                    System.out.println("Go Lower!\nYou have " + (3 - counter) + " more attempts.\n");
                }
            }
            if (counter == 3) {
                System.out.println("\nSorry, but you just lost the game. You ran out of attempts. Do you wont to try again?\n\n\t[ 1 - Yes ][ 0 - No ]\n");
                continuecounter = randomScanner.nextInt();
            }
        }while (continuecounter == 1) ;

    }
}
