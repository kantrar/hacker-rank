import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MrKMarshTest {
	@Test
	public void test() {
		String[] input;
		input = new String[] {"x...x", ".x..x", "x...x", "..x..", ".x..x"};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(6));

		input = new String[] {
				"x...x",
				".x.x.",
				"..xx.",
				".x.x.",
				".x..."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(-1));

		input = new String[] {
				".....",
				".x.x.",
				"...x.",
				".x.x.",
				".x..."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(12));

		input = new String[] {
				"x.x.x",
				".x..x",
				"x.x.x",
				"..x..",
				".x..x"};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(-1));

		input = new String[] {
				"x...x",
				"....x",
				"x.x.x",
				"..x..",
				".x..x"};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(6));

		input = new String[] {
				"x...x",
				"....x",
				"....x",
				"..x..",
				".x..x"};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(8));

		input = new String[] {
				"x...x",
				".....",
				".....",
				"..x..",
				".x..x"};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(10));

		input = new String[] {
				".....",
				".x...",
				"...x.",
				".....",
				".x..."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(14));

		input = new String[] {
				"......",
				".x....",
				"...x..",
				"......",
				".x...."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(16));

		input = new String[] {
				".....x.",
				".x...x.",
				"...x.x.",
				".....x.",
				".x...x."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(14));

		input = new String[] {
				".....x.",
				".x.....",
				"...x.x.",
				".......",
				".x...x."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(14));

		input = new String[] {
				".....x.",
				".x.....",
				".x.x.x.",
				"..x....",
				".x...x."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(8));

		input = new String[] {
				".........."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(-1));

		input = new String[] {
				".",
				".",
				".",
				".",
				"."};
		Assert.assertThat(MrKMarsh.kMarsh(input), CoreMatchers.equalTo(-1));
	}
}