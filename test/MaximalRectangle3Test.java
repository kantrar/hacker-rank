import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximalRectangle3Test {
	@Test
	public void test() {
		MaximalRectangle3 m = new MaximalRectangle3();
		int result = m.maximalRectangle(new char[][] {{'1', '1'}});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}