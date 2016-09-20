/** Nick Miller
	Assignment 5
	CS 0007 **/
import java.util.Scanner;

public class WebStore2
{
	public static void main(String[] args)
	{
		/**array declarations and initializations**/
		//TO-DO: initialize the itemNames array with the item names
		//(e.g. "eReader", "Java textbook", ...)
		String[] itemNames = {"eReader", "Java textbook", "Flash drive", "Netbook", "Python textbook", "Laptop PC", "Headphones", "Tablet PC", "Wireless Keyboard", "Laptop Briefcase"};
		//TO-DO: initialize the price array (e.g. 180.0, 85.0, ...)
		double[] priceArray = {180.00, 85.00, 12.00, 250.00, 95.00,770.00, 55.00, 300.00, 60.00, 40.00};		
		double[] priceArray2 = {180.00, 85.00, 12.00, 250.00, 95.00,770.00, 55.00, 300.00, 60.00, 40.00};		
		int[] shoppingCart = new int[10];
		int[] x = new int[10];
		//TO-DO: initialize the accountNumbers array
		//(e.g. "5658945", "4528125", ...)
		String[] accountNumbers = {"5658945", "4528125", "7805122", "8777521", "8751277", "1202850", "1005331", "6542231", "3812085", "7576631", "7981200", "4281002"};

		
		/**other variable declarations and initializations**/
		Scanner keyboard = new Scanner(System.in);
		int menuChoice = 0;
		double a, b;
		String userName = "";
		int itemNumber;	//used to store item selection during "item add" operation
		int[] quantity = new int[10];	//used to store quantity during "item add" operation
		boolean cartIsEmpty = true;
		String userAccountNumber = "";	//used in the checkout operation
		boolean accountNumberIsValid = false;	//used in the checkout operation
		
		
		//print welcome message
		System.out.println("Welcome to the Java Web Store!");
		
		//start main program loop
		do
		{
			//print the menu options
			//TO-DO: write print statements to print the menu
			System.out.println("");
			System.out.printf("Menu Options: \n 1. View item selection \n 2. View shopping cart \n 3. Add item to cart \n 4. Remove item from cart \n 5. Checkout \n 6. Exit\n");
			System.out.println("");
			
			
			//prompt the user to enter a menu option
			System.out.println("Please enter your selection: ");
			menuChoice = keyboard.nextInt();
			
			//use a switch statement to act based on the value of
			//menuChoice variable
			switch(menuChoice)
			{
				
				case 1:	//view item selection
					//TO-DO: write print statements to print the
					//item selections
					System.out.printf("Item Selections: \n");
					for(int index = 0; index < 10; index++){
						System.out.printf("\n" + (index + 1) + ". %-25s$%10.2f", itemNames[index], priceArray[index]);
					}			
					break;
				
				case 2:	//view shopping cart
					//first determine if the cart is empty
					//how to do this: assume cart is empty, and if we find
					//an entry > 0, infer that cart is non-empty
					//use the flag variable cartIsEmpty to keep track of this
					cartIsEmpty = true;
					for (int i = 0; i < 9; i++)
					{
						if (quantity[i] > 0)
							cartIsEmpty = false;
					}
					
					//print a message if cart is empty
					if (cartIsEmpty)
						System.out.println("Your shopping cart is currently empty.");
					else
					{
						//print the title and table heading
						System.out.println("\n\nShopping Cart Contents:");
						System.out.printf("%-25s%-25s%10s", "Item", "Quantity", "Cost");
						System.out.print("\n-------------------------------------------------------------");
						
						//loop through the shoppingCart array and print a table row for
						//each item that has an entry > 0
						for (int i = 0; i < 10; i++)
						{
							if(quantity[i] > 0){
								System.out.printf("\n%-25s%-25d$%10.2f", itemNames[i], quantity[i], priceArray[i]);
							}
						}
						System.out.println("");
					}
		
					break;
					
					case 3:	//add item to cart
						//prompt user for item number and quantity
						//TO-DO: prompt user for item number; store input in the
						//variable itemNumber
						int quantity3;
						System.out.printf("\n Please enter an item number: ");
						itemNumber = keyboard.nextInt();
						itemNumber = itemNumber - 1;
						//TO-DO: prompt user for quantity; store input in the
						//variable quantity
						System.out.println("Enter a new quantity: ");
						quantity3 = keyboard.nextInt();
						x[itemNumber] = quantity[itemNumber];
						if(quantity3 > 0){
						//TO-DO: update the shopping cart array
						quantity[itemNumber] = quantity[itemNumber] + quantity3;
						priceArray[itemNumber] = quantity[itemNumber] * priceArray[itemNumber];
						}
						//TO-DO: print a confirmation message to the user
						//e.g. "Added 4 Headphones to your cart."
						System.out.println("");
						System.out.println("Added " + quantity3 + " " + itemNames[itemNumber] + " to your cart");
						System.out.println("You have: " + quantity[itemNumber]);
						
						break;
					
					case 4:	//remove item from cart
						//prompt user for item number and quantity
						//TO-DO: prompt user for item number; store input in the
						//variable itemNumber
						int quantity2;
						System.out.println("Enter an item number: ");
						itemNumber = keyboard.nextInt();
						itemNumber = itemNumber - 1;
						//TO-DO: prompt user for quantity; store input in the
						//variable quantity
						System.out.println("Enter a new quantity: ");
						quantity2 = keyboard.nextInt();
						
						//perform remove operation if possible
						//the operation is not possible if, for the item, we have:
						//(quantity to remove) > (quantity in cart)
						
						//TO-DO: fill in the proper index for the shoppingCart array
						if (quantity[itemNumber] < quantity2)
						{
							//TO-DO: fill in the proper index for the shoppingCart array and the itemNames array
							System.out.print("You have " + quantity[itemNumber] + " " + itemNames[itemNumber] + " in your cart.  " +
											 " Nothing was removed.\n");
						}
						else
						{
							//perform remove operation and print confirmation message to user
							//TO-DO: remove the quantity from the proper element of the shoppingCart array
								quantity[itemNumber] = quantity[itemNumber] - quantity2;
								priceArray[itemNumber] = quantity[itemNumber] * priceArray[itemNumber];
											
							//TO-DO: print a confirmation message to the user
							//e.g. "Removed 1 Headphones from your cart."
								System.out.println("");
								System.out.println("Removed " + quantity2 + " " + itemNames[itemNumber] + " from your cart"); 
								System.out.println("You have : " + quantity[itemNumber]);
						}
						
						break;
						
					case 5:	//checkout
						//prompt user to enter an account number; store input in variable userAccountNumber
						
						//check if the account number is valid
						//how to do this: assume account number is invalid; then iterate
						//through the accountNumbers array, each time comparing userAccountNumber to the
						//current element of accountNumbers to see if there is a match
						//use the flag variable accountNumberIsValid to keep track of this
						accountNumberIsValid = false;
						
						System.out.print("Please enter your account number to complete your order: ");
						userAccountNumber = keyboard.nextLine();	
						userAccountNumber = keyboard.nextLine();
						
						//we will loop until the user enters a valid account number
						if(accountNumberIsValid == false){
						do
						{
							
						
							for (int i = 0; i < accountNumbers.length; i++)
							{
								if (accountNumbers[i].equals(userAccountNumber))
								{
									accountNumberIsValid = true;
								}
							}
							
							//TO-DO: complete the if-else statement
							if (accountNumberIsValid)
							{
								//print message to user
								System.out.println("");
								System.out.printf("\nYou're Order is Complete! Thank you!");
								menuChoice = 6;
							}
							else
							{
								//prompt user again; store input in variable userAccountNumber
								System.out.println("");
								System.out.printf("\nI'm sorry, that number is invalid. Please try again: ");
								userAccountNumber = keyboard.nextLine();
							}
						} while (!accountNumberIsValid);
						}
						break;
					
					case 6: //exit
						System.out.println("\nThanks for stopping by! Goodbye!");
						break;
			}
		
		
		} while (menuChoice != 6);	//end main program loop
	}
}