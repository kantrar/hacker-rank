import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DecibinaryNumbersTest {
	@Test
	public void test() {
		assertDecibinaryNumber(5, 3L);
		assertDecibinaryNumber(6, 11L);
		assertDecibinaryNumber(7, 4L);
		assertDecibinaryNumber(8, 12L);
		assertDecibinaryNumber(9, 20L);
		assertDecibinaryNumber(10, 100L);
		assertDecibinaryNumber(20, 110L);

		assertDecibinaryNumber(8, 12L);
		assertDecibinaryNumber(23, 23L);
		assertDecibinaryNumber(19, 102L);
		assertDecibinaryNumber(16, 14L);
		assertDecibinaryNumber(26, 111L);

		assertDecibinaryNumber(25, 103L);
		assertDecibinaryNumber(20, 110L);
		assertDecibinaryNumber(10, 100L);
		assertDecibinaryNumber(27, 8L);
		assertDecibinaryNumber(24, 31L);
		assertDecibinaryNumber(30, 32L);
		assertDecibinaryNumber(11, 5L);
	}

	private void assertDecibinaryNumber(int i, long l) {
		long result = DecibinaryNumbers.decibinaryNumbers(i);
		Assert.assertThat(result, CoreMatchers.equalTo(l));
	}
}