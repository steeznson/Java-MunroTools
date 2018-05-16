
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
	ArrayList<Munro> MunroList = new ArrayList<>();
	List<Munro> MinHeightMunroList = new ArrayList<>();
	List<Munro> MaxHeightMunroList = new ArrayList<>();

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
		MinHeightMunroList = MunroList.stream().filter(theMunro -> theMunro.getHeight() > minHeight).collect(Collectors.toList());
		MunroList.clear();
		for (Munro theMunro : MinHeightMunroList) {
			MunroList.add(theMunro);
		}
	}

	// order by maximum height
	public void byMaxHeight(int maxHeight) {
		MaxHeightMunroList = MunroList.stream().filter(theMunro -> theMunro.getHeight() < maxHeight).collect(Collectors.toList());
		MunroList.clear();
		for (Munro theMunro : MaxHeightMunroList) {
			MunroList.add(theMunro);
		}
	}

	// filter search by hill
	public void filterHills() {
		Iterator<Munro> iterate = MunroList.iterator();
		while (iterate.hasNext()) {
			Munro theMunro = iterate.next();
			if (theMunro.getCategory().equals("TOP") || theMunro.getCategory().equals("")) {
				iterate.remove();
			}
		}
	}

	// get and set
	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

}
