import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeRemovalTest {
	PalindromeRemoval p = new PalindromeRemoval();
	int res;

	@Test
	public void test() {
		assertResult(new int[] {19, 17, 14, 17, 2, 1, 14, 11}, 6);
		assertResult(new int[] {4, 1, 14, 16, 15, 18, 19, 17, 10, 8, 10, 4}, 8);
		assertResult(new int[] {14, 16, 15, 18, 19, 17, 10, 8, 10, 4, 19, 17, 14, 17, 2, 1, 14}, 9);
		assertResult(new int[] {4, 1, 14, 16, 15, 18, 19, 17, 10, 8, 10, 4, 19, 17, 14, 17, 2, 1, 14, 11}, 12);
		assertResult(new int[] {16, 13, 13, 10, 12}, 4);
		assertResult(new int[] {1, 14, 18, 20, 14, 13, 15, 20, 14}, 5);
		assertResult(new int[] {1, 14, 18, 20, 14}, 3);
		assertResult(new int[] {13, 13, 13, 13, 13}, 1);
		assertResult(new int[] {13, 16, 14, 16, 13}, 1);
		assertResult(new int[] {1, 2}, 2);
		assertResult(new int[] {1, 3, 4, 1, 5}, 3);
		assertResult(new int[] {1, 2, 3, 2, 1, 5}, 2);
		assertResult(new int[] {1, 2, 3, 3, 2, 1, 5}, 2);
		assertResult(new int[] {1, 2, 3, 3, 2, 1, 5, 6, 7}, 4);
		assertResult(new int[] {1, 2, 3, 3, 2, 1, 5, 6, 7, 5}, 3);
		assertResult(new int[] {1, 2, 3, 3, 2, 1, 5, 6, 7, 5, 1}, 4);
	}

	private void assertResult(int[] input, int expected) {
		res = p.minimumMoves(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
