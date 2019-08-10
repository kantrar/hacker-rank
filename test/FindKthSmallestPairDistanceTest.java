import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FindKthSmallestPairDistanceTest {
	FindKthSmallestPairDistance f = new FindKthSmallestPairDistance();
	int res;

	@Test
	public void testSimple() {
		res = f.smallestDistancePair(new int[] {1, 3, 9}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = f.smallestDistancePair(new int[] {1, 3, 9}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(6));

		res = f.smallestDistancePair(new int[] {1, 3, 9}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(8));

		res = f.smallestDistancePair(new int[] {1, 3, 1}, 1);
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = f.smallestDistancePair(new int[] {1, 3, 1}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = f.smallestDistancePair(new int[] {1, 3, 1}, 3);
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		assertResult(1, 0);
		assertResult(2, 1);
		assertResult(3, 1);
		assertResult(4, 1);
		assertResult(5, 1);
		assertResult(6, 2);
		assertResult(7, 2);
		assertResult(8, 2);
		assertResult(9, 2);
		assertResult(10, 3);
		assertResult(11, 3);
		assertResult(12, 3);
		assertResult(13, 4);
		assertResult(14, 5);
		assertResult(15, 5);
	}

	private void assertResult(int order, int expected) {
		res = f.smallestDistancePair(new int[] {1, 1, 2, 3, 4, 6}, order);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}

	@Test
	public void test() {
		res = f.smallestDistancePair(new int[] {1, 3, 5}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = f.smallestDistancePair(
				new int[] {10, 6, 2, 10, 5, 4, 0, 1, 5, 2, 5, 5, 5, 0, 4, 9, 8, 6, 7, 9, 1, 10, 4, 8, 6, 3, 6, 2, 1, 7, 5, 0, 2,
						6, 10, 10, 0, 3, 9, 0, 8, 3, 5, 9, 4, 4, 5, 2, 2, 7}, 444);
		Assert.assertThat(res, CoreMatchers.equalTo(2));
	}
}