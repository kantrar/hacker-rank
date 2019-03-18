import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class VisuallyBalancedSectionsTest {
	@Test
	public void test() {
		int result;

		result = VisuallyBalancedSections.visuallyBalancedSections(Arrays.asList(1, 2, 1, 2));
		Assert.assertThat(result, CoreMatchers.equalTo(7));

		result = VisuallyBalancedSections.visuallyBalancedSections(Arrays.asList(1, 2, 3, 2, 1));
		Assert.assertThat(result, CoreMatchers.equalTo(7));
	}
}