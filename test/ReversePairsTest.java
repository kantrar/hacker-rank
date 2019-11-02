import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ReversePairsTest {
	ReversePairs r = new ReversePairs();
	int res;

	@Test
	public void test() {
		res = r.reversePairs(new int[] {});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = r.reversePairs(new int[] {1});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = r.reversePairs(new int[] {5, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = r.reversePairs(new int[] {1, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = r.reversePairs(new int[] {5, 5, 5, 5, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = r.reversePairs(new int[] {1, 3, 2, 3, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = r.reversePairs(new int[] {1, 10, 2, 3, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(4));

		res = r.reversePairs(new int[] {1000, 1000, 2, 3, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(7));

		res = r.reversePairs(new int[] {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647});
		Assert.assertThat(res, CoreMatchers.equalTo(0));
	}

}
