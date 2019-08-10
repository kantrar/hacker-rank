import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SubstringWithConcatenationOfAllWordsTest {
	@Test
	public void test() {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		List<Integer> res;
		res = s.findSubstring("abababa", new String[] {"ab", "ba"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));

		res = s.findSubstring("ababaab", new String[] {"ab", "ba", "ba"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(1)));

		res = s.findSubstring("aaaaaa", new String[] {"aaa", "aaa"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0)));

		res = s.findSubstring("aaa", new String[] {"aa", "aa"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));

		res = s.findSubstring("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(6, 9, 12)));

		res = s.findSubstring("abdc", new String[] {"abdc"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0)));

		res = s.findSubstring("abdc", new String[] {"ab", "dc"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0)));

		res = s.findSubstring("abdc", new String[] {"ab", "dc"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0)));

		res = s.findSubstring("abdcba", new String[] {"ab", "dc"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0)));

		res = s.findSubstring("abdcabdc", new String[] {"ab", "dc"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0, 2, 4)));

		res = s.findSubstring("abdcabcdcab", new String[] {"ab", "dc"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0, 2, 7)));

		res = s.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(0, 9)));

		res = s.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));

		res = s.findSubstring("wordgoodgoodgoodbestword", new String[] {"ordg", "oodg", "oodg"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(1)));

		res = s.findSubstring("abdcdcccdoosdddggs", new String[] {"ordg", "oodg", "oodg"});
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));

	}
}