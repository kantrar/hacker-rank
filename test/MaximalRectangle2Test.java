import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximalRectangle2Test {
	@Test
	public void test() {
		MaximalRectangle2 m = new MaximalRectangle2();
		int result;

		result = m.maximalRectangle(new char[][] {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}});

		Assert.assertThat(result, CoreMatchers.equalTo(6));

		result = m.maximalRectangle(
				new char[][] {{'0', '0', '0', '1'},
							{'0', '0', '1', '1'},
							{'0', '1', '1', '1'},
							{'0', '1', '1', '1'}});
		Assert.assertThat(result, CoreMatchers.equalTo(6));


		result = m.maximalRectangle(new char[][] {{'1', '1'}});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = m.maximalRectangle(new char[][] {{'1'}, {'1'}});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}