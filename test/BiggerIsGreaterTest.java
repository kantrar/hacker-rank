import org.junit.Assert;
import org.junit.Test;

public class BiggerIsGreaterTest {
	@Test
	public void test() {
		assertSolution("ab", "ba");
		assertSolution("a", "no answer");
		assertSolution("ca", "no answer");
		assertSolution("bb", "no answer");
		assertSolution("bab", "bba");
		assertSolution("baab", "baba");
		assertSolution("baaa", "no answer");

		assertSolution("aab", "aba");
				assertSolution("aba", "baa");
		assertSolution("baa", "no answer");

		assertSolution("abcd", "abdc");
		assertSolution("abdc", "acbd");
		assertSolution("acbd", "acdb");
		assertSolution("acdb", "adbc");
		assertSolution("adbc", "adcb");
		assertSolution("adcb", "bacd");
		assertSolution("bacd", "badc");
		assertSolution("badc", "bcad");
		assertSolution("bcad", "bcda");
		assertSolution("bcda", "bdac");
		assertSolution("bdac", "bdca");
		assertSolution("bdca", "cabd");
		assertSolution("cabd", "cadb");
		assertSolution("cadb", "cbad");
		assertSolution("cbad", "cbda");
		assertSolution("cbda", "cdab");
		assertSolution("cdab", "cdba");
		assertSolution("cdba", "dabc");
		assertSolution("dabc", "dacb");
		assertSolution("dacb", "dbac");
		assertSolution("dbac", "dbca");
		assertSolution("dbca", "dcab");
		assertSolution("dcab", "dcba");
		assertSolution("dcba", "no answer");

		assertSolution("abedc", "acbde");
		assertSolution("abdec", "abecd");

	}

	private static void assertSolution(String input, String expected) {
		Assert.assertTrue(BiggerIsGreater.biggerIsGreater(input).equals(expected));
	}
}
