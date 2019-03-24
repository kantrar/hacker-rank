import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class QueensAttackIITest {

	@Test
	public void test() {
		int result;
		result = QueensAttackII.queensAttack(5, 3, 4, 3, new int[][] {{5, 5}, {4, 2}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = QueensAttackII.queensAttack(5, 0, 1, 1, new int[][] {});
		Assert.assertThat(result, CoreMatchers.equalTo(12));

		result = QueensAttackII.queensAttack(5, 1, 1, 1, new int[][] {{2, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(8));

		result = QueensAttackII.queensAttack(5, 3, 1, 1, new int[][] {{2, 2}, {1, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = QueensAttackII.queensAttack(5, 3, 1, 1, new int[][] {{2, 2}, {1, 2}, {2, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = QueensAttackII.queensAttack(5, 3, 3, 2, new int[][] {{1, 4}, {2, 4}, {3, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(11));

		result = QueensAttackII.queensAttack(5, 4, 3, 2, new int[][] {{3, 1}, {3, 3}, {2, 2}, {4, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(6));

		result = QueensAttackII.queensAttack(5, 4, 3, 2, new int[][] {{3, 1}, {3, 3}, {2, 2}, {2, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(8));
	}
}