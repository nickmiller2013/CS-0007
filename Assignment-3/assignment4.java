/** 
	*Nick Miller
	*CS0007
	*Assignment 3
*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class assignment4
	{
	public static void main(String[] args)
		{
		// This is the main method where all of my methods come together. 
		
		double Total, Tax, taxRate = .07, finalitem, finalquantity, finalsubtotal, discount, afterdiscount;
		boolean discountcheck;

		Scanner input = new Scanner(System.in);
		String name;

		DecimalFormat formatter = new DecimalFormat("##,##0.00");
		
		System.out.println("Please enter you're name: ");
		name = input.nextLine();
		
		System.out.println();
		
		System.out.println("Welcome to the Java Byte Code Coffee Shop, " + name + "!");
		
		System.out.println();
		
		displayMenu();
		
		finalitem = getItemNumber();

		finalquantity = getQuantity();

		finalsubtotal = computeSubTotal(finalquantity, finalitem);

		discountcheck = discountCheck(finalsubtotal);

		discount = computeDiscount(discountcheck, finalsubtotal);

		afterdiscount = computePriceAfterDiscount(finalsubtotal, discount);

		Tax = computeTax(taxRate, afterdiscount);

		Total = computeTotal(Tax, afterdiscount);

		displayOutput(finalsubtotal, discount, afterdiscount, Tax, Total);
		
		System.out.println("");
		
		System.out.println("Thank you " + name + "! Please stop by again!");
		
		}
	public static void displayMenu()
	// This method displays the menu of the Java Byte Code Coffee Shop
		{
		DecimalFormat formatter = new DecimalFormat("##,##0.00");
		double a = 1.50;
		double b = 3.50;
		double c = 3.25;
		double d = 2.00;
		System.out.println("Here is our menu: ");
		System.out.println();
		System.out.println("1. Coffee       $" + formatter.format(a));
		System.out.println("2. Latte        $" + formatter.format(b));
		System.out.println("3. Cappuccino   $" + formatter.format(c));
		System.out.println("4. Espresso     $" + formatter.format(d));
		}
	public static double getItemNumber()
	// This method gets the item number and returns the user input
	{
		double item; 
		double a = 1.50;
		double b = 3.50;
		double c = 3.25;
		double d = 2.00;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the item number: ");
		item = keyboard.nextDouble();
		
		if (item == 1){
			item = a;
		} else if (item == 2){
			item = b;
		} else if (item == 3){
			item = c;
		} else if (item == 4){
			item = d;
		}
		
		return item;
	}
	public static double getQuantity()
	// This prompts the user to enter the quantity and returns that value
	{
		double quantity; 
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the amount you'd like: ");
		quantity = keyboard.nextDouble();
		
		return quantity;
	}
	public static double computeSubTotal(double num1, double num2)
	// This computes the subtotal then returns it.
	{
		return num1 * num2;
	}
	public static boolean discountCheck(double num1)
	// This checks whether or not there should be a discount
	{
	if(num1 >= 10)
		{
		return true;
		}
	else
		{
		return false;
		}
	}
	public static double computeDiscount(boolean num1, double num2)
	// This gives the discount, if there is one. 
	{
	double value;
	
	if(num1 == true)
		{
		value = .1 * num2;
		}
	else
		{
		value = 0;
		}
	return value;
	}
	public static double computePriceAfterDiscount(double num1, double num2)
	// This computes the price after the discount
	{
	return num1 - num2;
	}
	public static double computeTax(double num1, double num2)
	// This computes the tax of the current total 
	{
	return num1 * num2;
	}
	public static double computeTotal(double num1, double num2)
	// This computes the price after discount and tax 
	{
	return num2 + num1;
	}
	public static void displayOutput(double num1, double num2, double num3, double num4, double num5)
	// This displays all the lines of the output user
	{
	DecimalFormat formatter = new DecimalFormat("##,##0.00");
	System.out.println("You're total before deduction is: $" + formatter.format(num1));
	System.out.println("");
	System.out.println("You're discounted amount is: $" + formatter.format(num2));
	System.out.println("");
	System.out.println("You're price after discount is: $" + formatter.format(num3));
	System.out.println("");
	System.out.println("You're tax is: $" + formatter.format(num4));
	System.out.println("");	
	System.out.println("You're final total is: $" + formatter.format(num5));
	return;
	}
}