import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SmallestSubsequenceOfDistinctCharactersTest {
	@Test
	public void test() {
		SmallestSubsequenceOfDistinctCharacters s = new SmallestSubsequenceOfDistinctCharacters();
		String result;

		result = s.smallestSubsequence("leetcode");
		Assert.assertThat(result, CoreMatchers.equalTo("letcod"));

		result = s.smallestSubsequence("bdaccdbddc");
		Assert.assertThat(result, CoreMatchers.equalTo("abdc"));

		result = s.smallestSubsequence("cdadabcc");
		Assert.assertThat(result, CoreMatchers.equalTo("adbc"));

		result = s.smallestSubsequence("abcd");
		Assert.assertThat(result, CoreMatchers.equalTo("abcd"));

		result = s.smallestSubsequence("ecbacba");
		Assert.assertThat(result, CoreMatchers.equalTo("eacb"));

		result = s.smallestSubsequence("aaa");
		Assert.assertThat(result, CoreMatchers.equalTo("a"));

		result = s.smallestSubsequence("dabcbcb");
		Assert.assertThat(result, CoreMatchers.equalTo("dabc"));

	}
}