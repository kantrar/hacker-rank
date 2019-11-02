import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumMovesToReachTargetWithRotationsTest {
	@Test
	public void test() {
		MinimumMovesToReachTargetWithRotations m = new MinimumMovesToReachTargetWithRotations();
		int res;
		//		res = m.minimumMoves(
		//				new int[][] {{0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0}, {0, 1, 1,
		// 0, 0, 0},
		//						{0, 1, 1, 0, 0, 0}});
		//		Assert.assertThat(res, CoreMatchers.equalTo(11));
		//
		//		res = m.minimumMoves(
		//				new int[][] {{0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1,
		// 0, 0, 1},
		//						{1, 1, 1, 0, 0, 0}});
		//		Assert.assertThat(res, CoreMatchers.equalTo(9));
		//
		//		res = m.minimumMoves(new int[][] {{}});
		//		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = m.minimumMoves(
				new int[][] {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
						{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
						{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
						{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
		Assert.assertThat(res, CoreMatchers.equalTo(-1));
	}
}
