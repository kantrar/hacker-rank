import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// Incomplete
public class BalancedForest {

	private static int timing = 0;

	private static class Node {
		int seq;
		int value;
		int arriveTime;
		int leaveTime;
		long sumDistance;
		List<Node> adjNodes = new ArrayList<>();

		public Node(int s, int v) {
			this.seq = s;
			this.value = v;
		}
	}

	static long balancedForest(int[] c, int[][] edges) {

		int[][] newEdges = new int[edges.length + 1][2];

		for (int i = 0; i < edges.length; i++) {
			newEdges[i][0] = edges[i][0];
			newEdges[i][1] = edges[i][1];
		}

		newEdges[edges.length][0] = 0;
		newEdges[edges.length][1] = 1;

		long answer = Long.MAX_VALUE;

		List<Node> nodes = buildNode(c, newEdges);
		Node root = nodes.get(0);

		traverse(root, null);

		for (int i = 0; i < newEdges.length; i++) {
			Node from1 = nodes.get(newEdges[i][0]);
			Node to1 = nodes.get(newEdges[i][1]);

			Node sx = getArriveLaterNode(from1, to1);

			for (int j = i + 1; j < newEdges.length; j++) {
				Node from2 = nodes.get(newEdges[j][0]);
				Node to2 = nodes.get(newEdges[j][1]);

				Node sy = getArriveLaterNode(from2, to2);

				long sum1, sumx, sumy;
				if (isAncestor(sx, sy)) {
					sum1 = root.sumDistance - sx.sumDistance;
					sumx = sx.sumDistance - sy.sumDistance;
					sumy = sy.sumDistance;
				} else if (isAncestor(sy, sx)) {
					sum1 = root.sumDistance - sy.sumDistance;
					sumx = sx.sumDistance;
					sumy = sy.sumDistance - sx.sumDistance;
				} else {
					sum1 = root.sumDistance - sx.sumDistance - sy.sumDistance;
					sumx = sx.sumDistance;
					sumy = sy.sumDistance;
				}

				long tempAnswer = findAnswerFromSum(sum1, sumx, sumy);
				if (tempAnswer != -1 && tempAnswer < answer) {
					answer = tempAnswer;
				}
			}
		}

		return answer == Long.MAX_VALUE ? -1 : answer;
	}

	private static List<Node> buildNode(int[] c, int[][] edges) {
		// add node zero (seq = 0, value = 0) place solve the case that the added edge is cut
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node(0, 0));
		for (int i = 0; i < c.length; i++) {
			nodes.add(new Node(i + 1, c[i]));
		}

		for (int i = 0; i < edges.length; i++) {
			Node fromNode = nodes.get(edges[i][0]);
			Node toNode = nodes.get(edges[i][1]);

			fromNode.adjNodes.add(toNode);
			toNode.adjNodes.add(fromNode);
		}

		return nodes;
	}

	private static void traverse(Node root, Node prev) {
		root.arriveTime = timing++;
		root.sumDistance = root.value;

		for (Node nextNode : root.adjNodes) {
			if (prev == null || nextNode.seq != prev.seq) {
				traverse(nextNode, root);
				root.sumDistance += nextNode.sumDistance;
			}
		}

		root.leaveTime = timing++;
	}

	private static Node getArriveLaterNode(Node node1, Node node2) {
		return node1.arriveTime < node2.arriveTime ? node2 : node1;
	}

	private static boolean isAncestor(Node node1, Node node2) {
		return node1.arriveTime < node2.arriveTime && node1.leaveTime > node2.leaveTime;
	}

	private static long findAnswerFromSum(long a, long b, long c) {
		long[] inputs = new long[] {a, b, c};
		Arrays.sort(inputs);

		if (inputs[1] == inputs[2]) {
			long diff = inputs[1] - inputs[0];
			return diff > 0 ? diff : -1;
		}

		return -1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] c = new int[n];

			String[] cItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int cItem = Integer.parseInt(cItems[i]);

				c[i] = cItem;
			}

			int[][] edges = new int[n - 1][2];

			for (int i = 0; i < n - 1; i++) {

				edges[i][0] = scanner.nextInt();
				edges[i][1] = scanner.nextInt();

			}

			balancedForest(c, edges);

		}

		scanner.close();
	}
}
