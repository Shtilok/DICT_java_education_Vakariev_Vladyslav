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

        // Головний цикл гри
        while (true) {
            // Просимо користувача ввести свій хід
            System.out.print("Enter the coordinates: ");
            String coordinatesInput = scanner.nextLine();

            try {
                // Перетворюємо введені координати в числа
                String[] coordinatesArray = coordinatesInput.split(" ");
                int row = Integer.parseInt(coordinatesArray[0]) - 1;
                int col = Integer.parseInt(coordinatesArray[1]) - 1;

                // Перевірка коректності введених координат
                if (row < 0 || row > 2 ||  col < 0 || col > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                // Перевірка, чи клітинка не зайнята
                if (gameBoard[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                // Оновлення ігрового поля та вивід результату
                gameBoard[row][col] = 'X';
                printGameBoard(gameBoard);
                printGameResult(gameBoard);

                // Перевірка завершення гри
                if (!checkGameNotFinished(gameBoard)) {
                    break;
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You should enter valid numbers!");
            }
        }

        // Закриваємо Scanner
        scanner.close();
    }

    // Функція для перетворення рядка в ігрове поле
    public static char[][] convertInputToBoard(String input) {
        char[][] board = new char[3][3];
        int k = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (input.charAt(k) == '_') ? ' ' : input.charAt(k);
                k++;
            }
        }

        return board;
    }

    // Інші функції залишаються без змін
    // ...
}