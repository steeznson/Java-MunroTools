
// To use handler as a library
public interface HandlerInterface {
	
	public String query(String csv, boolean alphabetical, boolean ascending, boolean onlyPeaks, int numResults, int minHeight, int maxHeight);
}
