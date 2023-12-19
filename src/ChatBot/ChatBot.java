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
        // Просимо користувача ввести число для підрахунку
        System.out.println("Now, let me prove to you that I can count to any number you want!");
        int userNumber = scanner.nextInt();

        // Підраховуємо та виводимо числа від 1 до введеного числа
        // Підраховуємо та виводимо числа від 1 до введеного числа з знаком оклику
        for (int i = 1; i <= userNumber; i++) {
            System.out.println(i + "!");
        }

        // Проводимо тест на програмування
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods in Java?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into small and manageable pieces.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To confuse the programmer.");

        int correctAnswer = 2;
        int userAnswer;

        do {
            System.out.print("Enter the number of your answer: ");
            userAnswer = scanner.nextInt();
            if (userAnswer != correctAnswer) {
                System.out.println("Your answer is incorrect. Please try again.");
            }
        } while (userAnswer != correctAnswer);

        System.out.println("Congratulations! Your answer is correct.");

        // Закриваємо Scanner
        scanner.close();

        // Завершуємо програму
        System.out.println("Goodbye, have a nice day!");
    }
}
