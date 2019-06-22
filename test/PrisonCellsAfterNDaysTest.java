import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PrisonCellsAfterNDaysTest {
	@Test
	public void test() {
		PrisonCellsAfterNDays p = new PrisonCellsAfterNDays();
		int[] result;
//		result = p.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7);
//		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 0, 1, 1, 0, 0, 0, 0}));

		result = p.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 0, 1, 1, 1, 1, 1, 0}));
	}
}