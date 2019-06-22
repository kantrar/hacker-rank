import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartitionToKEqualSumSubsetsTest {
	PartitionToKEqualSumSubsets p;
	boolean result;

	@Before
	public void setUp() {
		p = new PartitionToKEqualSumSubsets();
	}

	@Test
	public void test() {
		result = p.canPartitionKSubsets(new int[] {2, 2, 2, 2, 3, 4, 5}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(false));
	}

	@Test
	public void test2() {
		result = p.canPartitionKSubsets(new int[] {4, 4, 4, 4}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}

	@Test
	public void test3() {
		result = p.canPartitionKSubsets(new int[] {4, 4, 1, 3, 4}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}

	@Test
	public void test4() {
		result = p.canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}

	@Test
	public void test5() {
		result = p.canPartitionKSubsets(new int[] {2, 2, 2, 5, 1, 3, 3, 4, 2}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}

	@Test
	public void test6() {
		result = p.canPartitionKSubsets(new int[] {4, 5, 3, 2, 5, 5, 5, 1, 5, 5, 5, 5, 3, 5, 5, 2}, 13);
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}