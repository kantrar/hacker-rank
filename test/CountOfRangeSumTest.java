import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CountOfRangeSumTest {
	CountOfRangeSum c = new CountOfRangeSum();
	int result;

	@Test
	public void test() {
		assertMethod(new int[] {}, 0);
		assertMethod(new int[] {3}, 0);
		assertMethod(new int[] {-2}, 1);
		assertMethod(new int[] {-2, 5}, 1);

		assertMethod(new int[] {-2, 5, -1}, 3);
		assertMethod(new int[] {5, -3, 6, -2, -4}, 2 + 1 + 1 + 1);
	}

	private void assertMethod(int[] input, int expected) {
		result = c.countRangeSum(input, -2, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}

	@Test
	public void testZero() {
		assertMethod(new int[] {0}, 1);

		assertMethod(new int[] {-2, 2}, 3);

		assertMethod(new int[] {0, 0, 0, 0, 0, 0}, 21);

		assertMethod(new int[] {-2, 2, 0, -2, 2}, 15);
	}

	@Test
	public void testLargeNumber() {
		int result = c.countRangeSum(new int[] {-2147483647, 0, -2147483647, 2147483647}, -564, 3864);
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}
