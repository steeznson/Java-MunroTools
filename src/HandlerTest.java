
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class HandlerTest {
	
	@Test
	public void testImportCSV() {
		Handler handle = new Handler();
		String csv = "Data/munrotab_v6.2.csv";
		handle.importCSV(csv);
		// CSV contains 601 entries
		assertEquals(handle.MunroList.size(), 601);
	}

	@Test
	public void testPrintOutput() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

		Handler handle = new Handler();
		Munro theMunro = new Munro();
		
		theMunro.setName("Nash");
		theMunro.setHeight(900);
		theMunro.setCategory("MUN");
		handle.MunroList.add(theMunro);
		handle.printOutput(1);
		
		String expectedOutput = "Nash\t900.0\tMUN";
		assertTrue(outContent.toString().contains(expectedOutput));
	}

	@Test
	public void testByName() {
		Handler handle = new Handler();
		Munro thisMunro = new Munro();
		Munro thatMunro = new Munro();
		Munro altMunro = new Munro();
		
		thisMunro.setName("Freddie");
		thatMunro.setName("Sly");
		altMunro.setName("Cynthia");
		
		handle.MunroList.add(thisMunro);
		handle.MunroList.add(thatMunro);
		handle.MunroList.add(altMunro);
		handle.byName();
		
		// "Sly" should be the last of the three in the ArrayList
		assertEquals(handle.MunroList.indexOf(thatMunro), 2);
	}

	@Test
	public void testByHeight() {
		Handler handle = new Handler();
		Munro thisMunro = new Munro();
		Munro thatMunro = new Munro();
		Munro altMunro = new Munro();
		
		thisMunro.setHeight(1400);
		thatMunro.setHeight(950);
		altMunro.setHeight(1000);
		handle.byHeight();
		
		// highest Munro should come last
		assertEquals(handle.MunroList.indexOf(thisMunro), -1);
	}

	@Test
	public void testByMinHeight() {
		Handler handle = new Handler();
		Munro thisMunro = new Munro();
		Munro thatMunro = new Munro();
		Munro altMunro = new Munro();
		Munro disqualifiedMunro = new Munro();
		
		thisMunro.setHeight(1400);
		thatMunro.setHeight(950);
		altMunro.setHeight(1000);
		disqualifiedMunro.setHeight(600);
		handle.byMinHeight(800);
		
		assertFalse(handle.MunroList.contains(disqualifiedMunro));
	}

	@Test
	public void testByMaxHeight() {
		Handler handle = new Handler();
		Munro thisMunro = new Munro();
		Munro thatMunro = new Munro();
		Munro altMunro = new Munro();
		Munro disqualifiedMunro = new Munro();
		
		thisMunro.setHeight(1400);
		thatMunro.setHeight(950);
		altMunro.setHeight(1000);
		disqualifiedMunro.setHeight(1600);
		handle.byMaxHeight(1500);
		
		assertFalse(handle.MunroList.contains(disqualifiedMunro));
	}

	@Test
	public void testFilterHills() {
		Handler handle = new Handler();
		Munro thisMunro = new Munro();
		Munro thatMunro = new Munro();
		Munro disqualifiedMunro = new Munro();
		
		thisMunro.setCategory("MUN");
		thatMunro.setCategory("MUN");
		disqualifiedMunro.setCategory("TOP");
		
		assertFalse(handle.MunroList.contains(disqualifiedMunro));
	}

	@Test
	public void testGetCsv() {
		Handler handle = new Handler();
		handle.setCsv("Crosby");
		assertTrue(handle.getCsv().equals("Crosby"));
	}

	@Test
	public void testSetCsv() {
		Handler handle = new Handler();
		handle.setCsv("Stills");
		assertTrue(handle.getCsv().equals("Stills"));
	}

}
