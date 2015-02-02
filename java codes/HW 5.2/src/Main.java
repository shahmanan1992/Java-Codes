/* 
 * Main.java 
 * 
 * Version: 
 *     1 
 */
import java.io.*;

/**
 * This program helps the customer in buying items and performing different
 * operations like adding to cart,taking another bag ,calculating the total cost
 * and printing the receipt. Note: The customer cannot buy more than 100 items.
 * 
 * @author      Manan Shah     605004112	
 * @author      Vinay Kumbhar  613009443
 */

public class Main
{
	/**
	 * The main program.
	 *
	 * @param    args    
	 */
	public static void main(String args[])throws IOException
	{

		String buy="yes",bch="no";
		int n=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		//Creating objects of different classes to use their functionality
		Customer cust= new Customer();
		Cashier cashier=new Cashier();
		int quantity[]=new int[5];
		
		//Loop which runs till the customer wants to shop.
		while(buy.equalsIgnoreCase("yes"))
		{
			System.out.println("MENU");
			System.out.println("1.Apples");
			System.out.println("2.Flour");
			System.out.println("3.Kiwis");
			System.out.println("4.Oranges");
			System.out.println("5.Milk");
			System.out.println("Enter the item no. you want");
			n=Integer.parseInt(br.readLine());
			System.out.println("Enter the quantity");
			int i=Integer.parseInt(br.readLine());
			
				//Adds the items to cart and checks if total items are less than 100
				cust.addToCart(quantity,n-1,i);
            
				if(cust.getNoOfItems()==100)
				{
					break;
				}
			//Checks if the customer wants to buy more items
			System.out.println("Want to buy more items? YES or NO");
			buy=br.readLine();

		} 
		cust.setOrder(quantity);
		System.out.println("Do you want to put these items in a bag? YES or NO");
		bch=br.readLine();
		String name[]=cashier.getName();

		//Checks if the user needs more bags
		if(bch.equalsIgnoreCase("yes"))
		{
			System.out.println("Enter the item no. you want to put in bag");
			int i=Integer.parseInt(br.readLine());
			//Adds the item to bag
			cust.addToBag(name[i-1], i-1,quantity);
		}
        System.out.println("Total no. of items=" + cust.getNoOfItems());
		System.out.println("Processing your bill");
		
		//Processing and printing the bill
		double totalCost[]=cashier.getTotalCost(cust.getOrder(), cashier.getPrice());
		cashier.printReciept(totalCost,cashier.getName(),cashier.getPrice());
	}
}
