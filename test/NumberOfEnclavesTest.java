import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfEnclavesTest {
	@Test
	public void test() {
		NumberOfEnclaves n = new NumberOfEnclaves();
		int res;
		res = n.numEnclaves(new int[][] {
				{0, 0, 0, 0},
				{1, 0, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}});
		Assert.assertThat(res, CoreMatchers.equalTo(3));

		res = n.numEnclaves(new int[][] {
				{0,1,1,0},
				{0,0,1,0},
				{0,0,1,0},
				{0,0,0,0}}
		);

		Assert.assertThat(res, CoreMatchers.equalTo(0));
	}
}