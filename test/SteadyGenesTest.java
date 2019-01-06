import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SteadyGenesTest {
	@Test
	public void testSimpleSteadyGene() {
		assertGene("AGTC", 0);
	}

	private void assertGene(String gene, int expected) {
		Assert.assertThat(SteadyGenes.steadyGene(gene), CoreMatchers.equalTo(expected));
	}

	@Test
	public void testSimpleSteadyGene2() {
		assertGene("GTAC", 0);
	}

	@Test
	public void testSimpleUnsteadyGene() {
		assertGene("AAGC", 1);
	}

	@Test
	public void testSimpleUnsteadyGene2() {
		assertGene("GTTA", 1);
	}

	@Test
	public void test8XSteadyGene() {
		assertGene("AGGCTACT", 0);
	}

	@Test
	public void test8XUnsteadyGene() {
		assertGene("GAAATAAA", 5);
	}

	@Test
	public void test8XUnSteadyGene() {
		assertGene("AAAAAAAA", 6);
	}

	@Test
	public void test16XSteadyGene() {
		assertGene("AAAAGGGGTTTTCCCC", 0);
	}

	@Test
	public void test16XSteadyGene2() {
		assertGene("AGTAGGATTCATCCGC", 0);
	}

	@Test
	public void test16XUnsteadyGene() {
		assertGene("AAAAAAAAAAAAAAAA", 12);
	}

	@Test
	public void test16XUnsteadyGene2() {
		assertGene("AGTAAAATTCATCCGC", 2);
	}

	@Test
	public void test16XUnsteadyGene3() {
		assertGene("AGTAATATGGGCATGC", 2);
	}

	@Test
	public void test16XUnsteadyGene4() {
		assertGene("AATAATATAAACATAC", 8);
	}
}
