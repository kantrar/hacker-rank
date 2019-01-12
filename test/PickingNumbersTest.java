import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PickingNumbersTest {
	@Test
	public void testSimple() {
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)), CoreMatchers.equalTo(5));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)), CoreMatchers.equalTo(3));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)), CoreMatchers.equalTo(5));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(1, 2, 2, 2, 2, 2)), CoreMatchers.equalTo(6));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(2, 2, 2, 2, 2, 2)), CoreMatchers.equalTo(6));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(4, 4, 2, 2, 2, 2)), CoreMatchers.equalTo(4));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(4, 4, 2, 2, 4, 2)), CoreMatchers.equalTo(3));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(1, 3, 5, 7, 9)), CoreMatchers.equalTo(1));
		Assert.assertThat(PickingNumbers.pickingNumbers(Arrays.asList(1, 3, 4, 5, 7, 9)), CoreMatchers.equalTo(2));
	}
}