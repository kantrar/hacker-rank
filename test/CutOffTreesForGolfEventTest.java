import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CutOffTreesForGolfEventTest {
	CutOffTreesForGolfEvent c = new CutOffTreesForGolfEvent();
	int result;

	@Test
	public void test() {
		assertResult(Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1)), 0);
		assertResult(Arrays.asList(Arrays.asList(2, 1, 1), Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1)), 0);
		assertResult(Arrays.asList(Arrays.asList(2, 1, 1), Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 9)), 4);
		assertResult(Arrays.asList(Arrays.asList(2, 0, 0), Arrays.asList(0, 1, 1), Arrays.asList(1, 1, 9)), -1);
		assertResult(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(0, 0, 4), Arrays.asList(7, 6, 5)), 6);
		assertResult(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(0, 0, 0), Arrays.asList(7, 6, 5)), -1);
		assertResult(Arrays.asList(Arrays.asList(2, 3, 4), Arrays.asList(0, 0, 5), Arrays.asList(8, 7, 6)), 6);
		assertResult(Arrays.asList(Arrays.asList(1, 2, 9, 4), Arrays.asList(0, 0, 12, 8), Arrays.asList(16, 0, 1, 0),
				Arrays.asList(3, 0, 17, 1), Arrays.asList(1, 19, 5, 1)), 43);
		assertResult(Arrays.asList(Arrays.asList(54581641, 64080174, 24346381, 69107959),
				Arrays.asList(86374198, 61363882, 68783324, 79706116), Arrays.asList(668150, 92178815, 89819108, 94701471),
				Arrays.asList(83920491, 22724204, 46281641, 47531096), Arrays.asList(89078499, 18904913, 25462145, 60813308)),
				57);
	}

	private void assertResult(List<List<Integer>> input, int expected) {
		result = c.cutOffTree(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}
