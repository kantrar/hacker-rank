import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TilingARectangleWithTheFewestSquaresTest {
	@Test
	public void test() {
		TilingARectangleWithTheFewestSquares t = new TilingARectangleWithTheFewestSquares();
		int res;
		res = t.tilingRectangle(5, 8);
		Assert.assertThat(res, CoreMatchers.equalTo(5));

		res = t.tilingRectangle(11, 13);
		Assert.assertThat(res, CoreMatchers.equalTo(6));
	}
}
