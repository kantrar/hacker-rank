import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TotalHammingDistanceTest {
	@Test
	public void test() {
		TotalHammingDistance t = new TotalHammingDistance();
		int result;
		result = t.totalHammingDistance(new int[] {4, 14, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(6));
	}
}