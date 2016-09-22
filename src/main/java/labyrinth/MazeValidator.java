package labyrinth;

import java.util.List;

public class MazeValidator {
	private final List<List<Integer>> adjencyMatrix;

	public MazeValidator(List<List<Integer>> adjencyMatrix) {
		this.adjencyMatrix = adjencyMatrix;
	}

	// implementation of a graph algorithm to count connected components
	public int numberOfDisjointSections() {
		boolean[] isNodeVisited = new boolean[adjencyMatrix.size()];
		int[] alocatedSections = new int[adjencyMatrix.size()];
		int currentSectionNumber = 0;
		for (int node = 0; node < adjencyMatrix.size(); node++) {
			if (!isNodeVisited[node]) {
				explore(node, isNodeVisited, currentSectionNumber, alocatedSections);
				currentSectionNumber++;
			}
		}
		return currentSectionNumber;
	}

	private void explore(final int parentNode, final boolean[] isNodeVisited,
			final int currentSection, final int[] alocatedSections) {
		isNodeVisited[parentNode] = true;
		alocatedSections[parentNode] = currentSection;
		List<Integer> neighborNodes = adjencyMatrix.get(parentNode);
		for (int node : neighborNodes) {
			if (!isNodeVisited[node]) {
				explore(node, isNodeVisited, currentSection, alocatedSections);
			}
		}
	}
}
