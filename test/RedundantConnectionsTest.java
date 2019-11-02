import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RedundantConnectionsTest {
	private RedundantConnections r = new RedundantConnections();
	private int[] res;

	@Test
	public void test() {
		assertResult(new int[][] {{1, 2}, {3, 1}, {2, 3}}, new int[] {2, 3});
		assertResult(new int[][] {{2, 1}, {3, 1}, {4, 2}, {1, 4}}, new int[] {2, 1});
		assertResult(new int[][] {{1, 2}, {1, 3}, {2, 3}}, new int[] {2, 3});
		assertResult(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}, new int[] {4, 1});
		assertResult(new int[][] {{1, 2}, {2, 1}}, new int[] {2, 1});
		assertResult(new int[][] {{1, 2}, {3, 1}, {3, 2}}, new int[] {3, 2});
		assertResult(new int[][] {{1, 2}, {3, 1}, {2, 1}}, new int[] {2, 1});
	}

	private void assertResult(int[][] input, int[] expected) {
		res = r.findRedundantDirectedConnection(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
