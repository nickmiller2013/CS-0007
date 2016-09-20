import java.util.Scanner;
import java.text.DecimalFormat;

/**
	Nick Miller
	CS 0007
	Assignment 1
*/

public class Assignment2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String name;
		double item, quantity;
		double Before;
		double Discount;
		double After;
		double Tax;
		double Final;
		double taxrate = .07;
		double a = 1.50;
		double b = 3.50;
		double c = 3.25;
		double d = 2.00;
		
		DecimalFormat formatter = new DecimalFormat("##,##0.00");
		
		System.out.println("Please enter you're name: ");
		name = input.nextLine();
		
		System.out.println();
		
		System.out.println("Welcome to the Java Byte Code Coffee Shop, " + name + "!");
		
		System.out.println();
		
		System.out.println("Here is our menu: ");
		System.out.println();
		System.out.println("1. Coffee       $" + formatter.format(a));
		System.out.println("2. Latte        $" + formatter.format(b));
		System.out.println("3. Cappuccino   $" + formatter.format(c));
		System.out.println("4. Espresso     $" + formatter.format(d));
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the item number: ");
		item = keyboard.nextDouble();
		
		System.out.println("Please enter the amount of this item you'd like: ");
		quantity = keyboard.nextDouble();
		
		if (item == 1){
			item = a;
		} else if (item == 2){
			item = b;
		} else if (item == 3){
			item = c;
		} else if (item == 4){
			item = d;
		}
		
		Before = item * quantity;
		System.out.println("You're total before deduction is: $" + formatter.format(Before));
		
		System.out.println();
		
		if (Before >= 10){
			Discount = Before * .10;
			System.out.println("You have a deduction of: $" + formatter.format(Discount));
			
			System.out.println();
			
			After = Before - Discount;
			System.out.println("You're total before tax is: $" + formatter.format(After));
			
			System.out.println();
			
			Tax = After * taxrate;
			System.out.println("You're tax is: $" + formatter.format(Tax));
			
			System.out.println();
			
			Final = After + Tax;
			System.out.println("You're total is: $" + formatter.format(Final));
			}
			
		if (Before < 10){
		System.out.println("You do not recieve a discount on this purchase");
		
			System.out.println();
			
			Tax = Before * taxrate;
			System.out.println("You're tax is: $" + formatter.format(Tax));
			
			System.out.println();
			
			Final = Before + Tax;
			System.out.println("You're total is: $" + formatter.format(Final));
			
		}
		
		System.out.println();
		System.out.println("Thank you " + name + "! Please stop by again!");
		}
		}