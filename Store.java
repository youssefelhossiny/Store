package store;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.Random;

//Works cited
//https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/#:~:text=DecimalFormat(%E2%80%9C0.00%E2%80%9D),round%20to%202%20decimal%20places.
//https://www.javatpoint.com/java-get-current-date

//	Upgrades
// Updated time and date
//lottery discount system
//show trailing zeros (2 decimal places)
//prevent negative or overflow values
//payment method using 4-digit pin
//natural language

public class Store {

	private static final DecimalFormat df = new DecimalFormat("0.00");
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // scanner to input
		
		System.out.println("Hello, Welcome to ElMart");
		System.out.println();
		System.out.println("What is your name?");
		String name = scan.nextLine();
		
		System.out.println();
		System.out.println("Hey "+name+", looking great today, this is what we have to offer:");
		
		System.out.println("Sahlab:             $3");
		System.out.println("Chocolate:          $4");
		System.out.println("Kunafa:             $5");
		System.out.println();
		
		int sahlabPrice = 3;
		int chocolatePrice = 4;
		int kunafaPrice = 5;
		
		int sahlab = 0;
		int chocolate = 0;
		int kunafa = 0;
		
		String chocoType = null;
		String sahlabType = null;
		String kunafaType = null;
		
		String reOrder = "yes"; // Set to yes to enter the while loop at least once
		
		while(reOrder.contains("yes")) 
		{
			System.out.println("What would you like to purchase?");
			String itemReq = scan.next().toLowerCase();

			while(true)
	        {
	            if (itemReq.contains("sahlab")) // if it contains sahlab then it will break the while loop and continue the code
	            {
	                System.out.println("Would you like to add chocolate to your Sahlab?");
	                sahlabType = scan.next().toLowerCase();
	            	
	            	System.out.println("How many Sahlabs do you want to purchase?");
	                sahlab = scan.nextInt();
	            	while(sahlab < 0 || sahlab > 100) // to submit no negative or high numbers
	                {	
	            		System.out.println("Sorry please submit a reasonable quantity between 0 and 100");
		                int sahlabResubmit = scan.nextInt();
		                if(sahlab >= 0 || sahlab <=100) {
		                	sahlab = sahlabResubmit; // sets equal to original variable for math purposes later
		                }
	                }
	                break;
	            }
	            else if (itemReq.contains("chocolate"))
	            {
	                System.out.println("Would you like to buy milk chocolate or dark chocolate");
	                chocoType = scan.next().toLowerCase();
	            	
	            	System.out.println("How many Chocolates do you want to purchase?");
	                chocolate = scan.nextInt();
	                while(chocolate < 0 || chocolate > 100)
	                {
		                System.out.println("Sorry please submit a reasonable quantity between 0 and 100");
		                int chocolateResubmit = scan.nextInt();
		                if(chocolate >= 0 || chocolate <=100) {
		                	chocolate = chocolateResubmit; 
		                }
	                }
	                break;
	            }
	            else if (itemReq.contains("kunafa"))
	            {
	                System.out.println("Would you like syrup on you Kunafa?");
	                kunafaType = scan.next().toLowerCase();
	            	
	            	System.out.println("How many Kunafas do you want to purchase?");
	                kunafa = scan.nextInt();
	                while(kunafa < 0 || kunafa > 100)
	                {
		                System.out.println("Sorry please submit a reasonable quantity between 0 and 100");
		                int kunafaResubmit = scan.nextInt();
		                if(kunafa >= 0 || kunafa <=100) {
		                	kunafa = kunafaResubmit;
		                }
	                }
	                break;
	            }	
				System.out.println("Sorry we do not have this item! Please try again"); // if it doesnt conatain any of items tells you to resubmit your order
				System.out.println("What would you like to purchase?");
				itemReq = scan.nextLine().toLowerCase();
	        }
			System.out.println("Would you like to make another purchase?");
			reOrder = scan.next().toLowerCase(); // if user says yes it will renter while loop and replay code
		}
		
		int numberRand = 1;
		int lottery = 0;
		System.out.println("Would you like to enter a chance to earn 10% off?");
		String discount = scan.next().toLowerCase();
		
		if(discount.contains("yes")) { // if they agree to participate and earn 10% off the
			Random number = new Random();
			numberRand = number.nextInt(21); // Randomizer between 0 to 20
			
			System.out.println("Please guess a whole number between 0 and 20");
			lottery = scan.nextInt(); // enters a number
			
			if(lottery == numberRand) { //  if number is right then they earn 10% off
				System.out.println("Congrats, you have won a 10% discount!");
			}
			else {  // if they guess the number wrong they get nothing
				System.out.println("Sorry you didn't guess the number correct, better luck next time!");
			}
		}
		
		System.out.println();
		System.out.println("***********************************************");
		System.out.println();
		System.out.println("                    ElMart     ");
		System.out.println("               124 Road Street");
		System.out.println("               Ontario 9745963");
		System.out.println("                 777 121 00");
		System.out.println();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Cashier: Youssef");
		System.out.println("-----------------------------------------------");
		
