import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FillingBookcaseShelvesTest {
	FillingBookcaseShelves f;
	int result;

	@Before
	public void setUp() throws Exception {
		f = new FillingBookcaseShelves();

	}

	@Test
	public void test() {
		assertResult(new int[][] {{1, 2}}, 4, 2);
		assertResult(new int[][] {{1, 1}, {1, 2}}, 4, 2);
		assertResult(new int[][] {{1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4, 2);
		assertResult(new int[][] {{2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4, 5);
		assertResult(new int[][] {{2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4, 5);
		assertResult(new int[][] {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4, 6);
	}

	private void assertResult(int[][] books, int maxWidth, int expected) {
		result = f.minHeightShelves(books, maxWidth);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}