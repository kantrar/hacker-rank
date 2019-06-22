import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SingleNumbersTest {
	@Test
	public void test() {
		SingleNumbers s = new SingleNumbers();
		int result = s.singleNumber(new int[] {3, 7, 3, 7, 4, 6, 6, 7, 3, 6});
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}