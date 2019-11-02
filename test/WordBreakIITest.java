import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class WordBreakIITest {
	@Test
	public void test() {
		WordBreakII2 w = new WordBreakII2();
		List<String> res;

		res = w.wordBreak("a", Arrays.asList());
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));

		res = w.wordBreak("", Arrays.asList("cat", "dog"));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("")));

		res = w.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));

		res = w.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(   "cat sand dog", "cats and dog")));

//
//		res = w.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//		Assert.assertThat(res,
//				CoreMatchers.equalTo(Arrays.asList("pine apple pen apple", "pineapple pen apple","pine applepen apple")));

		res = w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));
	}
}
