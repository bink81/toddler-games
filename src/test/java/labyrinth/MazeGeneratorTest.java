package labyrinth;

import org.junit.Assert;
import org.junit.Test;

public class MazeGeneratorTest {
	private static final int ALMOST_NO_WALLS_RATIO = Integer.MAX_VALUE;
	private static final int ONLY_WALL_RATIO = 1;
	private static final int DUMMY_RATIO = 2;
	private static final int INVALID_RATIO = 0;
	private static final int INVALID_SIZE = -1;

	@Test(expected = IllegalArgumentException.class)
	public void testGenerateWithIncorrectRatio() throws Exception {
		new MazeGenerator(0, 0, INVALID_RATIO).generate();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGenerateWithIncorrectSizeX() throws Exception {
		new MazeGenerator(INVALID_SIZE, 0, DUMMY_RATIO).generate();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGenerateWithIncorrectSizeY() throws Exception {
		new MazeGenerator(0, INVALID_SIZE, DUMMY_RATIO).generate();
	}

	@Test
	public void testGenerateEmpty() throws Exception {
		boolean[][] maze = new MazeGenerator(0, 0, DUMMY_RATIO).generate();

		Assert.assertTrue(maze.length == 0);
	}

	@Test
	public void testGenerateOneWall() throws Exception {
		boolean[][] maze = new MazeGenerator(1, 1, ONLY_WALL_RATIO).generate();

		Assert.assertTrue(!maze[0][0]);
	}

	@Test
	public void testGenerateThousandsWalls() throws Exception {
		boolean[][] maze = new MazeGenerator(100, 1000, ONLY_WALL_RATIO).generate();

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				Assert.assertTrue(!maze[i][j]);
			}
		}
	}

	@Test
	public void testGenerate() throws Exception {
		boolean[][] maze = new MazeGenerator(10, 20, ALMOST_NO_WALLS_RATIO).generate();

		boolean roomEncountered = false;
		for (int i = 0; i < maze.length && !roomEncountered; i++) {
			for (int j = 0; j < maze[0].length && !roomEncountered; j++) {
				if (maze[i][j]) {
					roomEncountered = true;
				}
			}
		}
		Assert.assertTrue(roomEncountered);
	}
}
