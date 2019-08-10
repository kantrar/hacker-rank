import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicateIIITest {
	@Test
	public void test() {
		ContainsDuplicateIII c = new ContainsDuplicateIII();
		boolean result;
		
		result = c.containsNearbyAlmostDuplicate(new int[] {4,1,6,3}, 100, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = c.containsNearbyAlmostDuplicate(new int[] {1,2,3,1}, 3, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = c.containsNearbyAlmostDuplicate(new int[] {1, 5, 9, 1, 5, 9}, 2, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = c.containsNearbyAlmostDuplicate(new int[] {7, 2, 8}, 2, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(true));

	}
}