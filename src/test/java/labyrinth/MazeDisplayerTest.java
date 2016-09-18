package labyrinth;

import org.junit.Test;

public class MazeDisplayerTest {

	@Test(expected = AssertionError.class)
	public void testPrint() throws Exception {
		new MazeDisplayer(null);
	}
}
