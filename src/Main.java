import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// attributes
		String csv;
		int max = 0;
		int choice = 0;
		Handler queryHandler = new Handler();
		csv = queryHandler.getCsv();
				
		// import CSV to ArrayList
		queryHandler.importCSV(csv);
		
		// ascertain max results
		System.out.println("Hello, how many results would you like to return? ");
		Scanner takeInput = new Scanner(System.in);
		try{
			max = takeInput.nextInt();
		} catch (InputMismatchException iME) {
			takeInput.close();
			System.out.println("Please choose an integer!");
			System.exit(0); // should change this to allow user to try again
		}
		
		// ascertain query
		System.out.print("What query would you like to perform?\n"
				+ "Print everything (1)\n" + "Print everything except hills (2)\n"
				+ "Print by name (3)\n" + "Print by height (4)\n" + 
				"Filter hills, sort by name and then by height (5)\n" 
				+ "Exit (6)\n");
		try{
			choice = takeInput.nextInt();
			if (choice > 6) {
				takeInput.close();
				throw new InputMismatchException();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please choose a number between 1 and 5");
		}
		
		// execute query, print results
		switch (choice) {
			case (0):
				break;
			case (1):
				queryHandler.printOutput(max);
				break;
			case (2):
				queryHandler.filterHills();
				queryHandler.printOutput(max);
				break;
			case (3):
				queryHandler.byName();
				queryHandler.printOutput(max);
				break;
			case (4):
				queryHandler.byHeight();
				queryHandler.printOutput(max);
				break;
			case (5):
				queryHandler.filterHills();
				queryHandler.byHeight();
				queryHandler.byName();
				queryHandler.printOutput(max);
			case (6):
				break;
		}
		
		// close scanner
		takeInput.close();
	}

}
