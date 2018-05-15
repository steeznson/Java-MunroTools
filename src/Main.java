
public class Main {

	public static void main(String[] args) {
		// attributes
		String csv;
		Handler queryHandler = new Handler();
		
		// instructions
		csv = queryHandler.getCsv();
		queryHandler.importCSV(csv);
		queryHandler.byName();
		queryHandler.filterHills();
		queryHandler.printOutput();
	}

}
