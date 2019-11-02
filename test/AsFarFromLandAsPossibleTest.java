import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class AsFarFromLandAsPossibleTest {
	@Test
	public void test() {
		AsFarFromLandAsPossible a = new AsFarFromLandAsPossible();
		int result;
		result = a.maxDistance(
				new int[][] {
						{1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
						{1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
						{0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
						{1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
						{0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
						{0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
						{0, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
						{1, 1, 0, 1, 1, 1, 1, 1, 0, 0}});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}
