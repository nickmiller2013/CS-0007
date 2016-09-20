import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.text.DecimalFormat;
/** Nick Miller
	CS 0007
	Assignment 4
	4/11/2014*/



public class assignment5
{
	public static void main(String[] args)
	{
	System.out.println("Welcome to the Slot Machine Simulator!");
	System.out.println("");
			double x = 0, i = 0;
			while(x == 0){
			double choice;
			double PlayAgain;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Actions:");
			System.out.println("1. Start a new game");
			System.out.println("2. View Scores");
			System.out.println("3. Exit");
			System.out.println("");
			System.out.println("Please select an action: ");
			choice = keyboard.nextDouble();
			
			System.out.println("");
			
			keyboard.nextLine();
			if(choice == 1){// Plays the slots 
				slots();
				i++;
			} else if(choice == 2){
			if(i == 1){// Loads the scores.txt file
				System.out.println("Name      Score");
				System.out.println("---------------");
				try{
				Load();
				}catch(IOException e){
				e.printStackTrace();
				}
				}
			else if(i == 0){// If there have been no slots run, then no high scores is displayed
				System.out.println("");
				System.out.println("There are no scores to display at this time!");
				}
			}else if(choice == 3){// Lose is the exit
				Lose();
				x = 1;
			}else{
				System.out.println("");
				System.out.println("Wrong Choice");
			}
			}
		}
	public static String Name()
	{
		String name; 
		Scanner keyboard = new Scanner(System.in);
		System.out.println("");
		System.out.println("Before the game begins, please enter you're name: ");
		name = keyboard.nextLine();
		System.out.println("");
		return name;
	}	
	public static void Load() throws IOException
	{
		File file = new File("Scores.txt");
		Scanner inputFile = new Scanner(file);
		while(inputFile.hasNext()){
		String info = inputFile.nextLine();
		System.out.println(info);
		}
		inputFile.close();
	}
	public static void Lose()
	{
		System.out.println("");
		System.out.println("Goodbye!");
	}
	public static void slots()
    {
		DecimalFormat formatter = new DecimalFormat("##,##0.00");
		String name;
		name = Name();
        // Creating a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Declare my variables as INTs
        int won = 0, bet = 0, totalBet = 0, totalWon = 0, counter = 0;
        double start = 100;
        // Declare my slots as INTs
        int num1, num2, num3;
        
      
        
        // Ask user how much they'd like to bet.
		System.out.println("Game start! You will begin with $100.00. Enter a negative 1 to quit the game.");
		System.out.println("Good luck, " + name + "!");
		System.out.println("");
		System.out.println("You currently have: $100.00");
        System.out.println("How much would you like to bet?");
        bet = input.nextInt();
        
 
        // While  loop
        while (bet != -1 && start > 0)
        {
            totalBet += bet;
            totalWon += won; 
        
        // Create Random objct
        Random randomNumbers = new Random();
        input.nextLine();                                                                                      
		num1 = 1 + randomNumbers.nextInt(5);
		num2 = 1 + randomNumbers.nextInt(5);
		num3 = 1 + randomNumbers.nextInt(5);
	if(start >= bet){
		fruit(num1, num2, num3);
        // If statement to decide if they won
        if ((num1 != num2 && (num1 != num3) && (num2 != num3)))
            {
		  System.out.println("");
          System.out.println("Number of matches: 0. You win: $0.00");
		  start = start - bet;
		  System.out.println("You currently have: " + formatter.format(start));
            }   
        else if (num1 == num2 && num1 == num3)
            {
            won = bet * 3;
			System.out.println("");
			System.out.println("Number of matches: 3. You win $" + won);
			start = start + won;
			System.out.println("You currently have: $" + formatter.format(start));
            }
        else
            {
			System.out.println("");
			won = bet * 2;
            System.out.println("Number of matches: 2. You win: $" + (won));
			start = start + won;
			System.out.println("You currently have: $" + formatter.format(start));
            }       
        }
		else 
		{
		System.out.println("");
		System.out.println("You're bet is greater than you're current total.");
		System.out.println("Please enter a valid amount");
		System.out.println("");
		}


        // Ask user how much they'd like to bet.
		if(start > 0){
		System.out.println("");
        System.out.println("How much would you like to bet? Bet -1 if you wish to walk away.");
        bet = input.nextInt();
		System.out.println();
        }
        }
         
        //Display total
		System.out.println("Game over! You're score has been written to scores.txt, " + name);
		System.out.println("");
		try{
		Save(name, start);
		}catch(IOException e){
		e.printStackTrace();
		}
        
    }
	public static void fruit(int num1, int num2, int num3)
	{	
	System.out.println("-----------------------------------------------");
	String vars1 = "";
	String vars2 = "";
	String vars3 = "";
		if(num1 == 1){
		vars1 = "cherries";
		} else if(num1 == 2){
		vars1 = "Oranges";
		} else if(num1 == 3){
		vars1 = "Plums";
		} else if(num1 == 4){
		vars1 = "Bells";
		} else if(num1 == 5){
		vars1 = "Melons";
		} else if(num1 == 6){
		vars1 = "Bars";
		}
		if(num2 == 1){
		vars2 = "cherries";
		} else if(num2 == 2){
		vars2 = "Oranges";
		} else if(num2 == 3){
		vars2 = "Plums";
		} else if(num2 == 4){
		vars2 = "Bells";
		} else if(num2 == 5){
		vars2 = "Melons";
		} else if(num2 == 6){
		vars2 = "Bars";
		}
		if(num3 == 1){
		vars3 = "cherries";
		} else if(num3 == 2){
		vars3 = "Oranges";
		} else if(num3 == 3){
		vars3 = "Plums";
		} else if(num3 == 4){
		vars3 = "Bells";
		} else if(num3 == 5){
		vars3 = "Melons";
		} else if(num3 == 6){
		vars3 = "Bars";
		}
		System.out.println(vars1 + "         " + vars2 + "         " + vars3);              
		System.out.println("-----------------------------------------------");
			}
		public static void Save(String name, double start)throws IOException
		{
		FileWriter fwriter = new FileWriter("Scores.txt", true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		outputFile.println(name + "      " + start);
		outputFile.close(); 
		}
}