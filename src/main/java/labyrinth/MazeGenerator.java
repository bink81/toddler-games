package labyrinth;

import java.util.Random;

public class MazeGenerator {
	private final int x;
	private final int y;
	private final int bound;

	public MazeGenerator(int x, int y, int bound) {
		this.x = x;
		this.y = y;
		this.bound = bound;
	}

	public boolean[][] generate() {
		boolean[][] maze = new boolean[y][x];
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				maze[j][i] = new Random().nextInt(bound) != 0;
			}
		}
		return maze;
	}
}
