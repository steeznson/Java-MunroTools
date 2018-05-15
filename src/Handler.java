import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Handler {
	
	//attributes
	String csv = "Data/munrotab_v6.2.csv";
	String nextLine;
	String[] columns;
		
	//complex attributes
	ArrayList<Munro> MunroList = new ArrayList<Munro>();
	
	// methods
	public void importCSV(String csv) {
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(csv)); 
			while ((nextLine = csvReader.readLine()) != null ) {
				columns = nextLine.split(",", -1);
				Munro newEntry = new Munro();
				newEntry.setName(columns[6]);
				newEntry.setHeight(Float.valueOf(columns[10])); // cast string to float
				newEntry.setCategory(columns[27]);
				MunroList.add(newEntry);
			}
			csvReader.close();
		}catch ( Exception e) {
			e.printStackTrace();
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
