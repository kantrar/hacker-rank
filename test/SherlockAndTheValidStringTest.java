import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SherlockAndTheValidStringTest {
	@Test
	public void test() {
		String result;
		result = SherlockAndTheValidString.isValid("aabbccddeefghi");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("aabbccddeeffgghhhii");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid("aabbccddeefffgghhhii");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("aabbccddeefffgghhhi");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("aabbccddeeffgghhi");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid("aabbccddeeffgghhiiii");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("aabbcd");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("aabbcdef");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("a");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid("abcd");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid("abcdde");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid("abcddee");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("abacbacb");
		Assert.assertThat(result, CoreMatchers.equalTo("NO"));

		result = SherlockAndTheValidString.isValid("abde");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid("aabbc");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

		result = SherlockAndTheValidString.isValid(
				"ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
		Assert.assertThat(result, CoreMatchers.equalTo("YES"));

	}
}