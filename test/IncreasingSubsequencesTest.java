import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class IncreasingSubsequencesTest {
	@Test
	public void test() {
		IncreasingSubsequences i = new IncreasingSubsequences();
		List<List<Integer>> result = i.findSubsequences(new int[] {4, 6, 7, 7});
	}
}