import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CommonChildStringTest {
	@Test
	public void test() {
		assertAnswer("AA", "BB", 0);
		assertAnswer("AAC", "BBD", 0);
		assertAnswer("AACD", "BBD", 1);
		assertAnswer("AACDAEFAGH", "ABBDCEG", 4);
		assertAnswer("SHINCHAN", "NOHARAAA", 3);
		assertAnswer("ABCDEF", "FBDAMN", 2);
		assertAnswer("ABCD", "CDEF", 2);
		assertAnswer("ABCD", "EF", 0);
		assertAnswer("ABCD", "EFGH", 0);
		assertAnswer("ABCD", "BEFGHD", 2);
		assertAnswer("ABCDEF", "BEFGHD", 3);
		assertAnswer("ABCDBCD", "BCEEFCGD", 4);
		assertAnswer("ABCDEBCD", "BCEEFCGD", 5);
		assertAnswer("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC",
				15);
	}

	private void assertAnswer(String A, String B, int expected) {
		int result = CommonChildString.commonChild(A, B);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}