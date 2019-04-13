package Google;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ConnectedComponentTest {
	ConnectedComponent c;

	@Test
	public void test() {
		c = new ConnectedComponent();
		assertMaxColor(new int[][] {{1, 1}}, 2);
		assertMaxColor(new int[][] {{1}, {1}}, 2);
		assertMaxColor(new int[][] {{1, 2}, {2, 1}}, 1);
		assertMaxColor(new int[][] {{2, 2}, {2, 1}}, 3);
		assertMaxColor(new int[][] {{2, 2}, {2, 2}}, 4);
		assertMaxColor(new int[][] {{2, 1}, {1, 2}}, 1);
		assertMaxColor(new int[][] {{3, 1}, {2, 1}}, 2);
		assertMaxColor(new int[][] {{3, 1}, {4, 2}}, 1);
		assertMaxColor(new int[][] {{3, 1, 1}, {4, 2, 1}}, 3);
		assertMaxColor(new int[][] {{1, 1, 2, 3, 2}, {1, 4, 1, 3, 3}, {2, 4, 4, 2, 3}, {1, 1, 1, 1, 3}}, 5);
	}

	private void assertMaxColor(int[][] input, int expected) {
		int result = c.findMaxColor(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}