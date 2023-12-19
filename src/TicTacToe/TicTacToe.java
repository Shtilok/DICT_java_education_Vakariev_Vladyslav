import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Задаємо початкове ігрове поле
        char[][] gameBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        // Виводимо ігрове поле
        printGameBoard(gameBoard);

        // Друкуємо ігрове поле
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо введений рядок від користувача
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перетворюємо введений рядок в двовимірний масив символів
        char[][] convertedBoard = convertInputToBoard(input);

        // Виводимо оновлене ігрове поле
        printGameBoard(convertedBoard);
    }

    // Функція для перетворення рядка в ігрове поле
    public static char[][] convertInputToBoard(String input) {
        char[][] board = new char[3][3];
        int k = 0; // Індекс для проходження по рядку input

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Якщо зустрічено символ "_", встановлюємо пробіл
                // В іншому випадку встановлюємо символ з рядка input
                board[i][j] = (input.charAt(k) == '_') ? ' ' : input.charAt(k);
                k++;
            }
        }

        return board;
    }

    // Функція для виведення ігрового поля
    public static void printGameBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}