import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JeaniesRouteTest {
	@Test
	public void test2Nodes() {
		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 2}, new int[][] {{1, 2, 1}}), CoreMatchers.equalTo(1));
		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 2}, new int[][] {{1, 2, 4}}), CoreMatchers.equalTo(4));
	}

	@Test
	public void test5Nodes() {
		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 3, 4}, new int[][] {{1, 2, 1}, {2, 3, 2}, {2, 4, 2}, {3, 5,
						3}}),
				CoreMatchers.equalTo(6));

		Assert.assertThat(
				JeaniesRoute.jeanisRoute(new int[] {1, 2, 3, 4}, new int[][] {{1, 2, 1}, {2, 3, 2}, {2, 4, 2}, {3, 5, 3}}),
				CoreMatchers.equalTo(6));
		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 3}, new int[][] {{1, 2, 1}, {2, 3, 2}, {2, 4, 2}, {3, 5, 3}}),
				CoreMatchers.equalTo(3));

		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {4, 5}, new int[][] {{1, 2, 1}, {2, 3, 2}, {2, 4, 2}, {3, 5, 3}}),
				CoreMatchers.equalTo(7));
//		Assert.assertThat(JeaniesRoute
//						.jeanisRoute(new int[] {1, 2, 3, 7}, new int[][] {{1, 6, 100}, {6, 2, 4}, {5, 6, 1}, {5, 3, 1}, {5, 7,
//								2}}),
//				CoreMatchers.equalTo(112));
//		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 2, 3, 7},
//				new int[][] {{1, 6, 100}, {6, 2, 4}, {5, 6, 1}, {5, 3, 1}, {5, 7, 2}, {5, 9, 12}}), CoreMatchers.equalTo(112));
//		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {2, 4, 7},
//				new int[][] {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {1, 5, 1}, {2, 6, 1}, {5, 7, 1}, {5, 8, 1}}),
//				CoreMatchers.equalTo(5));
//		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 2, 3, 4}, new int[][] {{1, 2, 1}, {2, 3, 1}, {2, 4, 1}}),
//				CoreMatchers.equalTo(4));
	}

	@Test
	public void testToBeExplored() {
		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 2, 4}, new int[][] {{1, 2, 1}, {2, 3, 1}, {2, 4, 1}}),
				CoreMatchers.equalTo(2));

		Assert.assertThat(JeaniesRoute.jeanisRoute(new int[] {1, 2, 3, 4, 5, 6, 7},
				new int[][] {{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {1, 5, 1}, {2, 6, 1}, {5, 7, 1}, {5, 8, 1}}),
				CoreMatchers.equalTo(7));
	}
}