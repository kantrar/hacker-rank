import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class EmaTest {
	@Test
	public void testMarkGrid() {
		String[] sample = new String[5];
		sample[0] = "ggggg";
		sample[1] = "ggggg";
		sample[2] = "ggggg";
		sample[3] = "ggggg";
		sample[4] = "ggggg";

		String[] newGrid = Ema.markGrid(sample, 2, 2, 2);
		assertGrid(newGrid, "ggBgg", "ggBgg", "BBBBB", "ggBgg", "ggBgg");

	}

	private void assertGrid(String[] grid, String... exptected) {
		Assert.assertThat(grid.length, CoreMatchers.equalTo(exptected.length));
		for (int i = 0; i < exptected.length; i++) {
			Assert.assertThat(grid[i].length(), CoreMatchers.equalTo(exptected[i].length()));
			Assert.assertThat(grid[i], CoreMatchers.equalTo(exptected[i]));
		}
	}
}