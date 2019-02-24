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
	}
}