import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HighestValuePalindromeTest {

	@Test
	public void test() {
		// 1998 -> 8998 (change = 1), 9999 (change = 2)
		// 1271 -> 9779 (change = 3), 1771 (change = 1)
		// 6243 -> 6446 (change = 2)
		// 6243 -> 9449 (change = 3) not 6996
		// 6223 -> 9229 (change = 3) not 6996
		assertHighestValuePalindrome("1998", 1, "8998");
		assertHighestValuePalindrome("1998", 2, "9999");
		assertHighestValuePalindrome("19598", 2, "99599");
		assertHighestValuePalindrome("19598", 1, "89598");
		assertHighestValuePalindrome("1271", 3, "9779");
		assertHighestValuePalindrome("12671", 3, "97679");
		assertHighestValuePalindrome("1271", 1, "1771");
		assertHighestValuePalindrome("12871", 1, "17871");
		assertHighestValuePalindrome("6243", 2, "6446");
		assertHighestValuePalindrome("6243", 1, "-");
		assertHighestValuePalindrome("6243", 3, "9449");
		assertHighestValuePalindrome("6223", 3, "9229");
		assertHighestValuePalindrome("628843", 3, "948849");
		assertHighestValuePalindrome("628823", 3, "928829");
		assertHighestValuePalindrome("62823", 3, "92929");
		assertHighestValuePalindrome("62823", 5, "99999");
		assertHighestValuePalindrome("628823", 6, "999999");
		assertHighestValuePalindrome("1", 2, "9");
		assertHighestValuePalindrome("1", 1, "9");
		assertHighestValuePalindrome("1", 0, "1");
		assertHighestValuePalindrome("11", 2, "99");
		assertHighestValuePalindrome("11", 1, "11");
		assertHighestValuePalindrome("11", 0, "11");
		assertHighestValuePalindrome("12", 0, "-");
		assertHighestValuePalindrome("12", 1, "22");
		assertHighestValuePalindrome("111", 3, "999");
		assertHighestValuePalindrome("111", 2, "919");
		assertHighestValuePalindrome("111", 1, "191");
		assertHighestValuePalindrome("111", 0, "111");

		assertHighestValuePalindrome("191", 2, "999");
		assertHighestValuePalindrome("911", 1, "919");
		assertHighestValuePalindrome("911", 2, "999");
		assertHighestValuePalindrome("811", 2, "919");
		assertHighestValuePalindrome("8111111111115", 2, "9111111111119");
		assertHighestValuePalindrome("8111111111115", 4, "9911111111199");

		assertHighestValuePalindrome("8111111111115", 5, "9911119111199");
		assertHighestValuePalindrome("8765678", 1, "8769678");
		assertHighestValuePalindrome("8765678", 2, "9765679");
		assertHighestValuePalindrome("8765678", 3, "9769679");
		assertHighestValuePalindrome("8765678", 4, "9965699");
		assertHighestValuePalindrome("8765678", 5, "9969699");
		assertHighestValuePalindrome("8765678", 6, "9995999");
		assertHighestValuePalindrome("8765678", 7, "9999999");
		assertHighestValuePalindrome("8765678", 8, "9999999");
		assertHighestValuePalindrome("8765678", 9, "9999999");

		assertHighestValuePalindrome("123455", 1, "-");
		assertHighestValuePalindrome("123455", 2, "-");
		assertHighestValuePalindrome("123455", 3, "554455");
		assertHighestValuePalindrome("123455", 4, "954459");
		assertHighestValuePalindrome("123455", 5, "994499");
		assertHighestValuePalindrome("123455", 6, "999999");

		assertHighestValuePalindrome("0000", 1, "0000");
		assertHighestValuePalindrome("0000", 2, "9009");
		assertHighestValuePalindrome("0000", 4, "9999");
		assertHighestValuePalindrome("0123", 4, "9999");
		assertHighestValuePalindrome("0120", 2, "0990");
		assertHighestValuePalindrome("0120", 3, "9229");
		assertHighestValuePalindrome("11119111", 4, "91199119");
		assertHighestValuePalindrome("1111911", 4, "9199919");
		assertHighestValuePalindrome("329", 2, "999");
	}

	private void assertHighestValuePalindrome(String input, int change, String expected) {
		String result = HighestValuePalindrome.highestValuePalindrome(input, input.length(), change);
		System.out.println(result);
		assertTrue(result.equals(expected));
	}
}