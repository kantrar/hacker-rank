import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MatchsticksToSquareTest {
	@Test
	public void test() {
		MatchsticksToSquare m = new MatchsticksToSquare();
		boolean result;

		result = m.makesquare(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = m.makesquare(new int[] {1, 1, 2, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = m.makesquare(new int[] {3, 3, 3, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = m.makesquare(new int[] {3, 4, 3, 1, 2, 5, 1, 3, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}