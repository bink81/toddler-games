package labyrinth;

import java.util.List;

public class MazeValidator {
	private final List<Integer>[] adjencyMatrix;

	public MazeValidator(List<Integer>[] adjencyMatrix) {
		this.adjencyMatrix = adjencyMatrix;
	}

	// implementation of a graph algorithm to count connected components
	public int numberOfDisjointSections() {
		boolean[] isNodeVisited = new boolean[adjencyMatrix.length];
		int[] alocatedSections = new int[adjencyMatrix.length];
		int currentSectionNumber = 0;
		for (int node = 0; node < adjencyMatrix.length; node++) {
			if (!isNodeVisited[node]) {
				explore(node, isNodeVisited, currentSectionNumber, alocatedSections);
				currentSectionNumber++;
			}
		}
		return currentSectionNumber;
	}

	private void explore(final int parentNode, final boolean[] isNodeVisited, final int currentSection,
			final int[] alocatedSections) {
		isNodeVisited[parentNode] = true;
		alocatedSections[parentNode] = currentSection;
		List<Integer> neighborNodes = adjencyMatrix[parentNode];
		for (int node : neighborNodes) {
			if (!isNodeVisited[node]) {
				explore(node, isNodeVisited, currentSection, alocatedSections);
			}
		}
	}
}
