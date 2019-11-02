import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class x115DistinctSubsequencesTest {
	x115DistinctSubsequences x = new x115DistinctSubsequences();
	int result;

	@Test
	public void test() {
		result = x.numDistinct("babgbag", "");
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = x.numDistinct("babgbag", "bag");
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		result = x.numDistinct("rabbbit", "rabbit");
		Assert.assertThat(result, CoreMatchers.equalTo(3));

	}
}
