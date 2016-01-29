import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int whetherCustomers;
		for ( int customers = 1; ;customers++) {

			int option;
			int currentAmountOfBook;
			int numBook = 0;
			int currentAmountOfBookmark = 0;
			int currentAmountOfPainting = 0;
			int numPainting = 0;
			int numBookmark = 0;
			int numBookmarkPack = 0;
			int numBookmarkRest = 0; // This number indicates the number of bookmarks after packing in the pack.
			double moneyBook;
			double moneyBookmarkPack;
			double moneyBookmarkRest;
			double moneyPainting;
			double moneyTotal;  // the total money without tax.
			double tax;
			double total; //the total money which the customer need to pay.
			double customerPaid; // the amount which the customer paid without receiving the change.
			double change;
			double saved;
			
			System.out.println("More customers in line? (1 = YES, 2 = NO) :");
			sc = new Scanner(System.in);
			whetherCustomers = sc.nextInt(); 
			// This value means if there has customers in the waiting list.
			if ( whetherCustomers == 2){
				System.out.println("No more customers! Closing!");
				break;
			}
				
				do {
					
					
					System.out.print("1 - Buy Books - $5.00 each\n"
						+ "2 - Buy Bookmarks - $1.00 each, $5.00 for a six-pack\n"
						+ "3 - Buy Pantings of Books - $100.00 each\n"
						+ "4 - See current order\n"
						+ "5 - Checkout\n"
						+ "Please enter a valid option: ( 1 through 5 ) > ");
					option = sc.nextInt();// This value shows which option the customer choose.
					
					if (option == 1){
						System.out.println("Currently in cart: "+ numBook +" books.\n"
											+"How many do you want to buy? >");
						
						currentAmountOfBook = sc.nextInt();
						//It shows how many book the customer want to buy for this time.
						while (currentAmountOfBook < 0){
							System.out.println("Please enter a valid number of books: ");
							currentAmountOfBook = sc.nextInt();
						}
						numBook += currentAmountOfBook;
					}
					
					if (option == 2){
						System.out.println("Currently in cart: " + numBookmark + " bookmarks.\n"
								+ "How many do you want to buy? >");
						
						currentAmountOfBookmark = sc.nextInt();
						//It shows how many book the customer want to buy for this time.
						while (currentAmountOfBookmark < 0){
							System.out.print("Please enter a valid number of bookmarks: ");
							currentAmountOfBookmark = sc.nextInt();
						}
						numBookmark += currentAmountOfBookmark;
						numBookmarkPack = numBookmark/6;
						numBookmarkRest = numBookmark%6;
					}
					
					if (option == 3){
						System.out.println("Currently in cart: " + numPainting + " Paintings.\n"
								+ "How many do you want to buy? >");
						
						currentAmountOfPainting = sc.nextInt();
						//It shows how many paintings the customer want to buy this time.
						while (currentAmountOfPainting < 0){
							System.out.println("Please enter a valid number of paintings: ");
							currentAmountOfPainting = sc.nextInt();
						}
						numPainting += currentAmountOfPainting;
					}
					
					if (option == 4){
						System.out.println("Currently in cart: \n"
								+ "Books: "+ numBook +"\n" 
								+ "Bookmarks: " + numBookmark + "\n"
								+ "Paintings of books: " + numPainting );
						}
					
					if (option == 5){
					System.out.println("-----------------------------------------");
					
						moneyBook = 5*numBook;
						moneyBookmarkPack = 5*numBookmarkPack; 
						moneyBookmarkRest = numBookmarkRest;
						moneyPainting = numPainting*100;
						moneyTotal = moneyBook + moneyBookmarkPack + moneyBookmarkRest + moneyPainting; 
						tax = moneyTotal*0.07;
						total = moneyTotal + tax;
						saved = (0-moneyTotal)*0.1;
						if (customers % 3 != 0){
						
						
						System.out.printf("You didn't get a discount ! Better luck next time !\n " 
								+ numBook + " Book(s):			 $%.2f"  + "\n " 
								+ numBookmarkPack + " Bookmark Pack(s):		 $%.2f" + "\n " 
								+ numBookmarkRest + " Single Bookmark(s):		 $%.2f" +"\n " 
								+ numPainting + " Painting(s):			 $%.2f\n" + "\n\n"
								+ " Subtotal:		 	 $%.2f\n"
								+ " Tax:				 $%.2f\n\n"
								+ " Total:				 $%.2f\n\n\n"
								+ "-----------------------------------------\n\n\n"
								, moneyBook, moneyBookmarkPack, moneyBookmarkRest, moneyPainting, moneyTotal, tax, total);
						
						System.out.print("Enter amount paid (no dollar sign) > " );
						customerPaid = sc.nextDouble();
						change = customerPaid - total;
						
						System.out.printf("\n\nYour change is $%.2f\nThanks for shopping !!\n\n",change);
						}
						if ( customers % 3 == 0){
							System.out.println("Congratulations ! You won a 10% discount !");
							
							System.out.printf("You didn't get a discount ! Better luck next time !\n" 
									+ numBook + " Book(s):			 $%.2f"  + "\n" 
									+ numBookmarkPack + " Bookmark Pack(s):		 $%.2f" + "\n" 
									+ numBookmarkRest + " Single Bookmark(s):		 $%.2f" +"\n" 
									+ numPainting + " Painting(s):			 $%.2f\n" + "\n"
									+ " Discount! Saved :		 $%.2f\n"
									+ " Subtotal:		 	 $%.2f\n"
									+ " Tax:				 $%.2f\n\n"
									+ " Total:				 $%.2f\n\n\n"
									+ "-----------------------------------------\n\n\n"
									,moneyBook*(0.9), moneyBookmarkPack*(0.9), moneyBookmarkRest*(0.9), 
									moneyPainting*(0.9),saved, moneyTotal*(0.9), tax*(0.9), total*(0.9));
							
							System.out.print("Enter amount paid (no dollar sign) > " );
							customerPaid = sc.nextDouble();
							change = customerPaid - total*(0.9);

							System.out.printf("\n\nYour change is $%.2f\nThanks for shopping !!\n\n",change);
							}
						break;
					} //Here is the end of the option was equal to 5.
					else{
						for ( ; (option != 1)&&(option != 2)&&(option != 3)&&(option != 4)&&(option != 5) ;){
						System.out.print("Please enter a valid option: ( 1 through 5 ) > ");
						option = sc.nextInt();
						}
					}
				}while( whetherCustomers == 1);
				
		
		}
	}
}


