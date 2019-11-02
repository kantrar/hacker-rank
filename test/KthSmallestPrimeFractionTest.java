import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class KthSmallestPrimeFractionTest {
	@Test
	public void test() {
		KthSmallestPrimeFraction k = new KthSmallestPrimeFraction();
		int[] res;
		res = k.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 5}));

		res = k.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 3}));

		res = k.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {2, 5}));

		res = k.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 4);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 2}));

		res = k.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 5);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {3, 5}));

		res = k.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 6);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {2, 3}));

		res = k.kthSmallestPrimeFraction(new int[] {1, 7}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 7}));

		res = k.kthSmallestPrimeFraction(
				new int[] {1, 2029, 3209, 3517, 3823, 4933, 8209, 8893, 12763, 12799, 14197, 14387, 18973, 19207, 23747, 24547,
						24953, 25247, 25763, 27043}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 27043}));
	}
}
