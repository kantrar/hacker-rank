import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumCostToMergeStonesTest {
	MinimumCostToMergeStones m = new MinimumCostToMergeStones();
	int res;

	@Test
	public void test() {
		res = m.mergeStones(new int[] {3, 2, 4, 1}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(20));

		res = m.mergeStones(new int[] {3, 2, 4, 1}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(-1));

		res = m.mergeStones(new int[] {3, 5, 1, 2, 6}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(25));
	}

	@Test
	public void testBase() {
		res = m.mergeStones(new int[] {1}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = m.mergeStones(new int[] {1, 2, 4, 5}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(-1));

		res = m.mergeStones(new int[] {1, 2, 4, 5, 6, 9, 12, 2}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(-1));
	}

	@Test
	public void assertSimple() {

		res = m.mergeStones(new int[] {1, 2}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(3));

		res = m.mergeStones(new int[] {1, 2, 3}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(9));

		res = m.mergeStones(new int[] {1, 2, 4}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(10));

		res = m.mergeStones(new int[] {3, 2, 4, 1}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(20));

		res = m.mergeStones(new int[] {3, 2, 4}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(14));

		res = m.mergeStones(new int[] {2, 4, 1}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(12));
	}
}
