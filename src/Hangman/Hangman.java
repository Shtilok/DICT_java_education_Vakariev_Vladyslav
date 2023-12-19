import java.util.Scanner;
import java.util.Random;
public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        String wordToGuess = wordList[random.nextInt(wordList.length)];

        // Відобразити перші 2 літери слова, решта літер будуть дефісами
        StringBuilder displayWord = new StringBuilder();
        displayWord.append(wordToGuess.charAt(0));
        displayWord.append(wordToGuess.charAt(1));
        for (int i = 2; i < wordToGuess.length(); i++) {
            displayWord.append("-");
        }

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        System.out.print("Guess the word " + displayWord + ": > ");

        String playerGuess = scanner.next();

        if (playerGuess.equals(wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
