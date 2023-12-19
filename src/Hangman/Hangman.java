import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] wordList = {"python", "java", "javascript", "kotlin"};
        String wordToGuess = wordList[random.nextInt(wordList.length)];

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");

        String playerGuess = scanner.next();

        if (playerGuess.equals(wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost! The correct word was: " + wordToGuess);
        }
    }
}
