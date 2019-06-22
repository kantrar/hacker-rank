import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MovingStonesUntilConsecutiveIITest {
	@Test
	public void test() {
		MovingStonesUntilConsecutiveII m = new MovingStonesUntilConsecutiveII();
		int[] result;
		result = m.numMovesStonesII(new int[] {7, 4, 9});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 2}));

		result = m.numMovesStonesII(new int[] {3, 5, 7, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 2}));

		result = m.numMovesStonesII(new int[] {100, 101, 104, 102, 103});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 0}));

		result = m.numMovesStonesII(new int[] {6, 5, 4, 3, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {2, 3}));
	}
}