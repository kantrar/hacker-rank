import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCameras {
	public static int minCameraCover(TreeNode root) {
		Map<TreeNode, Integer>[] monitoredMap = new HashMap[2];
		monitoredMap[0] = new HashMap<>();
		monitoredMap[1] = new HashMap<>();

		Map<TreeNode, Integer>[] notMonitoredMap = new HashMap[2];
		notMonitoredMap[0] = new HashMap<>();
		notMonitoredMap[1] = new HashMap<>();
		return find(root, monitoredMap, notMonitoredMap, false, 0);
	}

	private static int find(TreeNode root, Map<TreeNode, Integer>[] monitoredMap, Map<TreeNode, Integer>[] notMonitoredMap,
			boolean monitored, int depth) {
		if (root == null) return 0;
		if (monitored && monitoredMap[depth].containsKey(root)) {
			return monitoredMap[depth].get(root);
		}
		if (!monitored && notMonitoredMap[depth].containsKey(root)) {
			return notMonitoredMap[depth].get(root);
		}

		if (monitored) {
			int res = 0;
			if (depth == 1) {
				// at root
				int x = 1 + find(root.left, monitoredMap, notMonitoredMap, true, 1) + find(root.right, monitoredMap, notMonitoredMap, true, 1);
				// not at root
				int y = find(root.left, monitoredMap, notMonitoredMap, false, 0) + find(root.right, monitoredMap, notMonitoredMap, false, 0);
				res = Math.min(x, y);
			} else {
				res = find(root.left, monitoredMap, notMonitoredMap, true, 1) + find(root.right, monitoredMap, notMonitoredMap, true, 1);
			}
			monitoredMap[depth].put(root, res);
			return res;
		} else {
			// at root
			int x = 1 + find(root.left, monitoredMap, notMonitoredMap, true, 1) + find(root.right, monitoredMap, notMonitoredMap, true, 1);
			// at left child
			int y = 1 + find(root.left, monitoredMap, notMonitoredMap, true, 0) + find(root.right, monitoredMap, notMonitoredMap, false, 0);
			// at right child
			int z = 1 + find(root.left, monitoredMap, notMonitoredMap, false, 0) + find(root.right, monitoredMap, notMonitoredMap, true, 0);
			int res = Math.min(x, Math.min(y, z));
			notMonitoredMap[depth].put(root, res);
			return res;
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode();
		treeNode.left = new TreeNode();
		treeNode.right = null;
		treeNode.left.left = new TreeNode();
		treeNode.left.right = new TreeNode();

		int result = minCameraCover(treeNode);
		System.out.println(result);
	}
}
