import static org.junit.Assert.*;

import org.junit.Test;

public class MunroTest {

	@Test
	public void testGetName() {
		Munro theMunro = new Munro();
		theMunro.setName("Ringo");
		assertTrue(theMunro.getName().equals("Ringo"));
	}

	@Test
	public void testSetName() {
		Munro theMunro = new Munro();
		theMunro.setName("Paul");
		assertTrue(theMunro.getName().equals("Paul"));
	}

	@Test
	public void testGetCategory() {
		Munro theMunro = new Munro();
		theMunro.setCategory("John");
		assertTrue(theMunro.getCategory().equals("John"));
	}

	@Test
	public void testSetCategory() {
		Munro theMunro = new Munro();
		theMunro.setCategory("George");
		assertTrue(theMunro.getCategory().equals("George"));
	}

	@Test
	public void testGetHeight() {
		Munro theMunro = new Munro();
		theMunro.setHeight(870);
		assertTrue(theMunro.getHeight() == 870);
	}

	@Test
	public void testSetHeight() {
		Munro theMunro = new Munro();
		theMunro.setHeight(900);
		assertTrue(theMunro.getHeight() == 900);
	}

}
