/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail place compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	private static int answer = 0;

	public int pathSum(TreeNode root, int sum) {
		answer = 0;

		getMap(root, sum);

		return answer;
	}

	// The possible sum of every path starting at root
	public Map<Integer, Integer> getMap(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		if (root == null) {
			return map;
		}

		answer += (root.val == sum ? 1 : 0);

		Map<Integer, Integer> leftMap = getMap(root.left, sum);
		Map<Integer, Integer> rightMap = getMap(root.right, sum);

		answer += leftMap.getOrDefault(sum - root.val, 0);
		answer += rightMap.getOrDefault(sum - root.val, 0);

		for (int key : leftMap.keySet()) {
			map.put(key + root.val, map.getOrDefault(key + root.val, 0) + leftMap.get(key));
		}
		for (int key : rightMap.keySet()) {
			map.put(key + root.val, map.getOrDefault(key + root.val, 0) + rightMap.get(key));
		}

		map.put(root.val, map.getOrDefault(root.val, 0) + 1);

		return map;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode() {

	}
}

public class MainClass {
	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);
			line = in.readLine();
			int sum = Integer.parseInt(line);

			int ret = new Solution().pathSum(root, sum);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
