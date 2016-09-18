package labyrinth;

import java.util.List;

public class MazeValidator {
	// implementation of a graph algorithm to count connected components
	public static int numberOfDisjointSections(final List<Integer>[] adjencyMatrix) {
		boolean[] isNodeVisited = new boolean[adjencyMatrix.length];
		int[] alocatedSections = new int[adjencyMatrix.length];
		int currentSectionNumber = 0;
		for (int node = 0; node < adjencyMatrix.length; node++) {
			if (!isNodeVisited[node]) {
				explore(node, adjencyMatrix, isNodeVisited, currentSectionNumber, alocatedSections);
				currentSectionNumber++;
			}
		}
		return currentSectionNumber;
	}

	private static void explore(final int parentNode, final List<Integer>[] adjencyMatrix,
			final boolean[] isNodeVisited, final int currentSection, final int[] alocatedSections) {
		isNodeVisited[parentNode] = true;
		alocatedSections[parentNode] = currentSection;
		List<Integer> neighborNodes = adjencyMatrix[parentNode];
		for (int node : neighborNodes) {
			if (!isNodeVisited[node]) {
				explore(node, adjencyMatrix, isNodeVisited, currentSection, alocatedSections);
			}
		}
	}
}
