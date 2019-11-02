import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class IsGraphBipartiteTest {
	@Test
	public void test() {
		IsGraphBipartite i = new IsGraphBipartite();
		boolean result = i.isBipartite(
				new int[][] {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9},
						{2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}});
		Assert.assertThat(result, CoreMatchers.equalTo(false));
	}
}
