import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ParlindromePartitioningTest {
	@Test
	public void test() {
		ParlindromePartitioning p = new ParlindromePartitioning();
		List<List<String>> result;
		result = p.partition("aba");

		Assert.assertThat(result.size(), CoreMatchers.equalTo(2));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "b", "a")));
		Assert.assertThat(result.get(1), CoreMatchers.equalTo(Arrays.asList("aba")));

		result = p.partition("aab");

		Assert.assertThat(result.size(), CoreMatchers.equalTo(2));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "a", "b")));
		Assert.assertThat(result.get(1), CoreMatchers.equalTo(Arrays.asList("aa", "b")));

		result = p.partition("abaaa");

		Assert.assertThat(result.size(), CoreMatchers.equalTo(6));
		Assert.assertThat(result.get(0), CoreMatchers.equalTo(Arrays.asList("a", "b", "a", "a", "a")));
		Assert.assertThat(result.get(1), CoreMatchers.equalTo(Arrays.asList("a", "b", "a", "aa")));
		Assert.assertThat(result.get(2), CoreMatchers.equalTo(Arrays.asList("a", "b", "aa", "a")));
		Assert.assertThat(result.get(3), CoreMatchers.equalTo(Arrays.asList("a", "b", "aaa")));
		Assert.assertThat(result.get(4), CoreMatchers.equalTo(Arrays.asList("aba", "a", "a")));
		Assert.assertThat(result.get(5), CoreMatchers.equalTo(Arrays.asList("aba", "aa")));
	}
}