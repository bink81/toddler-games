package labyrinth;

import java.util.Random;

public class MazeGenerator {
	private final int x;
	private final int y;

	public MazeGenerator(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean[][] generate() {
		boolean[][] maze = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maze[i][j] = new Random().nextBoolean();
			}
		}
		return maze;
	}
}
