import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvailable = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvailable = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAvailable = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int cupsDesired = scanner.nextInt();

        int cupsPossibleByWater = waterAvailable / 200;
        int cupsPossibleByMilk = milkAvailable / 50;
        int cupsPossibleByBeans = coffeeBeansAvailable / 15;

        int water = cups * 200;
        int milk = cups * 50;
        int coffeeBeans = cups * 15;
        int maxCupsPossible = Math.min(cupsPossibleByWater, Math.min(cupsPossibleByMilk, cupsPossibleByBeans));

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        if (cupsDesired == 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsPossible - cupsDesired) + " more than that)");
        } else if (cupsDesired <= maxCupsPossible) {
            if (cupsDesired == maxCupsPossible) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsPossible - cupsDesired) + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + maxCupsPossible + " cups of coffee");
        }
    }
}