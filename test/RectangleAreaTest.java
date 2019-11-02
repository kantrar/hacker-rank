import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RectangleAreaTest {
	RectangleArea r = new RectangleArea();
	int result;

	@Test
	public void test() {
		result = r.computeArea(0, 0, 0, 0, 5, 5, 5, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = r.computeArea(5, 5, 10, 10, 7, 0, 20, 20);
		Assert.assertThat(result, CoreMatchers.equalTo(270));

		result = r.computeArea(0, 0, 10, 10, 5, 11, 7, 12);
		Assert.assertThat(result, CoreMatchers.equalTo(102));

		result = r.computeArea(0, 0, 10, 10, 5, 10, 7, 12);
		Assert.assertThat(result, CoreMatchers.equalTo(104));

		result = r.computeArea(0, 0, 10, 10, 5, 6, 7, 12);
		Assert.assertThat(result, CoreMatchers.equalTo(104));

		result = r.computeArea(0, 0, 10, 10, 5, 6, 7, 8);
		Assert.assertThat(result, CoreMatchers.equalTo(100));

		result = r.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(45));

		result = r.computeArea(0, 0, 6, 5, 7, 9, 8, 10);
		Assert.assertThat(result, CoreMatchers.equalTo(31));

	}
}
