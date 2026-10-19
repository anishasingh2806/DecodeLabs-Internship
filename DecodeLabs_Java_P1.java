import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static final int POINTS_PER_UNUSED_ATTEMPT = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        String playAgain;

        System.out.println("====================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("====================================");
        System.out.println("Guess the secret number from 1 to 100.");
        System.out.println("You have " + MAX_ATTEMPTS + " valid guesses per round.");

        do {
            int target = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            int attempts = 0;
            boolean won = false;

            System.out.println("\nNew round started!");

            while (attempts < MAX_ATTEMPTS && !won) {
                System.out.print("Enter your guess (1-100): ");

                int guess;

                // Validate that the user entered a whole number.
                try {
                    guess = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    sc.next(); // Remove invalid input so the program can ask again.
                    continue;
                }

                // A number outside the range is not counted as an attempt.
                if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                    System.out.println("Out of range. Enter a number from 1 to 100.");
                    continue;
                }

                attempts++;

                if (guess == target) {
                    won = true;
                    int roundScore = (MAX_ATTEMPTS - attempts + 1) * POINTS_PER_UNUSED_ATTEMPT;
                    totalScore += roundScore;

                    System.out.println("Correct! You guessed the secret number.");
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Round score: " + roundScore);
                } else if (guess > target) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Too low! Try a higher number.");
                }

                if (!won) {
                    int attemptsLeft = MAX_ATTEMPTS - attempts;
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!won) {
                System.out.println("Game over! You used all " + MAX_ATTEMPTS + " attempts.");
                System.out.println("The secret number was: " + target);
                System.out.println("Round score: 0");
            }

            System.out.println("Total score so far: " + totalScore);

            // Ask whether to start another round; accept only Y or N.
            while (true) {
                System.out.print("Play again? (Y/N): ");
                playAgain = sc.next().trim();

                if (playAgain.equalsIgnoreCase("Y") ||
                    playAgain.equalsIgnoreCase("N")) {
                    break;
                }

                System.out.println("Invalid choice. Please enter Y or N.");
            }

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("\n====================================");
        System.out.println("Thanks for playing!");
        System.out.println("Final score: " + totalScore);
        System.out.println("====================================");

        sc.close();
    }
}