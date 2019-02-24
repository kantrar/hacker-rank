import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CountingInversionTest {
	@Test
	public void testBase() {
		Assert.assertThat(CountingInversion.countInversions(new int[] {1, 2, 3}), CoreMatchers.equalTo(0L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {1, 2, 2, 2, 3}), CoreMatchers.equalTo(0L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {1, 2, 2, 2, 3, 4}), CoreMatchers.equalTo(0L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {1, 2, 2}), CoreMatchers.equalTo(0L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 2, 2}), CoreMatchers.equalTo(0L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 3, 1, 2}), CoreMatchers.equalTo(4L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 2, 4}), CoreMatchers.equalTo(1L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 4, 3}), CoreMatchers.equalTo(2L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 4, 2}), CoreMatchers.equalTo(2L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 2, 4, 2}), CoreMatchers.equalTo(2L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 3, 4, 2}), CoreMatchers.equalTo(3L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {2, 1, 1, 4, 2}), CoreMatchers.equalTo(3L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {1, 1, 1, 4, 2}), CoreMatchers.equalTo(1L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {9, 1, 1, 4, 2, 8}), CoreMatchers.equalTo(6L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {8, 1, 1, 4, 2, 8}), CoreMatchers.equalTo(5L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {3, 1, 8, 4, 2, 8}), CoreMatchers.equalTo(5L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {3, 1, 8, 4, 2, 8, 11}), CoreMatchers.equalTo(5L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {3, 1, 9, 4, 2, 8}), CoreMatchers.equalTo(6L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {3, 1, 9, 4, 2, 8, 10}), CoreMatchers.equalTo(6L));
		Assert.assertThat(CountingInversion.countInversions(new int[] {1}), CoreMatchers.equalTo(0L));
	}
}