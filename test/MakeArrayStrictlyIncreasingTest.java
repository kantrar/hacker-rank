import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MakeArrayStrictlyIncreasingTest {
	MakeArrayStrictlyIncreasing m = new MakeArrayStrictlyIncreasing();
	int res = m.makeArrayIncreasing(new int[] {5, 16, 19, 2, 1, 12, 7, 14, 5, 16},
			new int[] {6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16});

	@Test
	public void test() {
		res = m.makeArrayIncreasing(new int[] {5, 16, 19, 2, 1, 12, 7, 14, 5, 16},
				new int[] {6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16});
		Assert.assertThat(res, CoreMatchers.equalTo(8));
				res = m.makeArrayIncreasing(new int[] {}, new int[] {1,2});
				Assert.assertThat(res, CoreMatchers.equalTo(0));

				res = m.makeArrayIncreasing(new int[] {}, new int[] {});
				Assert.assertThat(res, CoreMatchers.equalTo(0));

				res = m.makeArrayIncreasing(new int[] {0, 11, 6, 1, 4, 3}, new int[] {5, 4, 10, 11, 1, 0});
				Assert.assertThat(res, CoreMatchers.equalTo(5));

				res = m.makeArrayIncreasing(new int[] {1, 2, 3, 4, 5}, new int[] {});
				Assert.assertThat(res, CoreMatchers.equalTo(0));

				res = m.makeArrayIncreasing(new int[] {1, 2, 3, 4, 3}, new int[] {});
				Assert.assertThat(res, CoreMatchers.equalTo(-1));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {0, 1, 2});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {1, 2, 3, 4});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {1, 2, 4});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {1, 2});
				Assert.assertThat(res, CoreMatchers.equalTo(-1));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {0, 1, 8});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {0, 6, 8});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {0, 4, 8});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

				res = m.makeArrayIncreasing(new int[] {5, 3, 2}, new int[] {0, 5, 8});
				Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = m.makeArrayIncreasing(new int[] {1, 5, 3, 6, 7}, new int[] {1, 2, 3, 4});
		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = m.makeArrayIncreasing(new int[] {1, 5, 3, 6, 7}, new int[] {1, 3, 4});
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = m.makeArrayIncreasing(new int[] {1, 5, 3, 6, 7}, new int[] {1, 6, 3, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(-1));

	}
}
