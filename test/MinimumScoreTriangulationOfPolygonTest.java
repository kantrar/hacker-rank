import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumScoreTriangulationOfPolygonTest {
	@Test
	public void test() {
		MinimumScoreTriangulationOfPolygon m = new MinimumScoreTriangulationOfPolygon();
		int res;
		res = m.minScoreTriangulation(new int[] {1, 2, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(6));

		res = m.minScoreTriangulation(new int[] {3, 7, 4, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(144));

		res = m.minScoreTriangulation(new int[] {1, 3, 1, 4, 1, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(13));
	}
}