import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BalancedForestTest {
	@Test
	public void testBase() {

		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2}, new int[][] {{1, 2}}), CoreMatchers.equalTo
		// (2));

		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2, 2}, new int[][] {{1, 2}, {1, 3}, {1, 4}}),
		//				CoreMatchers.equalTo(0));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2, 2, 2}, new int[][] {{1, 2}, {1, 3}, {1, 4}}),
		//				CoreMatchers.equalTo(-1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2, 2, 1}, new int[][] {{1, 2}, {1, 3}, {1, 4}}),
		//				CoreMatchers.equalTo(-1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {3, 2, 2, 1}, new int[][] {{1, 2}, {1, 3}, {1, 4}}),
		//				CoreMatchers.equalTo(1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 3, 2, 1}, new int[][] {{1, 2}, {1, 3}, {1, 4}}),
		//				CoreMatchers.equalTo(1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 3, 2, 1, 1}, new int[][] {{1, 2}, {1, 3}, {1, 4},
		// {4, 5}}),
		//				CoreMatchers.equalTo(-1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {1, 3, 4}, new int[][] {{1, 3}, {1, 2}}),
		//				CoreMatchers.equalTo(4));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {1, 2, 2, 1, 1}, new int[][] {{1, 2}, {1, 3}, {3, 5},
		// {1, 4}}),
		//				CoreMatchers.equalTo(2));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 4, 4}, new int[][] {{1, 3}, {1, 2}}),
		//				CoreMatchers.equalTo(2));
		//
		//		Assert.assertThat(
		//				BalancedForest.balancedForest(new int[] {16, 10, 9, 6, 5}, new int[][] {{1, 2}, {2, 4}, {1, 3}, {3, 5}}),
		//				CoreMatchers.equalTo(2));
		//
		//		Assert.assertThat(
		//				BalancedForest.balancedForest(new int[] {16, 10, 9, 8, 9}, new int[][] {{1, 2}, {2, 4}, {1, 3}, {3, 5}}),
		//				CoreMatchers.equalTo(2));
		//
		//		Assert.assertThat(BalancedForest
		//						.balancedForest(new int[] {6, 9, 7, 1, 11, 4, 3}, new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5},
		// {4, 6},
		//								{5, 7}}),
		//				CoreMatchers.equalTo(1));
		//
		//		Assert.assertThat(BalancedForest
		//						.balancedForest(new int[] {7, 9, 7, 1, 11, 4, 3}, new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5},
		// {4, 6},
		//								{5, 7}}),
		//				CoreMatchers.equalTo(-1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 9, 7, 4, 1, 11, 6, 4, 3, 5},
		//				new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {5, 8}, {6, 9}, {6, 10}}), CoreMatchers
		// .equalTo(5));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2, 7, 13, 1, 11, 6, 4, 3, 5},
		//				new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {5, 8}, {6, 9}, {6, 10}}), CoreMatchers
		// .equalTo(3));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2, 7, 13, 1, 11, 2, 4, 3, 5, 4},
		//				new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {5, 8}, {6, 9}, {6, 10}, {7, 11}}),
		//				CoreMatchers.equalTo(3));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 2, 7, 13, 1, 11, 2, 4, 3, 5, 4},
		//				new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {5, 8}, {6, 9}, {6, 10}, {4, 11}}),
		//				CoreMatchers.equalTo(3));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 5, 7, 12, 1, 11, 2, 4, 3, 5, 4},
		//				new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {5, 8}, {6, 9}, {6, 10}, {4, 11}}),
		//				CoreMatchers.equalTo(1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {2, 9, 7, 13, 1, 11, 2, 4, 3, 5, 4},
		//				new int[][] {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {5, 8}, {6, 9}, {6, 10}, {4, 11}}),
		//				CoreMatchers.equalTo(-1));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {6, 6, 6, 12, 6}, new int[][] {{1, 2}, {1, 3}, {2, 4},
		// {3,
		//						5}}),
		//				CoreMatchers.equalTo(18));
		//
		Assert.assertThat(BalancedForest.balancedForest(new int[] {4, 5, 6, 1, 2, 9, 2, 6},
				new int[][] {{1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {5, 8}}), CoreMatchers.equalTo(4));
		//
		//		Assert.assertThat(BalancedForest.balancedForest(new int[] {4, 4, 6, 1, 2, 9, 2, 6},
		//				new int[][] {{1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {5, 8}}), CoreMatchers.equalTo(5));
	}
}