import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComponentsInAGraph {
	static int[] componentsInGraph(int[][] gb) {
		Map<Integer, Set<Integer>> map = new HashMap<>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int[] vertex : gb) {
			Set<Integer> componentA = map.getOrDefault(vertex[0], new HashSet<>());
			componentA.add(vertex[0]);
			Set<Integer> componentB = map.getOrDefault(vertex[1], new HashSet<>());
			componentB.add(vertex[1]);

			componentA.addAll(componentB);

			map.put(vertex[0], componentA);

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
