package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LargestRangeTest {
	@Test
	public void test() {
		assertResult(new int[] {}, new int[] {});
		assertResult(new int[] {1}, new int[] {1, 1});
		assertResult(new int[] {1, 1}, new int[] {1, 1});
		assertResult(new int[] {1, 2}, new int[] {1, 2});
		assertResult(new int[] {1, 4}, new int[] {1, 1});
		assertResult(new int[] {1, 4, 3, 2}, new int[] {1, 4});
		assertResult(new int[] {1, 4, 3, 2, 6}, new int[] {1, 4});
		assertResult(new int[] {1, 4, 3, 2, 5}, new int[] {1, 5});
		assertResult(new int[] {1, 4, 3, 2, 6, 8}, new int[] {1, 4});
		assertResult(new int[] {1, 4, 5, 3, 2, 6, 7, 0}, new int[] {0, 7});
		assertResult(new int[] {1, 4, 5, 3, 2, 6, 8, 7, 0}, new int[] {0, 8});

		assertResult(new int[] {-1, 0, 7, 10, 9, 8}, new int[] {7, 10});
		assertResult(new int[] {-1, 0, 7, 4, 3, 2, 1, 0}, new int[] {-1, 4});
		assertResult(new int[] {-1, 0, 7, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[] {-1, 10});

		assertResult(new int[] {1, 4, 6, 10, 300, 999}, new int[] {1, 1});

		assertResult(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
				new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE});

		assertResult(new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE},
				new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE});

		assertResult(new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2},
				new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE + 2});
	}

	private void assertResult(int[] input, int[] expected) {
		int[] res = LargestRange.largestRange(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
