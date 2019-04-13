import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MatrixDestroyMachinesTest {
	@Test
	public void test() {
		int[][] roads;
		int[] machines;
		int result;

		roads = new int[][] {{2, 1, 8}, {1, 0, 5}, {2, 4, 5}, {1, 3, 4}};
		machines = new int[] {2, 4, 0};
		result = MatrixDestroyMachines.minTime(roads, machines);
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		roads = new int[][] {{0, 1, 4}, {1, 2, 3}, {1, 3, 7}, {0, 4, 2}};
		machines = new int[] {2, 3, 4};
		result = MatrixDestroyMachines.minTime(roads, machines);
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		roads = new int[][] {{0, 1, 4}, {1, 2, 3}, {1, 3, 7}, {0, 4, 5}};
		machines = new int[] {2, 3, 4};
		result = MatrixDestroyMachines.minTime(roads, machines);
		Assert.assertThat(result, CoreMatchers.equalTo(7));

		roads = new int[][] {{0, 1, 1}, {1, 2, 1}, {1, 3, 1}, {0, 4, 1}};
		machines = new int[] {2, 3, 4};
		result = MatrixDestroyMachines.minTime(roads, machines);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

	}
}