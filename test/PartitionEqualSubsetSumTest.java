import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSubsetSumTest {
	@Test
	public void test() {
		PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
		boolean result = p.canPartition(new int[] {3, 3, 3, 4, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}