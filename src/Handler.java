import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Handler {
	
	//attributes
	String csv = "Data/munrotab_v6.2.csv";
	String nextLine;
	String[] columns;
	String output;
	int countLine;
		
	//complex attributes
	ArrayList<Munro> MunroList = new ArrayList<>();
	
	// methods
	// parse CSV, create new ArrayList of Munros
	public void importCSV(String csv) {
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(csv)); 
			while ((nextLine = csvReader.readLine()) != null ) {
				++countLine;
				columns = nextLine.split(",", -1);
				if (countLine > 1 && countLine < 603) { // ignore extraneous first and last rows
					Munro newEntry = new Munro();
					newEntry.setName(columns[6]);
					newEntry.setHeight(Float.valueOf(columns[10])); // cast string to float
					newEntry.setCategory(columns[27]);
					MunroList.add(newEntry);
				}
			}
			csvReader.close();
		}catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	// display all Munros in MonroList
	public void displayMunros() {
		for (Munro theMunro : MunroList) {
			String name = "Name: " + theMunro.getName();
			String height = ". Height(m): " + theMunro.getHeight();
			String category = ". Category: " + theMunro.getCategory();
			output = name + height + category;
			System.out.println(output);
		}
	}

	// get and set methods
	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

}
