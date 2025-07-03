package tariff_management_system;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
 This Java program simulates and manages international trade scenarios affected by tariffs between countries.
 It reads tariff policies from Tariffs.txt and trade requests from TradeRequests.txt,
 then processes each trade request based on predefined rules, determining whether the request is accepted, conditionally accepted (with a surcharge), or rejected
 The system uses custom linked list structures (TariffList) to store and manage tariff records efficiently, and employs file I/O and ArrayList to handle trade request processing.
 
 This system ensures efficient handling of trade-related data and simulates real-world tariff application policies, offering insights into trade decisions based on configurable input datasets
 
 */
public class TradeManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("a) Create two empty lists (tariffList1 and tariffList2)\n");
		
		TariffList list1 = new TariffList();
		TariffList list2 = new TariffList(list1);
		
		System.out.println("b) Read the Tariff.txt and record the tariffs in one of the above list\n");
		
		System.out.println("\tReading file in progress....\n");
		
// Opening scanner for file read.
		
		Scanner keyboard = new Scanner(System.in);
		
//		System.out.print("Please enter the file: ");
//		String file = keyboard.next();
		
		Scanner read = null;
		
		try
		{
			read = new Scanner(new File("Required files/Tariffs.txt"));
		}
		
		catch(FileNotFoundException fnfex)
		{
			System.out.println("Error. Cannot read file");
			System.exit(0);
		}
		
		catch(IOException ioex)
		{
			System.out.println("IO error occured. Cannot open file");
			System.exit(0);
		}
	
		
// Record tariff regulation in one of the lists. Duplicates are not allowed.
		
		while(read.hasNextLine())
		{
			String destination = read.next();
			String origin = read.next();
			String category = read.next();
			double minimumTariff = read.nextDouble();
			
			Tariff newTariff = new Tariff(destination , origin , category , minimumTariff);
			
			if(list1.contains(destination, origin, category) == true)
			{
				continue;
			}
			
			else
			{
				list1.addToStart(newTariff);
			}
		}
		
		System.out.println("\tFile read successfully\n");
		
// Closing scanner.
		
		read.close();
		
// Display content of list1.
		
		System.out.println("Displaying the content of list1\n");

		list1.display();
		System.out.println("\n\n");

// Opening a Scanner to read file.
		
		System.out.println("c) Open TradeRequests.txt and create an arrayList out of the requests\n");
		
		Scanner read2 = null;
		
		try
		{
			read2 = new Scanner(new File("Required files/TradeRequests.txt"));
		}
		
		catch(FileNotFoundException fnfex)
		{
			System.out.println("Error. Cannot read file");
			System.exit(0);
		}
		
		catch(IOException ioex)
		{
			System.out.println("IO error occured. Cannot open file");
			System.exit(0);
		}

// Store trade requests in an ArrayList.
		
		System.out.println("\tInserting trade requests inside an ArrayList\n");
		
		ArrayList<TradeRequested> tradeRequests = new ArrayList <TradeRequested>(4);
		
		while(read2.hasNextLine())
		{
			String request = read2.next();
			String destination = read2.next();
			String origin = read2.next();
			String category = read2.next();
			double tradeValue = read2.nextDouble();
			double proposedTariff = read2.nextDouble();
			
			tradeRequests.add(new TradeRequested(request , destination , origin , category , tradeValue , proposedTariff));
		}
		
		System.out.println("\tTrade requests stored successfully\n");
		System.out.println("\tProcess requests and Print their outcome\n");
		
