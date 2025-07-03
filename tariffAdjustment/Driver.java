package tariffAdjustment;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;




/*
 This Java program is designed to read international trade data from a text file
 apply tariff increases based on the country and product category, and write the updated trade data to a new file.
 The program leverages ArrayList for dynamic data handling and File I/O operations to read and write data efficiently, making it suitable for processing large datasets with thousands of product records.
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
// Welcoming message to the user.

		System.out.println("\t\t\tWelcome to tariff adjustor.\n\n");
		
		
// Opening scanner for file read.
		
						Scanner read = null;
						
						try
						{
							 read = new Scanner(new File("Required files/TradeData.txt"));
						}
						
						catch (FileNotFoundException fnfex)
						{
							System.out.println("Error! Cannot read file");
							System.exit(0);
						}
						
						catch (IOException ioex)
						{
							System.out.println("Error! IO error occured");
							System.exit(0);
						}
						
// Using ArrayList to store objects of type Product.
						
						ArrayList<Product> products = new ArrayList<Product>(5);
						
						read.useDelimiter(",|\n"); 		// "," and "\n" are used as delimiters.
						

// Reading the file's lines token by token.
						
						System.out.println("Reading from the file and record the data in an ArrayList as a product objects");						
						while(read.hasNextLine())
						{
							String productName = read.next();
							String country = read.next();
							String category = read.next();
							double initialPrice = Double.parseDouble(read.next());
							
							products.add(new Product(productName , country , category , initialPrice));
						}
						
						products.trimToSize();      // Trim size of the array.
						

// Applying tariffs on products
						
						for(int i = 0 ; i < products.size() ; i++)
						{
							products.get(i).applyTariffs();
						}
						
						Collections.sort(products, Comparator.comparing(Product::getProductName));   // Sort product in alphabetical order based in product name.
						
						
					
						PrintWriter write = null;
						
						try
						{
							write = new PrintWriter(new FileOutputStream("UpdatedTradeData.txt"));
							
							for(int i = 0 ; i < products.size() ; i++)
							{
								write.println(products.get(i));
							}
						}
						
						catch (FileNotFoundException fnfex)
						{
							System.out.println("Error! Cannot read file");
							System.exit(0);
						}
						
						catch (IOException ioex)
						{
							System.out.println("Error! IO error occured");
							System.exit(0);
						}
						
						finally
						{
							write.close();
						}
						
// Print the lines in UpdatedTradeData.txt
						
						System.out.println("\nPrint the lines in the output file UpdatedTradeData.txt\n");
						
						Scanner output = null;
						
						try
						{
							output = new Scanner(new File("UpdatedTradeData.txt"));
						}
						
						catch (FileNotFoundException fnfex)
						{
							System.out.println("Error! Cannot read file");
							System.exit(0);
						}
						
						catch (IOException ioex)
						{
							System.out.println("Error! IO error occured");
							System.exit(0);
						}
						
						while(output.hasNextLine())
						{
							System.out.println(output.nextLine());
						}
						
						
// Close scanner.
						
						output.close();
						
						
						
						

						
						
						
						
						
						
						
						
						

						

							
							
							

						
						
			
			
			
			
			
		
		
		
		
		


	}

}
