import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MissingNumberTest {
	@Test
	public void test() {
		MissingNumber m = new MissingNumber();
		int result = m.missingNumber(new int[] {0, 1, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}