// Process trade requests and print their outcomes.

		
		for(int i = 0 ; i < tradeRequests.size() ; i++)
		{
			if(list1.contains(tradeRequests.get(i).getDestinationCountry(), tradeRequests.get(i).getOriginCountry(), tradeRequests.get(i).getProductCategory()) == false )
			{
				System.out.println(tradeRequests.get(i).getRequest() + " -  Tariff regulation does not exist on this item\n");
			}
			
			else
			{
				Tariff tariff = new Tariff(list1.find(tradeRequests.get(i).getDestinationCountry(), tradeRequests.get(i).getOriginCountry(), tradeRequests.get(i).getProductCategory()));
				
				String evaluation = list1.evaluateTrade(tradeRequests.get(i).getProposedTariff() , tariff.minimumTariff);
				
				if(evaluation.equals("Accepted"))
				{
					System.out.println(tradeRequests.get(i).getRequest() + " - Accepted.");
					System.out.println("Proposed tariff meets or exceeds the minimum requirement.\n");
				}
				
				else
					if(evaluation.equals("Conditionally Accepted"))
					{
						double surcharge = tradeRequests.get(i).getTradeValue() * ((tariff.getMinimumTariff() - tradeRequests.get(i).proposedTariff) / 100);
						System.out.println(tradeRequests.get(i).getRequest() + " - Conditionally Accepted.");
						System.out.println("Proposed tariff " + tradeRequests.get(i).getProposedTariff() + " % is within 20% of the required minimum tariff " + tariff.getMinimumTariff() + "%");
						System.out.println("A surcharge of $" + surcharge + " is applied.\n" );
					}
					else
					{
						System.out.println(tradeRequests.get(i).getRequest() + " - Rejected.");
						System.out.println("Proposed tariff " + tradeRequests.get(i).getProposedTariff() + "% is more than 20% below the required minimum tariff " + tariff.getMinimumTariff() + "%\n");
					}
			}
		}
		
		
