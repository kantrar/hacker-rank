import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FruitIntoBasketsTest {
	@Test
	public void test() {
		FruitIntoBaskets f = new FruitIntoBaskets();
		int result;
		result = f.totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		result = f.totalFruit(new int[] {0, 1, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}