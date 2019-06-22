import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DistantBarcodesTest {
	@Test
	public void test() {
		DistantBarcodes d = new DistantBarcodes();
		int[] result;
		//		result = d.rearrangeBarcodes(new int[] {1, 1, 1, 2, 2, 2});
		//		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 2, 1, 2, 1, 2}));
		//
		//		result = d.rearrangeBarcodes(new int[] {1, 1, 2, 2, 2, 3, 5, 5, 5, 5, 5, 5, 5});
		//		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {5, 2, 5, 2, 5, 2, 5, 1, 5, 1, 5, 3, 5}));
		//
		//		result = d.rearrangeBarcodes(new int[] {7, 7, 7, 8, 5, 7, 5, 5, 5, 8});
		//		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {5, 7, 8, 5, 7, 8, 5, 7, 5, 7}));

		result = d.rearrangeBarcodes(new int[] {1, 1, 1, 1, 2, 2, 3, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 3, 1, 2, 1, 2, 3, 1}));

		result = d.rearrangeBarcodes(
				new int[] {51, 83, 51, 40, 51, 40, 51, 40, 83, 40, 83, 83, 51, 40, 40, 51, 51, 51, 40, 40, 40, 83, 51, 51, 40,
						51,
						51, 40, 40, 51, 51, 40, 51, 51, 51, 40, 83, 40, 40, 83, 51, 51, 51, 40, 40, 40, 51, 51, 83, 83, 40, 51,
						51, 40, 40, 40, 51, 40, 83, 40, 83, 40, 83, 40, 51, 51, 40, 51, 51, 51, 51, 40, 51, 83, 51, 83, 51, 51,
						40, 51, 40, 51, 40, 51, 40, 40, 51, 51, 51, 40, 51, 83, 51, 51, 51, 40, 51, 51, 40, 40});
	}
}