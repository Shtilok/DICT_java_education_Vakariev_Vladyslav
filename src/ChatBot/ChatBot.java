import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Ім'я бота (вибране вами)
        String botName = "MyBot";
        // Поточний рік
        int birthYear = 2023;
        // Виводимо привітання з ім'ям та роком створення бота
        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");

        // Створюємо об'єкт Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Запитуємо користувача про його ім'я
        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();

        // Виводимо привітання з ім'ям користувача
        System.out.println("What a great name you have, " + userName + "!");

        // Закриваємо Scanner
        scanner.close();
    }
}
