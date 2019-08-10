import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CherryPickupTest {
	CherryPickup c;
	int result;

	@Before
	public void setUp() throws Exception {
		c = new CherryPickup();

	}

	@Test
	public void testOneCell() {
		assertResult(new int[][] {{1}}, 1);
		assertResult(new int[][] {{0}}, 0);
	}

	@Test
	public void testTwoCell() {
		assertResult(new int[][] {{1, 1}, {0, 0}}, 2);
		assertResult(new int[][] {{1, 0}, {0, 0}}, 1);
		assertResult(new int[][] {{0, 0}, {0, 0}}, 0);
	}

	private void assertResult(int[][] input, int expected) {
		result = c.cherryPickup(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}

	@Test
	public void testFourCells() {
		assertResult(new int[][] {{1, 1}, {1, -1}}, 0);
	}

	@Test
	public void testSimple() {
		assertResult(new int[][] {{1, 1, 1}, {0, 1, -1}, {1, 1, 1}}, 6);
		assertResult(new int[][] {{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}, 0);
		assertResult(new int[][] {{1, -1, 1, 1}, {-1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}, 0);
	}

	@Test
	public void testComplex() {
		assertResult(new int[][] {{1, -1, -1, -1, -1}, {1, 0, 1, -1, -1}, {0, -1, 1, 0, 1}, {1, 0, 1, 1, 0}, {-1, -1, -1, 1, 1}},
				10);
	}
}