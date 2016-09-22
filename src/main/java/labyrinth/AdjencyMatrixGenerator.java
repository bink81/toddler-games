package labyrinth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class AdjencyMatrixGenerator {

	private final boolean[][] maze;

	public AdjencyMatrixGenerator(boolean[][] maze) {
		this.maze = maze;
	}

	public List<List<Integer>> convert() {
		Map<Coordinate, Integer> linkFromCoordinateToNodeNumbers = new HashMap<>();
		int numberOfVertices = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j]) {
					linkFromCoordinateToNodeNumbers.put(new Coordinate(i, j), numberOfVertices++);
				}
			}
		}
		Multimap<Integer, Integer> connectedPlaces = assembleDataAboutConnectedPlaces(
				linkFromCoordinateToNodeNumbers);
		List<List<Integer>> adjencyMatrix = new ArrayList<>();
		for (int nodeNumber = 0; nodeNumber < numberOfVertices; nodeNumber++) {
			List<Integer> connectedNodeNumbers = new ArrayList<>(connectedPlaces.get(nodeNumber));
			adjencyMatrix.add(connectedNodeNumbers);
		}
		return adjencyMatrix;
	}

	private Multimap<Integer, Integer> assembleDataAboutConnectedPlaces(
			final Map<Coordinate, Integer> nodeNumbers) {
		Multimap<Integer, Integer> m = HashMultimap.create();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j]) {
					if (i > 0 && maze[i - 1][j]) {
						m.put(nodeNumbers.get(new Coordinate(i, j)), nodeNumbers.get(new Coordinate(i - 1, j)));
						m.put(nodeNumbers.get(new Coordinate(i - 1, j)), nodeNumbers.get(new Coordinate(i, j)));
					}
					if (i < maze.length - 1 && maze[i + 1][j]) {
						m.put(nodeNumbers.get(new Coordinate(i, j)), nodeNumbers.get(new Coordinate(i + 1, j)));
						m.put(nodeNumbers.get(new Coordinate(i + 1, j)), nodeNumbers.get(new Coordinate(i, j)));
					}
					if (j > 0 && maze[i][j - 1]) {
						m.put(nodeNumbers.get(new Coordinate(i, j)), nodeNumbers.get(new Coordinate(i, j - 1)));
						m.put(nodeNumbers.get(new Coordinate(i, j - 1)), nodeNumbers.get(new Coordinate(i, j)));
					}
					if (j < maze[0].length - 1 && maze[i][j + 1]) {
						m.put(nodeNumbers.get(new Coordinate(i, j)), nodeNumbers.get(new Coordinate(i, j + 1)));
						m.put(nodeNumbers.get(new Coordinate(i, j + 1)), nodeNumbers.get(new Coordinate(i, j)));
					}
				}
			}
		}
		return m;
	}
}
