// Number Guessing Game

import java.util.Scanner;
import java.util.Random;

public class numbergame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create Scanner once and reuse

        System.out.println("=== Welcome to the Number Guessing Game! ===");

        boolean playAgain = true;

        while (playAgain) {
            int randomNum = generateRandom();
            playGame(randomNum, in);

            System.out.println("Do you want to play again?");
            System.out.println("Press 1 to play again, 0 to exit:");
            int choice = in.nextInt();

            if (choice != 1) {
                playAgain = false;
                System.out.println("Thank you for playing. Goodbye!");
            }
        }

        in.close(); // Close scanner when done
    }

    // Method to generate random number between 0 and 10
    public static int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(11); // generates number from 0 to 10
    }

    // Method to play the guessing game
    public static void playGame(int randomNum, Scanner in) {
        int guess;
        int tries = 0;

        System.out.print("\nGuess a number between 0 and 10: ");
        guess = in.nextInt();

        // Input validation
        while (guess < 0 || guess > 10) {
            System.out.print("Invalid input. Please enter a number between 0 and 10: ");
            guess = in.nextInt();
        }

        // Loop until correct guess
        while (guess != randomNum) {
            tries++;
            System.out.println("Wrong guess!");

            // Optional: give a hint
            if (guess < randomNum) {
                System.out.println("Hint: Try a higher number.");
            } else {
                System.out.println("Hint: Try a lower number.");
            }

            System.out.print("Guess again: ");
            guess = in.nextInt();

            // Input validation again
            while (guess < 0 || guess > 10) {
                System.out.print("Invalid input. Please enter a number between 0 and 10: ");
                guess = in.nextInt();
            }
        }

        // When guessed correctly
        System.out.println("Congratulations! You guessed the correct number.");
        System.out.println("Number of wrong tries: " + tries + "\n");
    }
}