// Prompt the user to use list methods.
//Open scanner so that the user could enter values
		
		
		
		boolean quit =  false ;
		do
		{
			System.out.println("What would you like to do? ");
			System.out.println("1) Add new tariff regulation from start.");
			System.out.println("2) Add new tariff regulation at specified index.");
			System.out.println("3) Delete tariff regulation from the start");
			System.out.println("4) Delete tariff regulation by a specified index");
			System.out.println("5) Find a specified tariff regulation");
			System.out.println("6) See if the list contains a specified tariff regulation");
			System.out.println("7) Get the size of the list");
			System.out.println("8) Display all tariff");
			System.out.println("9) Replace a tariff regulation at a specified index");
			System.out.println("10)Exit\n");
			
			System.out.print("Please enter a value: ");
			
			int value = keyboard.nextInt();
			
			System.out.println("\n");
			
			if(value < 1 || value > 10)
			{
				System.out.println("Incorrect input, please try again\n\n");
			}
			
			
// Enter tariff regulation from the start.
			
			if(value == 1)
			{
				System.out.println("Enter the following informations");
				
				System.out.print("Destination country: ");
				String destination = keyboard.next();
				
				System.out.print("Origin country: ");
				String origin = keyboard.next();
				
				System.out.print("Product category: ");
				String category = keyboard.next();
				
				System.out.print("Minimum Tariff: ");
				double tariff = keyboard.nextDouble();
				
				list1.addToStart(new Tariff(destination , origin , category , tariff));
				
				System.out.println("\n\nTariff regulation added successfully");
			}

			
// Enter tariff regulation at a specified index (index must be valid or an exception is thrown).
			
				if(value == 2)
			{
				System.out.print("Enter index where you would like to add the tariff regulation (be carefull!!! valid index is between 0 and " + (list1.getSize() - 1) + "): ");
				int index = keyboard.nextInt();
				
				System.out.println("Enter the following informations");
				
				System.out.print("Destination country: ");
				String destination = keyboard.next();
				
				System.out.print("Origin country: ");
				String origin = keyboard.next();
				
				System.out.print("Product category: ");
				String category = keyboard.next();
				
				System.out.print("Minimum Tariff: ");
				double tariff = keyboard.nextDouble();
				
				try
				{
					list1.insertAtIndex(new Tariff(destination , origin , category , tariff) , index);
				}
				
				catch(NoSuchElementException nseex)
				{
					System.out.println(nseex.getMessage());
				}
			}

// Delete a tariff regulation from the start.
				
			if(value == 3)
			{
				list1.deleteFromStart();
				System.out.println("Tariff regulation deleted successfully from the start");
				System.out.println();
			}

			
// Delete tariff regulation at a specified index (index must be valid or an exception is thrown).
			
			if(value == 4)
			{
				System.out.print("Enter index where you would like to delete the tariff regulation (be carefull!!! valid index is between 0 and " + (list1.getSize() - 1) + "): ");
				int index = keyboard.nextInt();
				
				list1.deleteFromIndex(index);
				
				System.out.println("Tariff regulation deleted successfully from index " + index + "\n");
			}

			
// Check if a tariff regulation does exist in the list.
			
			if(value == 5)
			{
				System.out.println("Enter the following informations");
				
				System.out.print("Destination country: ");
				String destination = keyboard.next();
				
				System.out.print("Origin country: ");
				String origin = keyboard.next();
				
				System.out.print("Product category: ");
				String category = keyboard.next();
				
				boolean contains = list1.contains(destination, origin, category);
				
				if(contains == true)
				{
					System.out.println("\nTariff regulation found\n");
					System.out.println(list1.find(destination, origin, category));
				}
				
				else
				{
					System.out.println("\nTariff regulation not found\n");
				}
			}
		
			
// Find a tariff regulation that matches the passed attributes and display it.
			
			if(value == 6)
			{
				System.out.println("Enter the following informations");
				
				System.out.print("Destination country: ");
				String destination = keyboard.next();
				
				System.out.print("Origin country: ");
				String origin = keyboard.next();
				
				System.out.print("Product category: ");
				String category = keyboard.next();
				
				
				
				boolean contains = list1.contains(destination, origin, category);
				
				if(contains == true)
				{
					System.out.println("\nThe list contains a tariff regulation with the passed attributes\n");
				}
				
				else
				{
					System.out.println("\nThe list does not contains a tariff regulation with the passed attributes\n");
				}
			}
			
			
			
// Print how many tariff regulations does the list have.
			
			if(value == 7)
			{
				System.out.println("The list contains " + list1.getSize() + " tariff regulations\n ");
			}

// Display all tariff regulations
			
			if(value == 8 )
			{
				list1.display();
			}
			
// Replace a tariff regulation at a specified index.
		
			
			if(value == 9)
			{
				System.out.print("Enter index where you would like to replace the tariff regulation (be carefull!!! valid index is between 0 and " + (list1.getSize() - 1) + "): ");
				int index = keyboard.nextInt();
				
				System.out.println("Enter the following informations");
				
				System.out.print("Destination country: ");
				String destination = keyboard.next();
				
				System.out.print("Origin country: ");
				String origin = keyboard.next();
				
				System.out.print("Product category: ");
				String category = keyboard.next();
				
				System.out.print("Minimum Tariff: ");
				double tariff = keyboard.nextDouble();
				
				list1.replaceAtIndex(new Tariff(destination , origin , category , tariff), index);
				System.out.println();
				
			}
			
// Exit program
			
			if(value == 10 )
			{
				quit = true;
			}
			
			
		}while(!quit);
		
		keyboard.close();
		
		
		
// Test other methods and constructors
		
		System.out.println("\n\ne) Test other methods and constructors\n\n");
		
		System.out.println("1-clone methods\n");
		
		Tariff test = new Tariff("USA" , "China" , "tech" , 30);
		
		System.out.println("Display the tariff then test clone\n");
		System.out.println(test);
		
		Tariff clone = test.clone();
		
		System.out.println("Now display the clone\n");
		System.out.println(clone);
		
		
// Test copy constructor of the TariffList class
		
		System.out.println("\n\nTest of copy constructor of Tariff List\n");
		
		TariffList listTest = new TariffList(list1);
		
		listTest.display();
		
// Test clone method of the TariffList class.
		
		System.out.println("\n\nTest clone method on TariffList\n");
		
		TariffList cloneList = listTest.clone();
		
		System.out.println("Display the cloned list\n\n");
		
		cloneList.display();
		
		
	
		

	}

}
