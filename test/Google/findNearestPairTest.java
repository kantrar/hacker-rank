package Google;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class findNearestPairTest {
	@Test
	public void test() {
		int[][] input;
		int result;

		input = new int[][] {{1, 2, 0, 1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		input = new int[][] {
				{1, 0, 0, 0},
				{0, 0, 0, 2},
				{0, 0, 2, 0},
				{1, 0, 0, 0}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		input = new int[][] {
				{1, 1, 0, 0},
				{2, 0, 0, 2},
				{0, 0, 2, 0},
				{1, 0, 0, 0}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		input = new int[][] {
				{1, 1, 1, 0},
				{1, 0, 0, 2},
				{0, 0, 0, 0},
				{1, 0, 0, 0}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[][] {
				{1, 1, 1, 0},
				{1, 0, 0, 0},
				{0, 0, 0, 2},
				{1, 0, 2, 0}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));


		input = new int[][] {{1},{2}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		input = new int[][] {
				{1,0,0,2,0},
				{0,0,0,0,1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[][] {
				{1,1,1,2,1},
				{1,2,1,1,1},
				{1,1,1,2,1},
				{1,1,1,1,1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		input = new int[][] {
				{1,0,0,2,0},
				{0,2,0,0,1},
				{1,0,0,2,0},
				{1,0,1,0,1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[][] {
				{1,0,0,2,0},
				{0,2,0,0,1},
				{1,0,0,2,0},
				{1,0,1,0,1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[][] {
				{1,0,0,2,0},
				{0,2,0,0,1},
				{1,0,1,2,0},
				{1,0,1,0,1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		input = new int[][] {
				{1,0,0,2,0},
				{0,0,0,0,1},
				{1,0,0,2,0},
				{1,0,0,0,0}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[][] {
				{2,0,0,2,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,0,0,0,0}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[][] {
				{0,0,0,0,1},
				{1,0,0,0,0},
				{0,0,2,0,0},
				{1,0,0,0,1}};
		result = FindNearestPair.findNearestPair(input);
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}