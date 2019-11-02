import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TallestBillboardTest {
	TallestBillboard t = new TallestBillboard();
	int res;

	@Test
	public void test() {
//		assertMethod(new int[] {}, 0);
//		assertMethod(new int[] {1}, 0);
//		assertMethod(new int[] {1, 2}, 0);
//		assertMethod(new int[] {1, 2, 3, 4}, 5);
		assertMethod(new int[] {1, 2, 3, 4, 5, 6}, 10);
		assertMethod(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 27);
		assertMethod(new int[] {1, 17, 100}, 0);
		assertMethod(new int[] {50, 17, 83, 100}, 100);
		assertMethod(new int[] {50, 151, 51, 1, 2, 3}, 53);
		assertMethod(new int[] {50, 151, 80, 1, 2, 3}, 3);
		assertMethod(new int[] {50, 151, 80, 1, 17, 3}, 151);
	}

	private void assertMethod(int[] rods, int expected) {
		res = t.tallestBillboard(rods);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
