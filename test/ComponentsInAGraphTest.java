import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComponentsInAGraphTest {
	@Test
	public void test() {
		assertComponents(new int[][] {{1, 6}, {2, 7}, {3, 8}, {4, 9}, {2, 6}}, new int[] {2, 4});
		assertComponents(new int[][] {{1, 6}}, new int[] {2, 2});
		assertComponents(new int[][] {}, new int[] {0, 0});
		assertComponents(new int[][] {{1, 6}, {1, 6}}, new int[] {2, 2});
		assertComponents(new int[][] {{1, 6}, {2, 6}}, new int[] {3, 3});
		assertComponents(new int[][] {{1, 6}, {2, 6}, {5, 10}}, new int[] {2, 3});
	}

	private static void assertComponents(int[][] gb, int[] expected) {
		int[] result = ComponentsInAGraph.componentsInGraph(gb);
		assertTrue(result[0] == expected[0]);
		assertTrue(result[1] == expected[1]);

	}
}