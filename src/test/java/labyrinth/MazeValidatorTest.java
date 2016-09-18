package labyrinth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class MazeValidatorTest {

	@Test
	public void testNumberOfDisjointSections1() throws Exception {
		int numberOfDisjointSections = process("c1.txt");

		Assert.assertTrue(numberOfDisjointSections == 2);
	}

	@Test
	public void testNumberOfDisjointSections2() throws Exception {
		int numberOfDisjointSections = process("c2.txt");

		Assert.assertTrue(numberOfDisjointSections == 4);
	}

	@Test
	public void testNumberOfDisjointSections3() throws Exception {
		int numberOfDisjointSections = process("c3.txt");

		Assert.assertTrue(numberOfDisjointSections == 1);
	}

	/**
	 * @param fileName
	 *            the name of a file with a graph representation
	 * 
	 *            File format: the first line contains a number of vertices n
	 *            and edges m. The following lines contain connected vertices u
	 *            and v. Constraints: 2 <= n; 1 <= m; 1 <= u, v <= n; u != v
	 * 
	 * @return the number of disjoint sections
	 */
	private int process(String fileName) {
		File file = new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "graphs"
				+ File.separator + fileName);

		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			List<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				int x, y;
				x = scanner.nextInt();
				y = scanner.nextInt();
				adj[x - 1].add(y - 1);
				adj[y - 1].add(x - 1);
			}
			return new MazeValidator(adj).numberOfDisjointSections();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 666;
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
