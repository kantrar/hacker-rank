import static org.junit.Assert.*;

import org.junit.Test;

public class SwapNodeTest {

	@Test
	public void test() {
		int[][] result = SwapNode.swapNodes(
				new int[][] {{2, 3}, {4, -1}, {5, -1}, {6, -1}, {7, 8}, {-1, 9}, {-1, -1}, {10, 11}, {-1, -1}, {-1, -1},
						{-1, -1}}, new int[] {2, 2, 4});
	}
}