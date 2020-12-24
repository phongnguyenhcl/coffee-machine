package machine;

import java.util.Scanner;

public class CoffeeMachine {
	
	private int water;
	private int milk;
	private int bean;
	private int cup;
	private int money;
	
	public CoffeeMachine() {
		this.water = 400;
		this.milk = 540;
		this.bean = 120;
		this.cup = 9;
		this.money = 550;
	}
	
	public void buy(int option) {
		switch(option) {
		case 1:
			buyOneEspresso();
			break;
		case 2:
			buyOneLatte();
			break;
		case 3:
			BuyOneCappuccino();
			break;
		}
		
		showStatistics();
	}
	
	private void buyOneEspresso() {
		subtractInventory(250, 0, 16);
		this.money += 4;
	}
	
	private void buyOneLatte() {
		subtractInventory(350, 75, 20);
		this.money += 7;
	}
	
	private void BuyOneCappuccino() {
		subtractInventory(200, 100, 12);
		this.money += 6;
	}
	
	private void subtractInventory(int water, int milk, int bean) {
		this.water -= water;
		this.milk -= milk;
		this.bean -= bean;
		this.cup -= 1;
	}
	
	public void fill (int water, int milk, int bean, int cup) {
		this.water += water;
		this.milk += milk;
		this.bean += bean;
		this.cup += cup;
		
		showStatistics();
	}
	
	public void take () {
		System.out.printf("I gave you $%d\n", this.money);
		this.money = 0;
		
		System.out.println();
		showStatistics();
	}
	
	public void showStatistics() {
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", this.water);
		System.out.printf("%d of milk\n", this.milk);
		System.out.printf("%d of coffee beans\n", this.bean);
		System.out.printf("%d of disposable cups\n", this.cup);
		System.out.printf("%d of money\n", this.money);
	}
	
    public static void main(String[] args) {
        CoffeeMachine cfm = new CoffeeMachine();
        cfm.showStatistics();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite action (buy, fill, take):");
        String choice = scanner.nextLine();
        
        if (choice.equals("buy")) {
        	System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        	int coffeeChoice = scanner.nextInt();
        	
        	System.out.println();
        	cfm.buy(coffeeChoice);
        } else if (choice.equals("fill")) {
        	System.out.println("Write how many ml of water do you want to add:");
        	int water = scanner.nextInt();
        	System.out.println("Write how many ml of milk do you want to add:");
        	int milk = scanner.nextInt();
        	System.out.println("Write how many grams of coffee beans do you want to add:");
        	int bean = scanner.nextInt();
        	System.out.println("Write how many disposable cups of coffee do you want to add:");
        	int coffee = scanner.nextInt();
        	
        	cfm.fill(water, milk, bean, coffee);
        } else {
        	cfm.take();
        }
    }
}
