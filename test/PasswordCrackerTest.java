import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PasswordCrackerTest {
	@Test
	public void test() {
		List<String> passwords = Arrays.asList("because", "can", "do", "must", "we", "what");
		String pw = "wedowhatwemustbecausewecan";
		Assert.assertThat(PasswordCracker.passwordCracker(passwords, pw),
				CoreMatchers.equalTo("we do what we must because we can"));
	}
}