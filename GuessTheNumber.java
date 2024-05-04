import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 100;  // Change this to adjust the guessing range
        int maxTries = 5;      // Change this to adjust the number of attempts

        int secretNumber = random.nextInt(maxNumber) + 1; // Generate random number between 1 and maxNumber
        int numTries = 0;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + maxTries + " tries to guess a number between 1 and " + maxNumber);

        while (numTries < maxTries) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            numTries++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + numTries + " tries!");
                score = calculateScore(maxTries, numTries);
                System.out.println("Your score: " + score);
                break;
            } else if (guess < secretNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        if (numTries == maxTries) {
            System.out.println("Sorry, you ran out of tries. The number was: " + secretNumber);
        }

        System.out.println("Do you want to play again? (y/n)");
        String playAgain = scanner.next();

        if (playAgain.equalsIgnoreCase("y")) {
            main(args); // Restart the game
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }

    // Function to calculate score based on remaining attempts (higher attempts = lower score)
    public static int calculateScore(int maxTries, int usedTries) {
        return maxTries - usedTries + 1;
    }
}
