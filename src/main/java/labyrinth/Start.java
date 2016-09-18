package labyrinth;

public class Start {
	public static void main(String[] args) {
		boolean[][] maze = new MazeGenerator(20, 30).generate();
		new MazeDisplayer(maze).print();
	}
}
