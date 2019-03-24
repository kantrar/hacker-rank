import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CutTreeTest {
	@Test
	public void test() {
		long result;
		result = CutTree.cuttree(2, 1, new int[][] {{2, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(4L));

		result = CutTree.cuttree(3, 1, new int[][] {{2, 1}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(6L));

		result = CutTree.cuttree(3, 2, new int[][] {{2, 1}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(7L));


		result = CutTree.cuttree(3, 1, new int[][] {{1, 2}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(6L));

		result = CutTree.cuttree(4, 1, new int[][] {{1, 2}, {2, 3}, {3, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(8L));
		// 1 - 2 - 3 - 4
		// {}, {1,2,3,4}, {1}, {4}, {1,2}, {3,4}, {1,2,3}, {2,3,4},
	}
}