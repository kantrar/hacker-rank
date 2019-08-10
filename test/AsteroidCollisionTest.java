import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class AsteroidCollisionTest {
	AsteroidCollision a = new AsteroidCollision();
	int[] res;

	@Test
	public void test() {
		assertResult(new int[] {}, new int[] {});
		assertResult(new int[] {5, 10, -5}, new int[] {5, 10});
		assertResult(new int[] {8, -8}, new int[] {});
		assertResult(new int[] {10, 2, -5}, new int[] {10});
		assertResult(new int[] {-2, -1, 1, 2}, new int[] {-2, -1, 1, 2});
		assertResult(new int[] {2, 1, -1, -2}, new int[] {});
		assertResult(new int[] {10, 8, 7, -5, -3}, new int[] {10, 8, 7});
		assertResult(new int[] {10, 8, 2, -5, -3}, new int[] {10, 8});
		assertResult(new int[] {10, 8, 2, -20, -3}, new int[] {-20, -3});
		assertResult(new int[] {10, 8, 2, -2, -20, -3}, new int[] {-20, -3});
	}

	private void assertResult(int[] input, int[] expected) {
		res = a.asteroidCollision(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}