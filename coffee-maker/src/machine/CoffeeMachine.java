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
	}
	
	private void buyOneEspresso() {
		this.money += subtractInventory(250, 0, 16) ? 4 : 0;
	}
	
	private void buyOneLatte() {
		this.money += subtractInventory(350, 75, 20) ? 7: 0;
	}
	
	private void BuyOneCappuccino() {
		this.money += subtractInventory(200, 100, 12) ? 6 : 0;
	}
	
	private boolean subtractInventory(int water, int milk, int bean) {
		if (this.water - water < 0) {
			System.out.println("Sorry, not enough water!");
		} else if (this.milk - milk < 0) {
			System.out.println("Sorry, not enough milk!");
		} else if (this.bean - bean < 0){
			System.out.println("Sorry, not enough bean!");
		} else if (this.cup == 0) {
			System.out.println("Sorry, not enough cups!");
		} else {
			System.out.println("I have enough resources, making you a coffee!");
			this.water -= water;
			this.milk -= milk;
			this.bean -= bean;
			this.cup -= 1;
			return true;
		}
		return false;
	}
	
	public void fill (int water, int milk, int bean, int cup) {
		this.water += water;
		this.milk += milk;
		this.bean += bean;
		this.cup += cup;
	}
	
	public void take () {
		System.out.printf("I gave you $%d\n", this.money);
		this.money = 0;
	}
	
	public void getRemaining() {
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", this.water);
		System.out.printf("%d of milk\n", this.milk);
		System.out.printf("%d of coffee beans\n", this.bean);
		System.out.printf("%d of disposable cups\n", this.cup);
		System.out.printf("$%d of money\n", this.money);
	}
	
    public static void main(String[] args) {
        CoffeeMachine cfm = new CoffeeMachine();
        
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        
        boolean keepUsing = true;
        while(keepUsing) {
        	System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.nextLine();
            
        	if (choice.equals("buy")) {
	        	System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
	        	String coffeeChoice = scanner.nextLine();
	        	if (coffeeChoice.equals("back")) {
	        		continue;
	        	}
	        	cfm.buy(Integer.parseInt(coffeeChoice));
        	} else if (choice.equals("fill")) {
	        	System.out.println("Write how many ml of water do you want to add:");
	        	int water = scanner.nextInt();
	        	System.out.println("Write how many ml of milk do you want to add:");
	        	int milk = scanner.nextInt();
	        	System.out.println("Write how many grams of coffee beans do you want to add:");
	        	int bean = scanner.nextInt();
	        	System.out.println("Write how many disposable cups of coffee do you want to add:");
	        	int coffee = scanner.nextInt();
	        	
	        	scanner.nextLine();
	        	cfm.fill(water, milk, bean, coffee);
        	} else if (choice.equals("take")) {
        		cfm.take();
        	} else if (choice.equals("remaining")){
        		cfm.getRemaining();
        	} else {
        		keepUsing = false;
        	}
        	System.out.println();
        }
    }
}
