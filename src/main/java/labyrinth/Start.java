package labyrinth;

import java.util.List;

public class Start {
	private static final int VARTICAL_LENGTH = 10;
	private static final int HORIZONTAL_LENGTH = 15;
	private static final int ROOM_TO_WALL_RATIO = 3;

	public static void main(String[] args) {
		boolean[][] maze = new MazeGenerator(VARTICAL_LENGTH, HORIZONTAL_LENGTH, ROOM_TO_WALL_RATIO)
				.generate();
		new MazeDisplayer(maze).print();
		List<List<Integer>> matrix = new AdjencyMatrixGenerator(maze).convert();
		int numberOfDisjointSections = new MazeValidator(matrix).numberOfDisjointSections();
		System.out.println("The labirynth has " + numberOfDisjointSections + " separate sections");
	}
}
