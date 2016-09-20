/**
	*Nick Miller
	*CS0007
	*Assignment 2
*/
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;
import static java.text.NumberFormat.*;

public class Coffeeshopsimulator {

	public static void main (String[] args)
	{
		Random randomNumbers = new Random();
		
	// 	Variables
			final double a = 1.50;
			final double b = 3.50;
			final double c = 3.25;
			final double d = 2.00;
			double Hours, Customers, cost;
			final int Perhour = 4;
			double Goal, sumcoffee, sumlatte,sumcappuccino, sumespresso, sumtotal; 
	
		String Name = "";
	
		while(true) {
		
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Welcome to the Coffee-Shop-Sales Simulator!");
			System.out.println("");
			System.out.println("Please enter the number of hours: ");
			Hours = keyboard.nextDouble();
			
			System.out.println("");
			
			System.out.println("Please enter the sales goal without dollar sign (e.g. 250.00): ");
			Goal = keyboard.nextDouble();
			
			Customers = Hours * Perhour;
			
	//Start Simulation
	
			System.out.printf("\n ---Simulation Start --- \n");
			
	// Price Accumulators 		
			
				sumcoffee = sumlatte = sumcappuccino = sumespresso = sumtotal = 0;
				
				for(int x = 1; x<= Customers; x++){
					int item = randomNumbers.nextInt(4) + 1;
					int quantity = randomNumbers.nextInt(5) + 1;
					double total = 0.00;
					
					switch(item){
						case 1: 
							Name = "Coffee";
							total = quantity * a;
							sumcoffee += total;
							break;
						case 2: 
							Name = "Latte";
							total = quantity * b;
							sumlatte += total;
							break;
						case 3:
							Name = "Cappuccino";
							total = quantity * c;
							sumcappuccino += total;
							break;
						case 4:
							Name = "Espresso";
							total = quantity * d;
							sumespresso += total;
							break;
					}
				
				System.out.printf("\nCustomer %d\n", x);
				System.out.printf("Item Purchased: %s\n", Name);
				System.out.printf("Quantity Purchased: %d\n", quantity);
				System.out.printf("Total Cost: $%.2f\n", total);
				}
				
			sumtotal = sumespresso + sumcoffee + sumlatte + sumcappuccino;
			
			System.out.println("\n --- Simulation End --- \n\n");
			
	// End Simulation, Start Sales Report
	
			System.out.println("Aggregate Sales Report\n");
			
			NumberFormat money = getCurrencyInstance();
			
				String name1 = "Coffee Sales";
				String name2 = "Latte Sales";
				String name3 = "Cappuccino Sales";
				String name4 = "Espresso Sales";
				String name5 = "Total Sales";
				String name6 = "------------";
				String name7 = "-----------";
				String name8 = "---------------";
				String name9 = "----------------";
				String name10 = "-----------";
			
			System.out.printf("%s%15s%18s%18s%15s\n", name1, name2, name3, name4, name5);
			System.out.printf("%s%15s%18s%18s%15s\n", name6, name7, name8, name9, name10);
			System.out.printf("$%,11.2f    $%10.2f   $%14.2f  $%15.2f    $%10.2f\n", sumcoffee, sumlatte,sumcappuccino, sumespresso, sumtotal);
			System.out.println("");
			
			if(Goal <= sumtotal){
				System.out.printf("The sales goal of $%,.2f was achieved!", Goal);
			}
			else {
				System.out.printf("The sales goal of $%,.2f was not achieved", Goal);
			}
			
			System.out.printf("\n\n");
			
	// End Sales Report, check if they want to run program again
	
		while(true) {
			System.out.println("Enter 1 to run another simulation or 0 to exit: ");
				int restart = keyboard.nextInt();
					if(restart == 1){
						break;
					}
					else if(restart == 0){
						System.out.println("Goodbye!");
						return;
					}
					else {
						System.out.println("Invalid Input");
					}
			}	
		}		
	}			
					
}				