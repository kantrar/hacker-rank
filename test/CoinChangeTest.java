import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {

	private void assertGame(long goal, long[] inputs, long result) {
		Assert.assertThat(CoinChange.getWays(goal, inputs), CoreMatchers.equalTo(result));
	}

	@Test
	public void testBaseCase() {
		assertGame(2, new long[] {2}, 1);
	}

	@Test
	public void testBaseCase2() {
		assertGame(100, new long[] {2}, 1);
	}

	@Test
	public void testBaseCaseNoAnswer() {
		assertGame(4, new long[] {3}, 0);
	}

	@Test
	public void testBaseCaseNoAnswer2() {
		assertGame(100, new long[] {3}, 0);
	}

	@Test
	public void testSimpleGame_0() {
		assertGame(2, new long[] {1, 2}, 2);
	}

	@Test
	public void testSimpleGame() {
		assertGame(4, new long[] {1, 2}, 3);
	}

	@Test
	public void testSimpleGame2() {
		assertGame(4, new long[] {1, 2, 3}, 4);
	}

	@Test
	public void testSimpleGame2_1() {
		assertGame(4, new long[] {3, 1, 2}, 4);
	}

	@Test
	public void testSimpleGame3() {
		assertGame(10, new long[] {2, 3, 5, 6}, 5);
	}

	@Test
	public void testSimpleGame3_1() {
		assertGame(10, new long[] {2, 5, 3, 6}, 5);
	}

	@Test
	public void testSimpleGame3_2() {
		assertGame(10, new long[] {2, 6, 5, 3}, 5);
	}

	@Test
	public void testSimpleGame4() {
		assertGame(3, new long[] {1, 2, 3}, 3);
	}

	@Test
	public void testSimpleGame5() {
		assertGame(10, new long[] {1, 5}, 3);
	}

	@Test
	public void testSimpleGame6() {
		assertGame(100, new long[] {1, 5}, 21);
	}

	@Test
	public void testSimpleGame6_1() {
		assertGame(100, new long[] {5, 1}, 21);
	}

	@Test
	public void testSimpleGameNoAnswer1() {
		assertGame(17, new long[] {2}, 0);
	}

	@Test
	public void testSimpleGameNoAnswer2() {
		assertGame(17, new long[] {2, 4}, 0);
	}

	@Test
	public void testSimpleGameNoAnswer3() {
		assertGame(17, new long[] {2, 4, 8}, 0);
	}

	@Test
	public void testSimpleGame7() {
		assertGame(17, new long[] {1, 16}, 2);
	}

	@Test
	public void testSimpleGame8() {
		assertGame(4, new long[] {1, 2, 4}, 4);
		// 1111, 22, 4, 112
	}

	@Test
	public void testSimpleGame9() {
		assertGame(7, new long[] {1, 3}, 3);
		// 1111111, 11113, 133
	}

	@Test
	public void testSimpleGame10() {
		assertGame(7, new long[] {1, 3, 5}, 4);
		// 1111111, 11113, 133, 115
	}
}