package lib;

import java.util.Random;
import java.util.Scanner;

public class guessGame {
    public static void main(String args[]) {
        Random random = new Random();
        int secretNum = random.nextInt(100) + 1;
        int attempts = 0;
        int game = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Number guessing game!");
        System.out.println("Choose the level of the game:\n1. Easy\n2. Medium\n3. Hard");
        int user = sc.nextInt();
        switch (user) {
            case 1:
                System.out.println("Easy");
                attempts = 10;
                break;
            case 2:
                System.out.println("Medium");
                attempts = 7;
                break;
            case 3:
                System.out.println("Hard");
                attempts = 4;
                break;
            default:
                System.out.println("Invalid level");
                sc.close();
                return;
        }

        while (game > 0) {
            System.out.println("You have " + attempts + " attempts!");
            System.out.println("I'm thinking of a number between 1 to 100. Can you guess it?");

            while (attempts > 0) {
                System.out.println("Enter your guess");
                int guess = sc.nextInt();
                attempts--;

                if (guess == secretNum) {
                    System.out.println("YOU WON! You guessed the correct number in "
                            + (attempts == 0 ? "your last attempt!" : (attempts + 1) + " attempts!"));
                    break;
                } else if (guess < secretNum) {
                    System.out.println("Too low. Pick a higher number");
                } else {
                    System.out.println("Too high. Pick a lower number");
                }
            }

            if (attempts == 0) {
                System.out.println("Game over! You have used all your attempts. \nThe secret number was: " + secretNum);
            }

            System.out.println("Do you want to continue playing?\n1. Yes\n2. No");
            int choice = sc.nextInt();
            if (choice == 1) {
                game++;
                secretNum = random.nextInt(100) + 1;
                attempts = 0;
                System.out.println("\nChoose the level of the game:\n1. Easy\n2. Medium\n3. Hard");
                user = sc.nextInt();
                switch (user) {
                    case 1:
                        System.out.println("Easy");
                        attempts = 10;
                        break;
                    case 2:
                        System.out.println("Medium");
                        attempts = 7;
                        break;
                    case 3:
                        System.out.println("Hard");
                        attempts = 4;
                        break;
                    default:
                        System.out.println("Invalid level");
                        sc.close();
                        return;
                }
            } else {
                break;
            }
        }

        sc.close();
    }
}