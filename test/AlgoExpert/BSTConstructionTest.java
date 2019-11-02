package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BSTConstructionTest {
	@Test
	public void test() {
		BSTConstruction.BST root = new BSTConstruction.BST(10);
//		root.insert(15);
//		root.insert(8);
//		root.insert(14);
//		root.insert(12);
//
//		Assert.assertThat(root.contains(8), CoreMatchers.equalTo(true));
//		Assert.assertThat(root.contains(10), CoreMatchers.equalTo(true));
//		Assert.assertThat(root.contains(12), CoreMatchers.equalTo(true));
//		Assert.assertThat(root.contains(14), CoreMatchers.equalTo(true));
//		Assert.assertThat(root.contains(15), CoreMatchers.equalTo(true));
//		Assert.assertThat(root.contains(13), CoreMatchers.equalTo(false));
//		Assert.assertThat(root.contains(9), CoreMatchers.equalTo(false));
//		Assert.assertThat(root.contains(11), CoreMatchers.equalTo(false));
//
//		root.remove(12);
//		Assert.assertThat(root.contains(14), CoreMatchers.equalTo(true));
//		Assert.assertThat(root.contains(12), CoreMatchers.equalTo(false));

		root = new BSTConstruction.BST(10);
		root.insert(15).insert(11).insert(22).remove(10);
		Assert.assertThat(root.contains(10), CoreMatchers.equalTo(false));
		Assert.assertThat(root.contains(11), CoreMatchers.equalTo(true));
		Assert.assertThat(root.contains(15), CoreMatchers.equalTo(true));
		Assert.assertThat(root.contains(22), CoreMatchers.equalTo(true));

		root = new BSTConstruction.BST(10);
		root.insert(15).insert(11).remove(15);
		Assert.assertThat(root.contains(11), CoreMatchers.equalTo(true));
	}
}
