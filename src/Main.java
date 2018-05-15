
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// attributes
		String csv;
		Handler queryHandler = new Handler();
		
		csv = queryHandler.getCsv();
		queryHandler.importCSV(csv);
		
		queryHandler.displayMunros();
	}

}
