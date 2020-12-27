package machine;

import java.util.Scanner;
enum Coffee {
	
	Espresso(250, 0, 16, 4),
	Latte(350, 75, 20, 7),
	Cappuccino(200, 100, 12, 6);
	
	public final int water;
	public final int milk;
	public final int bean;
	public final int price;

    Coffee(int water, int milk, int bean, int price) {
        this.water = water;
        this.milk = milk;
        this.bean = bean;
        this.price = price;
    }
}

public class CoffeeMachine {
	
	private int water;
	private int milk;
	private int bean;
	private int cup;
	private int money;
	
	private Coffee espresso;
	private Coffee latte;
	private Coffee cappuccino;
	
	public CoffeeMachine(int water, int milk, int bean, int cup, int money) {
		this.water = water;
		this.milk = milk;
		this.bean = bean;
		this.cup = cup;
		this.money = money;
		
		this.espresso = Coffee.Espresso;
		this.latte = Coffee.Latte;
		this.cappuccino = Coffee.Cappuccino;
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
		this.money += subtractInventory(this.espresso) ? this.espresso.price : 0;
	}
	
	private void buyOneLatte() {
		this.money += subtractInventory(this.latte) ? this.latte.price : 0;
	}
	
	private void BuyOneCappuccino() {
		this.money += subtractInventory(this.cappuccino) ? this.cappuccino.price : 0;
	}
	
	private boolean subtractInventory(Coffee coffee) {
		boolean enoughInventory = checkInventory(coffee.water, coffee.milk, coffee.bean);
		if (enoughInventory) {
			System.out.println("I have enough resources, making you a coffee!");
			this.water -= coffee.water;
			this.milk -= coffee.milk;
			this.bean -= coffee.bean;
			this.cup -= 1;
			return true;
		}
		return false;
	}
	
	private boolean checkInventory(int water, int milk, int bean) {
		if (this.water - water < 0) {
			System.out.println("Sorry, not enough water!");
		} else if (this.milk - milk < 0) {
			System.out.println("Sorry, not enough milk!");
		} else if (this.bean - bean < 0){
			System.out.println("Sorry, not enough bean!");
		} else if (this.cup == 0) {
			System.out.println("Sorry, not enough cups!");
		} else {
			return true;
		}
		return false;
	}
	
	public void fill(int water, int milk, int bean, int cup) {
		this.water += water;
		this.milk += milk;
		this.bean += bean;
		this.cup += cup;
	}
	
	public void take() {
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
        CoffeeMachine cfm = new CoffeeMachine(400, 540, 120, 9, 550);
        
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