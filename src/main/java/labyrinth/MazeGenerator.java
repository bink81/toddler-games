package labyrinth;

import java.util.Random;

public class MazeGenerator {
	private final int horizontalSize;
	private final int verticalSize;
	private final int roomToWallRatio;

	public MazeGenerator(int horizontalSize, int verticalSize, int roomToWallRatio) {
		this.horizontalSize = horizontalSize;
		this.verticalSize = verticalSize;
		this.roomToWallRatio = roomToWallRatio;
	}

	public boolean[][] generate() {
		boolean[][] maze = new boolean[verticalSize][horizontalSize];
		for (int y = 0; y < verticalSize; y++) {
			for (int x = 0; x < horizontalSize; x++) {
				maze[y][x] = new Random().nextInt(roomToWallRatio) != 0;
			}
		}
		return maze;
	}
}
