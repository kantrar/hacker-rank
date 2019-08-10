import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SumOfSubsequenceWidthsTest {
	@Test
	public void test() {
		SumOfSubsequenceWidths s = new SumOfSubsequenceWidths();
		int result = s.sumSubseqWidths(new int[] {1, 2, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(23));
	}
}