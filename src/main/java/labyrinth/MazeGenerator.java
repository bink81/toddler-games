package labyrinth;

import java.util.Random;

import com.google.common.base.Preconditions;

public class MazeGenerator {
	private final int horizontalSize;
	private final int verticalSize;
	private final int roomToWallRatio;

	/**
	 * @param horizontalSize
	 *          - positive integer
	 * @param verticalSize
	 *          - positive integer
	 * @param roomToWallRatio
	 *          - positive integer which determines how many walls and rooms the
	 *          maze should contain; 1 is an equal ratio (50%) between walls and
	 *          rooms, with 2 rooms appear 66% of time, with 3 - 75%, etc...
	 */
	public MazeGenerator(int horizontalSize, int verticalSize, int roomToWallRatio) {
		Preconditions.checkArgument(horizontalSize >= 0, "roomToWallRatio must not be negative");
		Preconditions.checkArgument(verticalSize >= 0, "roomToWallRatio must not be negative");
		Preconditions.checkArgument(roomToWallRatio > 0, "roomToWallRatio must be positive");

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
