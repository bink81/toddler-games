package labyrinth;

public class Start {
	public static void main(String[] args) {
		boolean[][] maze = new MazeGenerator(10, 15, 3).generate();
		new MazeDisplayer(maze).print();
	}
}
