package machine;

import java.util.Scanner;

public class CoffeeMachine {
	
	static int getMaxCupOfCoffee(int water, int milk, int bean) {
		int maxCupOfCoffee = Math.min(Math.min(water/200, milk/50), bean/15);		
		return maxCupOfCoffee;
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int bean = scanner.nextInt();
        
        System.out.println("Write how many cups of coffee you will need:");
        int cupOfCoffee = scanner.nextInt();
        
        int maxCupOfCoffee = getMaxCupOfCoffee(water, milk, bean);
        if (cupOfCoffee == maxCupOfCoffee) {
        	System.out.println("Yes, I can make that amount of coffee");
        } else if (cupOfCoffee < maxCupOfCoffee) {
        	System.out.printf("Yes, I can make that amount of coffee "
        					+ "(and even %d more than that)\n", (maxCupOfCoffee - cupOfCoffee));
        } else {
        	System.out.printf("No, I can make only %d cup(s) of coffee", maxCupOfCoffee);
        }
    }
}
