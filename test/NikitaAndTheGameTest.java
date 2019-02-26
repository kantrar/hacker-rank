import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NikitaAndTheGameTest {

	@Test
	public void testZeros() {
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {0, 0, 1}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {0, 0, 0}), CoreMatchers.equalTo(2));
	}

	@Test
	public void test() {
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {3, 3}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {3, 1, 2}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {3, 2, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 3, 2}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 3}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 4}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 6, 3}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {3, 6, 3}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {4, 2, 2}), CoreMatchers.equalTo(2));
	}

	@Test
	public void test2() {
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 2, 4}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 2, 5}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 2, 2, 2, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 2, 2, 1, 2}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 3, 2, 2, 2}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 5, 2, 3, 3}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 5, 1, 3, 4}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 5, 2, 2, 4}), CoreMatchers.equalTo(3));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 2, 5, 1, 2, 2, 4}), CoreMatchers.equalTo(0));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {8, 4, 2, 1, 1}), CoreMatchers.equalTo(4));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {9, 4, 2, 1, 1}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {9, 5, 2, 1, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 6, 4, 2, 1, 1}), CoreMatchers.equalTo(4));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {8, 8, 8, 4, 2, 1, 1}), CoreMatchers.equalTo(5));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 4, 2, 1, 1}),
				CoreMatchers.equalTo(5));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 4, 4}),
				CoreMatchers.equalTo(5));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 1, 1, 1, 1, 1, 1, 1, 2}), CoreMatchers.equalTo(2));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}),
				CoreMatchers.equalTo(4));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 2}),
				CoreMatchers.equalTo(1));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 5, 6}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 9, 6, 6}), CoreMatchers.equalTo(2));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 9, 5, 7}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 0, 2, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 1, 3, 0, 0}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {3, 2, 3, 1, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 2, 2, 1, 1}), CoreMatchers.equalTo(3));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {8760958, 8760957, 547560, 547560, 547560, 273780, 273780, 2190239, 4380479, 4380479, 4380478}),
				CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211, 21211,
						21211}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {16384, 8192, 8192, 16384, 8192, 8192, 32768, 32768}),
				CoreMatchers.equalTo(4));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {2097152, 1048576, 1048576, 2097152, 1048576, 262144, 262144, 524288, 1048576, 1048576, 1048576,
						1048576, 2097152, 2097152, 1048576, 524288, 524288, 2097152, 524288, 524288, 524288, 524288, 2097152,
						524288, 262144, 262144, 524288, 131072, 131072, 131072, 131072, 262144, 65536, 65536, 32768, 32768,
						65536,
						262144, 262144, 1048576, 1048576, 1048576, 262144, 262144, 524288, 524288, 131072, 65536, 65536, 32768,
						32768, 65536, 32768, 32768, 65536, 2097152, 2097152, 131072, 65536, 65536, 131072, 131072, 262144, 65536,
						65536, 131072, 1048576, 2097152, 2097152, 2097152, 4194304, 2097152, 524288, 524288, 1048576, 4194304,
						8388608}), CoreMatchers.equalTo(11));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994, 999999994,
						999999994}), CoreMatchers.equalTo(6));

		Assert.assertThat(NikitaAndTheGame
						.arraySplitting(new int[] {2, 0, 0, 2, 2, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 2, 0}),
				CoreMatchers.equalTo(0));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {0, 2, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 2, 0, 2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0,
						2, 0, 2, 0, 2, 0, 2, 2}), CoreMatchers.equalTo(0));

	}

	@Test
	public void testWithZeroAndNegative() {
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, -1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, 1, 1, -1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, 1, 0, 1, -1}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, 2, 0, 0, 1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, -1, 1, 1, 0, 0, 0, 0}), CoreMatchers.equalTo(4));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, 1, 1, 5, 3, 1, 1, 1}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(
				new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), CoreMatchers.equalTo(54));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1}),
				CoreMatchers.equalTo(9));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {0, 1, -1}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {0, 1, -1, 0}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {0, 1, -1, 0, 0}), CoreMatchers.equalTo(3));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {0, 2, 2, 0, 0}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, -1, 0, 1, -1, 0, 0}), CoreMatchers.equalTo(4));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, -1, 2, 2, 0, 0}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, -2, 4, 4, 0, 0}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, -4, 6, 4, 0, 0}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {6, -4, 2, 4, 0, 0}), CoreMatchers.equalTo(2));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, -4, 2, 0, 0, 0}), CoreMatchers.equalTo(3));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {4, -2, -2, 0, 0, 0}), CoreMatchers.equalTo(3));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, -2, 2, -2, 0, 0, 0}), CoreMatchers.equalTo(4));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, -2, 2, -2, 2, -2, 2, -2}), CoreMatchers.equalTo(3));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-2, 2, 2, -2, 2, -2, 2, -2}), CoreMatchers.equalTo(3));

		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {-2, 2, 2, 2, -2, -2, 2, 2, -2}), CoreMatchers.equalTo(0));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {2, 2, 2, 2, -2, -2, 2, 2, 2, 2}), CoreMatchers.equalTo(1));
		Assert.assertThat(NikitaAndTheGame.arraySplitting(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 8}), CoreMatchers.equalTo(4));

	}
}

