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

        // Пробуємо вгадати вік користувача
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7.");

        // Зчитуємо залишки від ділення на 3, 5 і 7
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        // Визначаємо вік користувача за формулою
        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виводимо вгаданий вік
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");

        // Закриваємо Scanner
        scanner.close();
    }
}
