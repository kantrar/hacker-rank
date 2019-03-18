import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CoinOnTheTableTest {
	@Test
	public void testCoinOnTheTable() {
		int result;
		result = CoinOnTheTable.coinOnTheTable(1, new String[] {"RD", "*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(0, new String[] {"RD", "*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.coinOnTheTable(2, new String[] {"RD", "*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(3, new String[] {"RD", "*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.coinOnTheTable(0, new String[] {"RD", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.coinOnTheTable(1, new String[] {"RD", "*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(0, new String[] {"RRD", "LL*", "UUU"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.coinOnTheTable(3, new String[] {"RRD", "LL*", "UUU"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.coinOnTheTable(4, new String[] {"RRD", "LL*", "UUU"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.coinOnTheTable(5, new String[] {"RRD", "UUD", "U*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.coinOnTheTable(7, new String[] {"RRD", "DLL", "R*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.coinOnTheTable(10, new String[] {"RRD", "DLL", "U*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(8, new String[] {"RRD", "DLL", "U*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(1, new String[] {"RU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.coinOnTheTable(2, new String[] {"RU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(1, new String[] {"LU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.coinOnTheTable(2, new String[] {"LU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.coinOnTheTable(4, new String[] {"LU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.coinOnTheTable(50, new String[] {"LLU", "RRD", "L*D"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.coinOnTheTable(3, new String[] {"LLU", "LRD", "L*D"});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = CoinOnTheTable.coinOnTheTable(3, new String[] {"LLU", "LRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = CoinOnTheTable.coinOnTheTable(10, new String[] {"LLU", "LRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.coinOnTheTable(3, new String[] {"LLU", "RRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.coinOnTheTable(10, new String[] {"LLU", "RRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(2, new String[] {"RRD", "U*D", "ULL"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(10, new String[] {"RRD", "U*D", "ULL"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.coinOnTheTable(4, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.coinOnTheTable(3, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));
	}

	@Test
	public void testCoinOnTheTable2() {
		int result;
		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RD", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.cointOnTheTable2(1, new String[] {"RD", "*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRD", "LL*", "UUU"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRD", "UUD", "U*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRD", "DLL", "R*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRD", "DLL", "U*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRD", "DLL", "U*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(1, new String[] {"RU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.cointOnTheTable2(1, new String[] {"LU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"LU", "L*"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"LLU", "RRD", "L*D"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"LLU", "LRD", "L*D"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"LLU", "LRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"LLU", "RRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"LLU", "LRD", "L*L"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRD", "U*D", "ULL"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(1, new String[] {"RRD", "U*D", "ULL"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.cointOnTheTable2(1, new String[] {"RRD", "U*D", "ULL"});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = CoinOnTheTable.cointOnTheTable2(2, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.cointOnTheTable2(1, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(0, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(-1));

		result = CoinOnTheTable.cointOnTheTable2(3, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = CoinOnTheTable.cointOnTheTable2(10, new String[] {"RRRRD", "URRDD", "UU*DD", "UULLD", "ULLLD"});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}