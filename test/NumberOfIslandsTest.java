import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslandsTest {
	NumberOfIslands n = new NumberOfIslands();
	int res;

	@Test
	public void test() {
		res = n.numIslands(new char[][] {{'1'}});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = n.numIslands(new char[][] {{'1', '1'}});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = n.numIslands(new char[][] {{'1'}, {'1'}});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = n.numIslands(new char[][] {{'1', '0', '1'}});
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = n.numIslands(new char[][] {{'1', '1', '1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0', '0', '1'},
				{'1', '1', '1', '1', '1', '0', '1'}, {'1', '0', '0', '0', '1', '0', '1'}, {'1', '0', '1', '0', '1', '0', '1'},
				{'1', '0', '1', '1', '1', '0', '1'}, {'1', '1', '1', '1', '1', '1', '1'}});
		Assert.assertThat(res, CoreMatchers.equalTo(1));
	}
}
