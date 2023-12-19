import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо введений рядок від користувача
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перетворюємо введений рядок в ігрове поле
        char[][] gameBoard = convertInputToBoard(input);

        // Виводимо ігрове поле
        printGameBoard(gameBoard);

        // Аналізуємо стан гри та виводимо результат
        printGameResult(gameBoard);
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

    // Функція для аналізу стану гри та виведення результату
    public static void printGameResult(char[][] board) {
        if (checkImpossible(board)) {
            System.out.println("Impossible");
        } else if (checkWinner(board, 'X')) {
            System.out.println("X wins");
        } else if (checkWinner(board, 'O')) {
            System.out.println("O wins");
        } else if (checkGameNotFinished(board)) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    // Функція для перевірки неможливого стану гри
    public static boolean checkImpossible(char[][] board) {
        int countX = countOccurrences(board, 'X');
        int countO = countOccurrences(board, 'O');

        int diff = Math.abs(countX - countO);

        if (diff >= 2 || (countX > countO && checkWinner(board, 'O')) || (countO > countX && checkWinner(board, 'X'))) {
            return true;
        }

        return false;
    }

    // Функція для перевірки наявності переможця
    public static boolean checkWinner(char[][] board, char player) {
        // Перевірка по горизонталі, вертикалі та діагоналям
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Перевірка горизонталі
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Перевірка вертикалі
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Перевірка головної діагоналі
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Перевірка побічної діагоналі
        }

        return false;
    }

    // Функція для перевірки, чи гра не завершилась
    public static boolean checkGameNotFinished(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }

        return false;
    }

    // Функція для підрахунку кількості входжень символу в ігровому полі
    public static int countOccurrences(char[][] board, char symbol) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == symbol) {
                    count++;
                }
            }
        }

        return count;
    }
}