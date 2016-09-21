package labyrinth;

import org.junit.Test;

public class MazeGeneratorTest {

	@Test
	public void testGenerate() throws Exception {
		new MazeGenerator(10, 20, 1).generate();
	}

}
