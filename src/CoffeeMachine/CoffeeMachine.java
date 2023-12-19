import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;

        while (true) {
            printMachineStatus(water, milk, coffeeBeans, disposableCups, money);

            System.out.println("\nWrite action (buy, fill, take, exit):");
            String action = scanner.next();

            if (action.equals("buy")) {
                buyCoffee(water, milk, coffeeBeans, disposableCups, money);
            } else if (action.equals("fill")) {
                fillMachine(scanner, water, milk, coffeeBeans, disposableCups);
            } else if (action.equals("take")) {
                takeMoney(money);
            } else if (action.equals("exit")) {
                break;
            }
        }
    }

    public static void printMachineStatus(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void buyCoffee(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:  // Espresso
                makeCoffee(250, 0, 16, 4, water, milk, coffeeBeans, disposableCups, money);
                break;
            case 2:  // Latte
                makeCoffee(350, 75, 20, 7, water, milk, coffeeBeans, disposableCups, money);
                break;
            case 3:  // Cappuccino
                makeCoffee(200, 100, 12, 6, water, milk, coffeeBeans, disposableCups, money);
                break;
            default:
                break;
        }
    }

    public static void makeCoffee(int requiredWater, int requiredMilk, int requiredCoffeeBeans, int cost,
                                  int water, int milk, int coffeeBeans, int disposableCups, int money) {
        if (water >= requiredWater && milk >= requiredMilk && coffeeBeans >= requiredCoffeeBeans && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= requiredWater;
            milk -= requiredMilk;
            coffeeBeans -= requiredCoffeeBeans;
            disposableCups--;
            money += cost;
        } else {
            System.out.println("Sorry, not enough resources to make your choice");
        }
    }

    public static void fillMachine(Scanner scanner, int water, int milk, int coffeeBeans, int disposableCups) {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        int addedCups = scanner.nextInt();

        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedCups;

        System.out.println("Refilling the machine...");
    }

    public static void takeMoney(int money) {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}