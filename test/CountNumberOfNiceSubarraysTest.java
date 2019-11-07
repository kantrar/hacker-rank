import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CountNumberOfNiceSubarraysTest {
	@Test
	public void test() {
		CountNumberOfNiceSubarrays c = new CountNumberOfNiceSubarrays();
		int res;
		res = c.numberOfSubarrays(new int[] {}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = c.numberOfSubarrays(new int[] {2,2,4}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = c.numberOfSubarrays(new int[] {1, 1, 1, 1, 1,}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(5));

		res = c.numberOfSubarrays(new int[] {1, 1, 2, 1, 1,}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(6));

		res = c.numberOfSubarrays(new int[] {1, 1, 2, 1, 1,}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = c.numberOfSubarrays(new int[] {1, 1, 2, 2, 2, 2, 1, 1,}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = c.numberOfSubarrays(new int[] {2, 4, 6}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = c.numberOfSubarrays(new int[] {2, 4, 6, 3}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(4));

		res = c.numberOfSubarrays(new int[] {2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(16));
	}
}
