import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DungeonGameTest {
	DungeonGame d;
	int result;

	@Before
	public void setUp() {
		d = new DungeonGame();
		result = 0;
	}

	@Test
	public void testEmpty() {
		assertHp(null, 0);
		assertHp(new int[][] {}, 0);
		assertHp(new int[][] {{}}, 0);
	}

	@Test
	public void testOneCell() {
		assertHp(new int[][] {{5}}, 1);
		assertHp(new int[][] {{0}}, 1);
		assertHp(new int[][] {{-5}}, 6);
	}

	private void assertHp(int[][] input, int expected) {
		result = d.calculateMinimumHP(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}

	@Test
	public void testTwoCells() {
		assertHp(new int[][] {{-5, 3}}, 6);
		assertHp(new int[][] {{-5, 8}}, 6);
		assertHp(new int[][] {{-5, 0}}, 6);
		assertHp(new int[][] {{-5, -8}}, 14);

		assertHp(new int[][] {{0, 5}}, 1);
		assertHp(new int[][] {{0, 0}}, 1);
		assertHp(new int[][] {{0, -5}}, 6);

		assertHp(new int[][] {{5, 3}}, 1);
		assertHp(new int[][] {{5, 0}}, 1);
		assertHp(new int[][] {{5, -3}}, 1);
		assertHp(new int[][] {{5, -8}}, 4);
	}

	@Test
	public void testFourCells() {
		assertHp(new int[][] {{5, -6}, {-8, 5}}, 2);
		assertHp(new int[][] {{5, -6}, {-8, -4}}, 6);
		assertHp(new int[][] {{5, -6}, {3, -4}}, 1);
		assertHp(new int[][] {{5, -5}, {-5, -4}}, 5);
		assertHp(new int[][] {{5, -5}, {-5, 0}}, 1);
		assertHp(new int[][] {{5, -3}, {-6, 0}}, 1);
		assertHp(new int[][] {{5, 0}, {-6, 0}}, 1);
	}

	@Test
	public void testSample() {
		assertHp(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}, 7);
	}
}