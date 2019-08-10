import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LastStoneWeightsIITest {
	@Test
	public void test() {
		LastStoneWeightsII l = new LastStoneWeightsII();
		int res;
		res = l.lastStoneWeightII(new int[] {1});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = l.lastStoneWeightII(new int[] {1, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = l.lastStoneWeightII(new int[] {1, 2});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = l.lastStoneWeightII(new int[] {1, 2, 2, 3,});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = l.lastStoneWeightII(new int[] {2, 7, 4, 1, 8, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = l.lastStoneWeightII(new int[] {31, 26, 33, 21, 40});
		Assert.assertThat(res, CoreMatchers.equalTo(5));

		res = l.lastStoneWeightII(new int[] {34, 30, 6, 25, 13, 32});
		Assert.assertThat(res, CoreMatchers.equalTo(0));
	}
}