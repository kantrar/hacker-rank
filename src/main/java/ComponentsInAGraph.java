import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComponentsInAGraph {

	static int[] componentsInGraph(int[][] gb) {
		if (gb.length == 0) {
			return new int[] {0, 0};
		}

		int[] parents = new int[30001];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> frequencies = new HashMap<>();

		for (int[] vertices : gb) {
			int u = vertices[0];
			int v = vertices[1];

			int rootParentU = getRootparent(parents, u);
			int rootParentV = getRootparent(parents, v);

			if (rootParentU != rootParentV) {

				if (rootParentU < rootParentV) {
					updateFrequency(frequencies, rootParentU, rootParentV);
					parents[v] = rootParentU;
				} else {
					updateFrequency(frequencies, rootParentV, rootParentU);
					parents[u] = rootParentV;
				}
			}
		}

		for (Integer frequency : frequencies.values()) {
			if (min > frequency) {
				min = frequency;
			}

			if (max < frequency) {
				max = frequency;
			}
		}

		return new int[] {min, max};
	}

	private static int getRootparent(int[] parents, int u) {
		while (parents[u] != u && parents[u] != 0) {
			u = parents[u];
		}
		return u;
	}

	private static void updateFrequency(Map<Integer, Integer> frequencies, int u, int v) {
		int currentFrequencyU = frequencies.getOrDefault(u, 1);
		int currentFrequencyV = frequencies.getOrDefault(v, 1);

		frequencies.put(u, currentFrequencyU + currentFrequencyV);
	}

	static int[] componentsInGraph2(int[][] gb) {
		Map<Integer, Set<Integer>> map = new HashMap<>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int[] vertices : gb) {
			Set<Integer> componentA = map.getOrDefault(vertices[0], new HashSet<>());
			componentA.add(vertices[0]);
			Set<Integer> componentB = map.getOrDefault(vertices[1], new HashSet<>());
			componentB.add(vertices[1]);

			componentA.addAll(componentB);

			map.put(vertices[0], componentA);

			for (Integer v : componentB) {
				map.put(v, componentA);
			}
		}

		for (Set<Integer> set : map.values()) {
			int noOfComponent = set.size();
			if (noOfComponent > max) {
				max = noOfComponent;
			}

			if (noOfComponent < min) {
				min = noOfComponent;
			}
		}

		return new int[] {min == Integer.MAX_VALUE ? 0 : min, max == Integer.MIN_VALUE ? 0 : max};
	}
}
