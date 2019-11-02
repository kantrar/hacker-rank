import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumEqualsFrequencyTest {
	@Test
	public void test() {
		MaximumEqualsFrequency m = new MaximumEqualsFrequency();
		int res;
		res = m.maxEqualFreq(new int[] {2, 2, 1, 1, 5, 3, 3, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(7));

		res = m.maxEqualFreq(new int[] {1, 1, 1, 2, 2, 2});
		Assert.assertThat(res, CoreMatchers.equalTo(5));

		res = m.maxEqualFreq(new int[] {1});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = m.maxEqualFreq(new int[] {1, 1, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(3));

		res = m.maxEqualFreq(new int[] {1, 2, 3, 4});
		Assert.assertThat(res, CoreMatchers.equalTo(4));

		res = m.maxEqualFreq(new int[] {1, 2, 2});
		Assert.assertThat(res, CoreMatchers.equalTo(3));

		res = m.maxEqualFreq(new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(13));

		res = m.maxEqualFreq(
				new int[] {1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 42, 97, 5, 46, 53, 100, 63, 27, 12, 83, 82, 21, 77, 58, 93, 86,
						5, 72, 16, 23, 99, 88, 47, 96, 16, 26, 89, 41, 19, 40, 42, 78, 43, 29, 51, 50, 92, 76, 76, 54, 7, 46, 93,
						26, 56, 94, 34, 100, 26, 97, 60, 73, 46, 31, 26, 2, 50, 15, 55, 42, 64, 30, 72, 18, 8, 58, 50, 81, 84,
						60,
						91, 2, 3, 48, 65, 65, 5, 49, 31, 9, 78, 94, 32, 11, 33, 31, 53, 19, 92, 14, 94, 27, 65, 92, 14});
		Assert.assertThat(res, CoreMatchers.equalTo(13));
	}
}
