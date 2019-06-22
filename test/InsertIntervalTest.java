import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertIntervalTest {
	InsertInterval i;
	int[][] result;

	@Before
	public void setUp() throws Exception {
		i = new InsertInterval();
	}

	@Test
	public void testGetFirstPos() {
		assertFindFirst(0, 0);
		assertFindFirst(1, 0);
		assertFindFirst(2, 1);
		assertFindFirst(3, 1);
		assertFindFirst(4, 1);
		assertFindFirst(5, 1);
		assertFindFirst(6, 1);
		assertFindFirst(7, 2);
		assertFindFirst(8, 2);
		assertFindFirst(9, 2);
		assertFindFirst(10, 2);
	}

	private void assertFindFirst(int input, int expected) {
		int result;
		result = i.findTheFirstInterval(new int[][] {{1, 3}, {6, 8}}, new int[] {input, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}

	@Test
	public void testGetLastPos() {
		assertFindLast(0, 0);
		assertFindLast(1, 0);
		assertFindLast(2, 0);
		assertFindLast(3, 0);
		assertFindLast(4, 1);
		assertFindLast(5, 1);
		assertFindLast(6, 1);
		assertFindLast(7, 1);
		assertFindLast(8, 1);
		assertFindLast(9, 2);
		assertFindLast(10, 2);

	}

	private void assertFindLast(int input, int expected) {
		int result = i.findTheLastInterval(new int[][] {{1, 3}, {6, 8}}, new int[] {1, input});
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}

	@Test
	public void test() {

		result = i.insert(new int[][] {{1, 3}, {6, 8}}, new int[] {2, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[][] {{1, 5}, {6, 8}}));

		result = i.insert(new int[][] {{1, 3}, {6, 8}}, new int[] {3, 6});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[][] {{1, 8}}));

		result = i.insert(new int[][] {{1, 3}, {6, 8}}, new int[] {4, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[][] {{1, 3}, {4, 5}, {6, 8}}));
	}
}