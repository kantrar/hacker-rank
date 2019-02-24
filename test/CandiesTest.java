import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CandiesTest {

	@Test
	public void test() {
		assertCandies(5, new int[] {1, 1, 1, 1, 1}, 5);
		assertCandies(5, new int[] {2, 2, 2, 2, 2}, 5);
		assertCandies(5, new int[] {3, 2, 2, 2, 3}, 7);
		assertCandies(7, new int[] {4, 3, 2, 2, 2, 3, 4}, 13);
		assertCandies(7, new int[] {2, 3, 4, 4, 4, 3, 2}, 13);

		assertCandies(7, new int[] {2, 3, 4, 5, 4, 3, 2}, 16);
		assertCandies(7, new int[] {1, 2, 1, 2, 1, 2, 1}, 10);
		assertCandies(7, new int[] {1, 3, 4, 1, 2, 9, 1}, 13);
		assertCandies(9, new int[] {1, 3, 4, 1, 2, 9, 10, 10, 11}, 19);
		assertCandies(1, new int[] {2}, 1);

		assertCandies(3, new int[] {1, 2, 3}, 6);
		assertCandies(3, new int[] {1, 3, 2}, 4);
		assertCandies(3, new int[] {1, 4, 3}, 4);
		assertCandies(3, new int[] {2, 1, 3}, 5);
		assertCandies(3, new int[] {2, 3, 1}, 4);
		assertCandies(3, new int[] {3, 2, 1}, 6);
		assertCandies(3, new int[] {3, 1, 2}, 5);
		assertCandies(3, new int[] {2, 2, 1}, 4);
		assertCandies(3, new int[] {1, 2, 2}, 4);

		assertCandies(5, new int[] {1, 2, 3, 4, 5}, 15);
		assertCandies(5, new int[] {1, 2, 3, 2, 1}, 9);
		assertCandies(5, new int[] {1, 2, 3, 2, 2}, 8);
		assertCandies(5, new int[] {1, 2, 3, 1, 2}, 9);
		assertCandies(5, new int[] {1, 3, 3, 1, 2}, 8);
		assertCandies(5, new int[] {1, 3, 3, 3, 2}, 7);
		assertCandies(5, new int[] {4, 5, 5, 5, 4}, 7);
		assertCandies(5, new int[] {2, 1, 3, 2, 1}, 9);


		assertCandies(3, new int[] {1, 2, 2}, 4);
		assertCandies(8, new int[] {2, 4, 3, 5, 2, 6, 4, 5}, 12);
		assertCandies(10, new int[] {2, 4, 2, 6, 1, 7, 8, 9, 2, 1}, 19);
	}

	private void assertCandies(int n, int[] arr, int expected) {
		Assert.assertThat(Candies.candies1(n, arr), CoreMatchers.equalTo((long) expected));
	}
}