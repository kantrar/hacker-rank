import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ReachableNodesInSubdividedGraphTest {
	@Test
	public void test() {
		ReachableNodesInSubdividedGraph r = new ReachableNodesInSubdividedGraph();
		int result;

		result = r.reachableNodes(new int[][] {{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}}, 10, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(23));

		result = r.reachableNodes(new int[][] {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(13));

		result = r.reachableNodes(
				new int[][] {{0, 2, 3}, {0, 4, 4}, {2, 3, 8}, {1, 3, 5}, {0, 3, 9}, {3, 4, 6}, {0, 1, 5}, {2, 4, 6}, {1, 2, 3},
						{1, 4, 1}}, 8, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(43));
	}
}