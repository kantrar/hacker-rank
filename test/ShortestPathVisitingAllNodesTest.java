import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestPathVisitingAllNodesTest {
	@Test
	public void test() {
		ShortestPathVisitingAllNodes s = new ShortestPathVisitingAllNodes();
		int res = s.shortestPathLength(new int[][] {{1, 2, 3}, {0}, {0}, {0}});
		Assert.assertThat(res, CoreMatchers.equalTo(4));
	}
}
