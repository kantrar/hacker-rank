import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PartitionArrayForMaxSumTest {
	@Test
	public void test() {
		PartitionArrayForMaxSum p = new PartitionArrayForMaxSum();
		int result;

		result = p.maxSumAfterPartitioning(new int[] {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(83));

		result = p.maxSumAfterPartitioning(new int[] {1, 15, 7, 9, 2, 5, 10}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(84));
	}
}