		double sahlabTotal = sahlab * sahlabPrice;
		double chocolateTotal = chocolate * chocolatePrice;
		double kunafaTotal = kunafa * kunafaPrice;
		double subtotal = sahlabTotal + chocolateTotal + kunafaTotal; 
		double total = subtotal *1.13;
		double discountOff = total/10;
		
		
		if (sahlab != 0) 
		{
			if(sahlabType.contains("yes"))
			{
				System.out.println(sahlab + " Sahlab with Chocolate                $"+df.format(sahlabTotal)); // fr.format is to format it to 0.00
			}
			else {
				System.out.println(sahlab + " Sahlab                               $"+df.format(sahlabTotal)); // fr.format is to format it to 0.00
			}
		}
		if (chocolate != 0)
		{
			if(chocoType.contains("milk"))
			{
				System.out.println(chocolate + " Milk Chocolate                       $"+df.format(chocolateTotal)); 
			}
			if(chocoType.contains("dark"))
			{
				System.out.println(chocolate + " Dark Chocolate                       $"+df.format(chocolateTotal)); 
			}
		}
		if (kunafa != 0) 
		{
			if(kunafaType.contains("yes"))
			{
				System.out.println(kunafa + " Kunafa with Syrup                    $"+df.format(kunafaTotal));
			}
			else {
				System.out.println(kunafa + " Kunafa                               $"+df.format(kunafaTotal));
			}
		}
		System.out.println("===============================================");
		System.out.println();
		System.out.println("Subtotal:                              $"+df.format(subtotal));
		System.out.println("HST 13.00%                             $"+df.format(total-subtotal));
		if(lottery == numberRand){ // if they win the lottery discount display the amount saved and the new total
			
			System.out.println("Discount -10.00%                       $"+df.format(discountOff));
			System.out.println("Total:                                 $"+df.format(total - discountOff));
		} // if they didnt win the lottery display the normal total
		if(lottery != numberRand){
			System.out.println("Total:                                 $"+df.format(total));
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("***********************************************");
		
		String payment = null;
		while(payment != "Approved!") // 
		{
			System.out.println("Please enter your 4-digit pin to complete transaction");
			int pin = scan.nextInt();
			System.out.println();
			
			if(pin<=9999 && pin>=1000) // must be 4 digits if its more than 4 or less than four if will say declined
			{
				payment = "Approved!";
				System.out.print(payment);
			}
			
			else 
			{
				System.out.println("Declined, please try again!");
				System.out.println();
			}
		}
		
		System.out.println(" Press any character to print your receipt...");
		String receipt = scan.next();
		System.out.println("***********************************************");
		
		
		System.out.println("===============================================");
		System.out.println();
		System.out.println("                    ElMart     ");
		System.out.println("               124 Road Street");
		System.out.println("               Ontario 9745963");
		System.out.println("                 777 121 00");
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println();
		
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		System.out.print("Date: ");
		System.out.print(date.format(now));
		
		System.out.print("              Time: ");
		System.out.println(time.format(now));
		
		System.out.println();
		System.out.println("Register# 16                  Cashier: Youssef");
		System.out.println();
		System.out.println("-----------------------------------------------");
		
		if (sahlab != 0) 
		{
			if(sahlabType.contains("yes"))
			{
				System.out.println(sahlab + " Sahlab with Chocolate                $"+df.format(sahlabTotal)); // fr.format is to format it to 0.00
			}
			else {
				System.out.println(sahlab + " Sahlab                               $"+df.format(sahlabTotal)); // fr.format is to format it to 0.00
			}
		}
		if (chocolate != 0)
		{
			if(chocoType.contains("milk"))
			{
				System.out.println(chocolate + " Milk Chocolate                       $"+df.format(chocolateTotal)); 
			}
			if(chocoType.contains("dark"))
			{
				System.out.println(chocolate + " Dark Chocolate                       $"+df.format(chocolateTotal)); 
			} 
		}
		if (kunafa != 0) 
		{
			if(kunafaType.contains("yes"))
			{
				System.out.println(kunafa + " Kunafa with Syrup                    $"+df.format(kunafaTotal));
			}
			else {
				System.out.println(kunafa + " Kunafa                               $"+df.format(kunafaTotal));
			}
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Subtotal:                              $"+df.format(subtotal));
		System.out.println("HST 13.00%                             $"+df.format(total-subtotal));
		if(lottery == numberRand){
			
			System.out.println("Discount -10.00%                       $"+df.format(discountOff));
			System.out.println("Total:                                 $"+df.format(total - discountOff));
		}
		if(lottery != numberRand){
			System.out.println("Total:                                 $"+df.format(total));
		}
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("        Thank you for shopping at ElMart!");
		System.out.println("             Come back soon "+name+"!");
		
		System.out.println(" "
				+ "        ______ _ __  __            _   \r\n"
				+ "        |  ____| |  \\/  |          | |  \r\n"
				+ "        | |__  | | \\  / | __ _ _ __| |_ \r\n"
				+ "        |  __| | | |\\/| |/ _` | '__| __|\r\n"
				+ "        | |____| | |  | | (_| | |  | |_ \r\n"
				+ "        |______|_|_|  |_|\\__,_|_|   \\__|\r\n"
				+ "                                 ");
	}
}
