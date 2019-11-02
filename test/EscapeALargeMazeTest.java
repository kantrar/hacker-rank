import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class EscapeALargeMazeTest {
	EscapeALargeMaze e = new EscapeALargeMaze();
	boolean result;

	@Test
	public void test() {

		result = e.isEscapePossible(new int[][] {}, new int[] {0, 0}, new int[] {0, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = e.isEscapePossible(new int[][] {{0, 1}, {1, 0}}, new int[] {0, 0}, new int[] {0, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = e.isEscapePossible(new int[][] {{0, 3}, {1, 0}, {1, 1}, {1, 2}, {1, 3}}, new int[] {0, 0}, new int[] {0, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = e.isEscapePossible(new int[][] {{0, 1}, {1, 0}}, new int[] {0, 2}, new int[] {999999, 999999});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = e.isEscapePossible(new int[][] {{0, 1}, {1, 0}}, new int[] {0, 2}, new int[] {3, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = e.isEscapePossible(new int[][] {{0, 1}, {1, 0}}, new int[] {0, 2}, new int[] {3, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

	}
}
