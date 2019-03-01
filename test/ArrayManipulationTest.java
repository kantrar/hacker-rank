import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ArrayManipulationTest {
	@Test
	public void testBase() {
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {}), CoreMatchers.equalTo(0L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 3, 5}}), CoreMatchers.equalTo(5L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 3, 5}, {8, 9, 10}}),
				CoreMatchers.equalTo(10L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 8, 5}, {8, 9, 10}}),
				CoreMatchers.equalTo(15L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 6, 5}, {8, 9, 10}, {6, 7, 6}}),
				CoreMatchers.equalTo(11L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 6, 5}, {8, 9, 10}, {4, 8, 6}}),
				CoreMatchers.equalTo(16L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 6, 5}, {2, 9, 10}}),
				CoreMatchers.equalTo(15L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 6, 5}, {1, 6, 4}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 2, 5}, {1, 6, 4}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 2, 5}, {1, 2, 4}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 2, 5}, {2, 3, 4}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 1, 1}}), CoreMatchers.equalTo(1L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 1, 2}, {1, 1, 3}}), CoreMatchers.equalTo(5L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 1, 2}, {2, 2, 3}}), CoreMatchers.equalTo(3L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{1, 6, 3}, {2, 4, 2}, {5, 10, 1}, {8, 10, 2}}),
				CoreMatchers.equalTo(5L));
		Assert.assertThat(
				ArrayManipulation.arrayManipulation(10, new int[][] {{1, 6, 3}, {2, 4, 2}, {5, 10, 1}, {8, 10, 2}, {2, 3, 1}}),
				CoreMatchers.equalTo(6L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{3, 10, 1}, {4, 9, 2}, {5, 8, 3}, {6, 7, 4}}),
				CoreMatchers.equalTo(10L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10, new int[][] {{3, 5, 1}, {6, 9, 9}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10,
				new int[][] {{3, 10, 1}, {4, 10, 2}, {5, 10, 3}, {6, 10, 4}, {7, 10, 5}, {8, 10, 6}, {9, 10, 7}}),
				CoreMatchers.equalTo(28L));
		Assert.assertThat(ArrayManipulation.arrayManipulation(10,
				new int[][] {{3, 10, 1}, {4, 10, 2}, {5, 10, 3}, {6, 10, 4}, {7, 10, 5}, {8, 10, 6}, {9, 10, 7}, {10, 10, 8}}),
				CoreMatchers.equalTo(36L));
	}
}