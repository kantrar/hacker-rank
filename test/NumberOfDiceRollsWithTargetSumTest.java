import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfDiceRollsWithTargetSumTest {
	NumberOfDiceRollsWithTargetSum n = new NumberOfDiceRollsWithTargetSum();
	int result;

	@Test
	public void test() {
		assertResult(1, 6, 8, 0);
		assertResult(2, 6, 1, 0);
		assertResult(2, 6, 7, 6);
		assertResult(1, 6, 3, 1);
		assertResult(2, 6, 12, 1);
		assertResult(1, 2, 3, 0);
		assertResult(30, 30, 500, 222616187);
	}

	private void assertResult(int dice, int face, int target, int expected) {
		result = n.numRollsToTarget(dice, face, target);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}