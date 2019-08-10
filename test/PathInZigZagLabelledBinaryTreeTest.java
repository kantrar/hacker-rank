import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathInZigZagLabelledBinaryTreeTest {
	PathInZigZagLabelledBinaryTree p;
	List<Integer> result;

	@Before
	public void setUp() throws Exception {
		p = new PathInZigZagLabelledBinaryTree();

	}

	@Test
	public void test() {
		assertResult(1, Arrays.asList(1));
		assertResult(2, Arrays.asList(1, 2));
		assertResult(3, Arrays.asList(1, 3));
		assertResult(4, Arrays.asList(1, 3, 4));
		assertResult(5, Arrays.asList(1, 3, 5));
		assertResult(6, Arrays.asList(1, 2, 6));
		assertResult(7, Arrays.asList(1, 2, 7));
		assertResult(8, Arrays.asList(1, 2, 7, 8));
		assertResult(9, Arrays.asList(1, 2, 7, 9));

		assertResult(10, Arrays.asList(1, 2, 6, 10));
		assertResult(11, Arrays.asList(1, 2, 6, 11));
		assertResult(12, Arrays.asList(1, 3, 5, 12));
		assertResult(13, Arrays.asList(1, 3, 5, 13));
		assertResult(14, Arrays.asList(1, 3, 4, 14));
		assertResult(15, Arrays.asList(1, 3, 4, 15));
		assertResult(16, Arrays.asList(1, 3, 4, 15, 16));

		p.pathInZigZagTree(1000000);
	}

	private void assertResult(int label, List<Integer> expected) {
		result = p.pathInZigZagTree(label);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}