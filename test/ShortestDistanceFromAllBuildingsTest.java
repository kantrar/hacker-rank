import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceFromAllBuildingsTest {
	private ShortestDistanceFromAllBuildings s;

	@Test
	public void test() {
		s = new ShortestDistanceFromAllBuildings();
		assertAnswer(new int[][] {{1, 1}, {1, 1}}, -1);
		assertAnswer(new int[][] {{2, 2}, {2, 2}}, -1);
		assertAnswer(new int[][] {{0, 0}, {0, 0}}, 0);
		assertAnswer(new int[][] {{1, 0}, {1, 1}}, -1);
		assertAnswer(new int[][] {{1, 0}, {1, 0}}, 3);
		assertAnswer(new int[][] {{1, 0}, {0, 1}}, 2);
		assertAnswer(new int[][] {{1, 2}, {1, 1}}, -1);
		assertAnswer(new int[][] {{2,0,0}, {0, 1,0}, {1,0,0}}, 2);
		assertAnswer(new int[][] {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}, 7);
	}

	private void assertAnswer(int[][] in, int expected) {
		int result = s.shortestDistance(in);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}