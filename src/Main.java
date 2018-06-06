
import java.util.*;

// to use handler as CLI app
public class Main {

	public static void main(String[] args) {
		// attributes
		String csv;
		int max = 0;
		int choice = 0;
		int maxHeight = 0;
		int minHeight = 0;
		Handler queryHandler = new Handler();
		csv = queryHandler.getCsv();

		// main loop
		do {		
			// import CSV to ArrayList
			queryHandler.importCSV(csv);

			// ascertain max results
			System.out.println("\nHow many results would you like to return?\n(There are only 601 in total)");
			Scanner takeInput = new Scanner(System.in);
			try{
				max = takeInput.nextInt();
			} catch (InputMismatchException iME) {
				System.out.println("Please enter an integer!");
			}


			// ascertain query
			if (max != 0){
				System.out.print("\nWhat query would you like to perform?\n"
						+ "- Print everything (1)\n"
						+ "- Print only the Munro peaks (2)\n"
						+ "- Print by name (3)\n"
						+ "- Print by height (4)\n" 
						+ "- Print only Munro peaks, sorted by name (5)\n"
						+ "- Print everything above a certain height (6)\n"
						+ "- Print everything below a certain height (7)\n"
						+ "- Exit (8)\n");
				try{
					choice = takeInput.nextInt();
					if (choice > 8) {
						takeInput.close();
						throw new InputMismatchException();
					}
				} catch (InputMismatchException e) {
					System.out.println("Please choose a number between 1 and 6");
				}

				if (choice == 6){
					System.out.println("Enter the minimum height");
					minHeight = takeInput.nextInt();
				}
				if (choice == 7){
					System.out.println("Enter the maximum height");
					maxHeight = takeInput.nextInt();
				}
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
				queryHandler.byName();
				queryHandler.printOutput(max);
				break;
			case (6):
				queryHandler.byMinHeight(minHeight);
				queryHandler.printOutput(max);
				break;
			case (7):
				queryHandler.byMaxHeight(maxHeight);
				queryHandler.printOutput(max);
				break;
			case (8):
				takeInput.close();
				System.exit(0);
				break;
			}

		} while (true);
	}

}
