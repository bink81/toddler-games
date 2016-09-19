package labyrinth;

import com.google.common.base.Preconditions;

public class MazeDisplayer {

	private final boolean[][] maze;

	public MazeDisplayer(boolean[][] maze) {
		Preconditions.checkNotNull(maze, "maze must not be null");
		this.maze = maze;
	}

	public void print() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] ? "X" : " ");
			}
			System.out.println();
		}
	}
}
