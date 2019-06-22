import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaxAreaOfIslandTest {
	@Test
	public void test() {
		MaxAreaOfIsland m = new MaxAreaOfIsland();
		int result = m.maxAreaOfIsland(new int[][] {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}