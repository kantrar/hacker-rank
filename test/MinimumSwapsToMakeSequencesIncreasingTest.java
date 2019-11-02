import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumSwapsToMakeSequencesIncreasingTest {
	@Test
	public void test() {
		MinimumSwapsToMakeSequencesIncreasing m = new MinimumSwapsToMakeSequencesIncreasing();

		int res;
		res = m.minSwap(new int[] {0, 3, 5, 8, 9}, new int[] {2, 1, 4, 6, 9});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = m.minSwap(new int[] {}, new int[] {});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = m.minSwap(new int[] {1}, new int[] {1});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = m.minSwap(new int[] {1}, new int[] {2});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = m.minSwap(new int[] {1, 3, 4, 5}, new int[] {2, 5, 6, 7});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = m.minSwap(new int[] {3, 3, 4, 5}, new int[] {2, 5, 6, 7});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = m.minSwap(new int[] {1, 3, 5, 4}, new int[] {1, 2, 3, 7});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = m.minSwap(new int[] {1, 3, 5, 5}, new int[] {1, 2, 4, 7});
		Assert.assertThat(res, CoreMatchers.equalTo(1));
	}
}
