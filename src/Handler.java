
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Handler {

	//attributes
	String csv = "Data/munrotab_v6.2.csv";
	String nextLine;
	String[] columns;
	String output;
	int countLine;
	int maxHeight;
	int minHeight;

	//complex attributes
	List<Munro> MunroList = new ArrayList<Munro>();
	
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

	// print output for MunroList
	public void printOutput(int max) {
		int i = 0;
		for (Munro theMunro : MunroList) {
			if (i < max) {
				String name = theMunro.getName();
				String height = "\t" + theMunro.getHeight();
				String category = "\t" + theMunro.getCategory();
				output = name + height + category;
				System.out.println(output);
				++i;
			}
		}
	}

	// order by name
	public void byName() {
		Collections.sort(MunroList, (thisMunro,thatMunro) -> thisMunro.getName().compareToIgnoreCase(thatMunro.getName()));
	}

	// order by height
	public void byHeight() {
		Collections.sort(MunroList, (thisMunro,thatMunro) -> thisMunro.getHeight() > thatMunro.getHeight() ? 1 :
			thisMunro.getHeight() < thatMunro.getHeight() ? -1 : 0);
	}

	// order by minimum height
	public void byMinHeight(int minHeight) {
		MunroList = MunroList.stream().filter(theMunro -> theMunro.getHeight() >= minHeight).collect(Collectors.toList());
	}

	// order by maximum height
	public void byMaxHeight(int maxHeight) {
		MunroList = MunroList.stream().filter(theMunro -> theMunro.getHeight() <= maxHeight).collect(Collectors.toList());
	}

	// filter search by hill
	public void filterHills() {
		MunroList = MunroList.stream().filter(theMunro -> theMunro.getCategory().equals("MUN")).collect(Collectors.toList());
	}

	// get and set
	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

}
