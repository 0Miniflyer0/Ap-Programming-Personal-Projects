import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; 
        int maxAttempts = 5;
        int attempts = 0;
        boolean hasWon = false;

        String evenOrOdd = (numberToGuess % 2 == 0) ? "even" : "odd";
        String rangeHint = (numberToGuess <= 50) ? "between 1 and 50" : "between 51 and 100";

        System.out.println("Welcome to Guess the Number Game.");
        System.out.println("We're gonna use a number, between 1-100.");
        System.out.println("Here's a hint: The number is " + evenOrOdd + " and is " + rangeHint + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("That's not a number. Please enter a number.");
                scanner.next(); 
                continue; 
            }

            int playerGuess = scanner.nextInt();
            attempts++;

            if (playerGuess == numberToGuess) {
                hasWon = true;
                break;
            } else if (playerGuess < numberToGuess) {
                System.out.println("Nope, too low.");
            } else {
                System.out.println("Nope, too high.");
            }

            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Unfortunately, you've used all attempts. The number was: " + numberToGuess);
        }

        scanner.close();
    }
}
