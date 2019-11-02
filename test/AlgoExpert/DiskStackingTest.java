package AlgoExpert;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DiskStackingTest {
	@Test
	public void test() {
		ArrayList<Integer[]> input = new ArrayList<>();
		input.add(new Integer[] {2, 1, 2});
		input.add(new Integer[] {3, 2, 3});
		input.add(new Integer[] {2, 2, 8});
		ArrayList<Integer[]> result = DiskStacking.diskStacking(input);
		ArrayList<Integer[]> expected = new ArrayList<>();
		expected.add(new Integer[] {2, 2, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}
