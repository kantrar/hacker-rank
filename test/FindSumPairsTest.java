import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FindSumPairsTest {
	@Test
	public void test() {
		int result = FindSumPairs.findSumPairs(new int[] {1, 3, 2, 6, 1, 2}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(5));
	}
}