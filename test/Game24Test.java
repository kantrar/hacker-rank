import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class Game24Test {
	@Test
	public void test() {
		Game24 game24 = new Game24();
		boolean result;
		result = game24.judgePoint24(new int[] {4, 1, 8, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		// 3 * (9 - (7/7))
		result = game24.judgePoint24(new int[] {3, 9, 7, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}