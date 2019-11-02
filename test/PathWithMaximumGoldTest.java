import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PathWithMaximumGoldTest {
	@Test
	public void test() {
		PathWithMaximumGold p = new PathWithMaximumGold();
		int maximumGold;
//		maximumGold = p.getMaximumGold(new int[][] {{1}});
//		Assert.assertThat(maximumGold, CoreMatchers.equalTo(1));
//
//		maximumGold = p.getMaximumGold(new int[][] {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}});
//		Assert.assertThat(maximumGold, CoreMatchers.equalTo(24));
//
//		maximumGold = p.getMaximumGold(new int[][] {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}});
//		Assert.assertThat(maximumGold, CoreMatchers.equalTo(28));
//
//		maximumGold = p.getMaximumGold(new int[][] {{1, 2}, {3, 4}});
//		Assert.assertThat(maximumGold, CoreMatchers.equalTo(10));

		maximumGold = p.getMaximumGold(
				new int[][] {
						{1, 0, 7, 0, 0, 0},
						{2, 0, 6, 0, 1, 0},
						{3, 5, 6, 7, 4, 2},
						{4, 3, 1, 0, 2, 0},
						{3, 0, 5, 0, 20, 0}});
		Assert.assertThat(maximumGold, CoreMatchers.equalTo(60));
	}
}
