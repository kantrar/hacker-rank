import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestStringChainTest {
	LongestStringChain l = new LongestStringChain();
	int res;

	@Test
	public void testSimpleEmpty() {
		assertChain(new String[] {}, 0);
	}

	@Test
	public void testSimple() {
		assertChain(new String[] {"a"}, 1);

		assertChain(new String[] {"a", "b", "c"}, 1);

		assertChain(new String[] {"bc"}, 1);
	}

	private void assertChain(String[] words, int expected) {
		res = l.longestStrChain(words);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}

	@Test
	public void testChain() {
		assertChain(new String[] {"a", "b", "ba", "bca"}, 3);
		assertChain(new String[] {"a", "b", "ba"}, 2);
		assertChain(new String[] {"a", "b", "ba", "bca", "bda"}, 3);
		assertChain(new String[] {"a", "b", "ba", "bca", "bda", "bdca"}, 4);

		assertChain(new String[] {"a", "ba", "bca", "bda", "bdca"}, 4);

		assertChain(new String[] {"a", "d", "ba", "bca", "bda", "bdca"}, 4);

		assertChain(new String[] {"a", "d", "de", "ad", "ede"}, 3);
		assertChain(new String[] {"a", "d", "de", "ad", "fed"}, 2);
		assertChain(new String[] {"a", "d", "de", "ad", "def"}, 3);
		assertChain(new String[] {"a", "d", "de", "ad", "fde"}, 3);
		assertChain(new String[] {"a", "d", "de", "ad", "fdg"}, 2);

		assertChain(
				new String[] {"a", "b", "d", "ab", "ad", "br", "ck", "cfk", "atb", "brw", "xyz", "krm", "cfkg", "abtg", "brww"},
				4);
	}

	@Test
	public void testComplex() {
		assertChain(new String[] {"sgtnz", "sgtz", "sgz", "ikrcyoglz", "ajelpkpx", "ajelpkpxm", "srqgtnz", "srqgotnz", "srgtnz",
				"ijkrcyoglz"}, 6);

		assertChain(new String[] {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr",
				"grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}, 7);
	}
}