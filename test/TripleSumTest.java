import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TripleSumTest {
	@Test
	public void test() {
		long result;
		int[] a = {1, 3, 5};
		int[] b = {2, 3};
		int[] c = {1, 2, 3};

		result = TripleSum.triplets(a, b, c);
		Assert.assertThat(result, CoreMatchers.equalTo(8L));

		a = new int[] {1, 4, 5};
		b = new int[] {2, 3, 3};
		c = new int[] {1, 2, 3};

		result = TripleSum.triplets(a, b, c);
		Assert.assertThat(result, CoreMatchers.equalTo(5L));

		a = new int[] {1, 3, 5, 7};
		b = new int[] {5, 7, 9};
		c = new int[] {7, 9, 11, 13};

		result = TripleSum.triplets(a, b, c);
		Assert.assertThat(result, CoreMatchers.equalTo(12L));

		a = new int[] {1, 3, 5, 7};
		b = new int[] {5, 7, 9, 14, 15};
		c = new int[] {7, 9, 11, 13};

		result = TripleSum.triplets(a, b, c);
		Assert.assertThat(result, CoreMatchers.equalTo(44L));

		a = new int[] {1, 3, 5, 7};
		b = new int[] {5, 7, 9, 14, 15, 18};
		c = new int[] {7, 9, 11, 13};

		result = TripleSum.triplets(a, b, c);
		Assert.assertThat(result, CoreMatchers.equalTo(60L));

		a = new int[] {1, 3, 5, 7};
		b = new int[] {5, 7, 9, 14};
		c = new int[] {7, 9, 11, 13};

		result = TripleSum.triplets(a, b, c);
		Assert.assertThat(result, CoreMatchers.equalTo(28L));
	}
}