import java.util.LinkedList;
import java.util.List;

public class PathInZigZagLabelledBinaryTree {
	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> ans = new LinkedList<>();
		int row = findRow(label);
		while (row > 0) {
			ans.add(0, label);

			int temp = (int) Math.pow(2, row - 1) + (int) Math.pow(2, row) - 1 - label;
			row--;
			label = temp / 2;
		}

		return ans;
	}

	private int findRow(int label) {
		return (int) Math.floor(Math.log(label) / Math.log(2)) + 1;
	}
}
