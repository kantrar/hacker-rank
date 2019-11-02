import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class KnightProbabilityInChessboardTest {
	@Test
	public void test() {
		KnightProbabilityInChessboard k = new KnightProbabilityInChessboard();
		double result;
		result = k.knightProbability(7, 7, 3, 3);
		Assert.assertThat(result, Matchers.closeTo(0.11806, 0.01));

		result = k.knightProbability(3, 2, 0, 0);
		Assert.assertThat(result, Matchers.closeTo(0.0625, 0.01));

	}
}
