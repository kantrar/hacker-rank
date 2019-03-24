import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TheStoryOfATreeTest {
	@Test
	public void test() {
		String result;
		result = TheStoryOfATree.storyOfATree(4, new int[][] {{1, 2}, {1, 3}, {3, 4}}, 2, new int[][] {{1, 2}, {3, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo("1/2"));

		result = TheStoryOfATree.storyOfATree(4, new int[][] {{1, 2}, {1, 3}, {3, 4}}, 1, new int[][] {{1, 2}, {3, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo("1/1"));

		result = TheStoryOfATree.storyOfATree(3, new int[][] {{1, 2}, {1, 3}}, 1, new int[][] {{2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo("0/1"));

		result = TheStoryOfATree.storyOfATree(3, new int[][] {{1, 2}, {1, 3}}, 1, new int[][] {{2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo("0/1"));

		result = TheStoryOfATree.storyOfATree(9, new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}, {8, 9}}, 8,
				new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}, {8, 9}});
		Assert.assertThat(result, CoreMatchers.equalTo("1/9"));

		result = TheStoryOfATree.storyOfATree(9, new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}, {8, 9}}, 7,
				new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}, {8, 9}});
		Assert.assertThat(result, CoreMatchers.equalTo("1/3"));

		result = TheStoryOfATree.storyOfATree(9, new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}, {8, 9}}, 1,
				new int[][] {{1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}, {8, 9}});
		Assert.assertThat(result, CoreMatchers.equalTo("1/1"));
	}
}