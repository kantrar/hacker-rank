import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioningTest {
	@Test
	public void testOneElement() {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("a");
		Assert.assertThat(result.size(), CoreMatchers.equalTo(1));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a")));
	}

	@Test
	public void testTwoElementsNotPalindrome() {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("ab");
		Assert.assertThat(result.size(), CoreMatchers.equalTo(1));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "b")));
	}

	@Test
	public void testTwoElementsPalindrome() {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("aa");
		Assert.assertThat(result.size(), CoreMatchers.equalTo(2));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "a")));
		Assert.assertThat(result.get(1), CoreMatchers.equalTo(Arrays.asList("aa")));
	}

	@Test
	public void testThreeElementsNotPalindrome() {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("abc");
		Assert.assertThat(result.size(), CoreMatchers.equalTo(1));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "b", "c")));
	}

	@Test
	public void testThreeElementsOnePalindrome() {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("aba");
		Assert.assertThat(result.size(), CoreMatchers.equalTo(2));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "b", "a")));
		Assert.assertThat(result.get(1), CoreMatchers.equalTo(Arrays.asList("aba")));
	}

	@Test
	public void testThreeElementsAllPalindrome() {
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> result = p.partition("aaa");
		Assert.assertThat(result.size(), CoreMatchers.equalTo(4));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "a", "a")));
		Assert.assertThat(result.get(1), CoreMatchers.equalTo(Arrays.asList("a", "aa")));
		Assert.assertThat(result.get(2), CoreMatchers.equalTo(Arrays.asList("aa", "a")));
		Assert.assertThat(result.get(3), CoreMatchers.equalTo(Arrays.asList("aaa")));
	}
}