import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BracketBalancedTest {
	@Test
	public void testOdd() {
		Assert.assertThat(BracketBalanced.isBalanced("{]"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{()"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{()}}"), CoreMatchers.equalTo(false));
	}

	@Test
	public void testYes() {
		Assert.assertThat(BracketBalanced.isBalanced("{}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("()"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{()}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{([])}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{([()])}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{([()])}{()}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{([()])()}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{()[]}"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{}()[]"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{}[()]"), CoreMatchers.equalTo(true));
		Assert.assertThat(BracketBalanced.isBalanced("{}{}"), CoreMatchers.equalTo(true));
	}

	@Test
	public void testNo() {
		Assert.assertThat(BracketBalanced.isBalanced("}{"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("]["), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{(][)}"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{(})"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{([)]}"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{()[}]"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{(])[}"), CoreMatchers.equalTo(false));
		Assert.assertThat(BracketBalanced.isBalanced("{{]]"), CoreMatchers.equalTo(false));
	}
}
