import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;
    private String state = "idle";

    public void processInput(String input) {
        switch (state) {
            case "idle":
                processIdleState(input);
                break;
            case "choosingCoffee":
                processChoosingCoffeeState(input);
                break;
            case "filling":
                processFillingState(input);
                break;
            case "taking":
                processTakingState(input);
                break;
        }
    }

    private void processIdleState(String input) {
        switch (input) {
            case "buy":
                state = "choosingCoffee";
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                state = "fillingWater";
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                displayResources();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid action. Please try again.");
        }
    }

    private void processChoosingCoffeeState(String input) {
        switch (input) {
            case "1": // Espresso
                makeCoffee(250, 0, 16, 4);
                break;
            case "2": // Latte
                makeCoffee(350, 75, 20, 7);
                break;
            case "3": // Cappuccino
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                state = "idle";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void processFillingState(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            amount = 0;
        }

        switch (state) {
            case "fillingWater":
                water += amount;
                state = "fillingMilk";
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case "fillingMilk":
                milk += amount;
                state = "fillingCoffeeBeans";
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case "fillingCoffeeBeans":
                coffeeBeans += amount;
                state = "fillingCups";
                System.out.println("Write how many disposable coffee cups you want to add:");
                break;
            case "fillingCups":
                disposableCups += amount;
                state = "idle";
                System.out.println("Machine has been refilled.");
                break;
        }
    }

    private void processTakingState(String input) {
        if (input.equals("take")) {
            takeMoney();
        }
    }
    private void makeCoffee(int neededWater, int neededMilk, int neededCoffeeBeans, int cost) {
        if (water < neededWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < neededCoffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= neededWater;
            milk -= neededMilk;
            coffeeBeans -= neededCoffeeBeans;
            disposableCups--;
            money += cost;
        }
        state = "idle";
    }

    private void fillMachine(Scanner scanner) {
        state = "fillingWater";
        System.out.println("Write how many ml of water you want to add:");
        processFillingState(String.valueOf(scanner.nextInt()));
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
        state = "idle";
    }

    private void displayResources() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
        state = "idle";
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            coffeeMachine.processInput(action);
        }
    }
}