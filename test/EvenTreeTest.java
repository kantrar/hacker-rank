import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class EvenTreeTest {
	@Test
	public void testBase() {
		assertGame(2, 1, Arrays.asList(2), Arrays.asList(1), 0);
		assertGame(2, 1, Arrays.asList(1), Arrays.asList(2), 0);
	}

	@Test
	public void test4Nodes() {
		assertGame(4, 3, Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), 1);
		assertGame(4, 3, Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 1), 1);
		assertGame(4, 3, Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 2), 1);
		assertGame(4, 3, Arrays.asList(1, 2, 3), Arrays.asList(3, 3, 4), 0);
		assertGame(4, 3, Arrays.asList(3, 3, 4), Arrays.asList(1, 2, 3), 0);
		assertGame(4, 3, Arrays.asList(1, 2, 3), Arrays.asList(4, 4, 4), 0);
		assertGame(4, 3, Arrays.asList(4, 4, 4), Arrays.asList(1, 2, 3), 0);
	}

	@Test
	public void test6Nodes() {
		assertGame(6, 5, Arrays.asList(3, 2, 1, 5, 4), Arrays.asList(1, 3, 6, 6, 2), 2);
		assertGame(6, 5, Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(6, 5, 4, 3, 2), 0);
		assertGame(6, 5, Arrays.asList(1, 1, 1, 3, 3), Arrays.asList(6, 5, 4, 1, 2), 1);
		assertGame(6, 5, Arrays.asList(1, 1, 1, 3, 1), Arrays.asList(6, 5, 4, 5, 2), 1);
		assertGame(6, 5, Arrays.asList(1, 1, 1, 5, 6), Arrays.asList(2, 3, 4, 4, 3), 2);
		assertGame(6, 5, Arrays.asList(1, 1, 2, 5, 6), Arrays.asList(2, 3, 4, 3, 3), 1);
		assertGame(6, 5, Arrays.asList(1, 2, 2, 2, 2), Arrays.asList(2, 3, 4, 5, 6), 0);
		assertGame(6, 5, Arrays.asList(1, 2, 2, 4, 4), Arrays.asList(2, 3, 4, 5, 6), 0);
		assertGame(6, 5, Arrays.asList(1, 2, 2, 4, 5), Arrays.asList(2, 3, 4, 5, 6), 1);
	}

	@Test
	public void test10Nodes() {
		assertGame(10, 9, Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10), Arrays.asList(1, 1, 3, 2, 1, 2, 6, 8, 8), 2);
		assertGame(10, 9, Arrays.asList(1, 1, 2, 3, 3, 4, 4, 7, 7), Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10), 1);
	}

	private void assertGame(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to, int expected) {
		Assert.assertThat(EvenTree.evenForest(t_nodes, t_edges, t_from, t_to), CoreMatchers.equalTo(expected));
	}
}