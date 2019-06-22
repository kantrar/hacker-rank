import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfDistinctIslandsTest {
	@Test
	public void test() {
		NumberOfDistinctIslands n = new NumberOfDistinctIslands();
		int result = n.numDistinctIslands(new int[][] {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}