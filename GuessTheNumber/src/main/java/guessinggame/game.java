package guessinggame;

import java.util.Scanner;

public class game {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greetUser();
        playGame();
        scanner.close();
        System.out.println("Thanks for playing!");
    }

    // This method greets the user and provides the instructions for the game.
    private static void greetUser() {
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Can you guess what it is?");
        System.out.println("You have 3 attempts to guess the number.");
    }

    // This method generates a random number between 1 and 100.
    private static int generateRandomNumber() {
        int computerNumber = (int) (Math.random() * 100) + 1;
        return computerNumber;
    }

    // This method prompts the user to guess the number.
    public static int userGuess() {
        System.out.println("Enter your guess: ");
        int userGuess = scanner.nextInt();
        return userGuess;
    }

    // Main game logic
    private static void playGame() {
        int attempts = 0;
        int maxAttempts = 3;
        int randomNumber = generateRandomNumber();
        int userGuess = -1;
        while (attempts < maxAttempts && userGuess != randomNumber) {
            userGuess = userGuess();
            attempts++;
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
        if (userGuess != randomNumber) {
            System.out.println("Sorry, you didn't guess the number. The number was " + randomNumber + ".");
        }
    }
}