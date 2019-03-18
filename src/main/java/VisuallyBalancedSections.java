import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Incomplete
public class VisuallyBalancedSections {
	public static int visuallyBalancedSections(List<Integer> colors) {
		Map<Integer, Integer> counts = new HashMap<>();
		List<List<Integer>> oddColours = new ArrayList<>();
		counts.put(colors.get(0), 1);
		oddColours.add(Arrays.asList(colors.get(0)));
		for (int i = 1; i < colors.size(); i++) {
			int count = counts.getOrDefault(colors.get(i), 0);
			count++;
			counts.put(colors.get(i), count);

			List<Integer> newList = new ArrayList<>();
			newList.addAll(oddColours.get(i - 1));

			if (count % 2 == 1) {
				newList.add(colors.get(i));
				oddColours.add(newList);
			} else {
				newList.remove(colors.get(i));
				oddColours.add(newList);
			}
		}

		int answer = oddColours.size();

		for (int i = 0; i < oddColours.size(); i++) {
			for (int size = 2; i + size - 1 < oddColours.size(); size++) {
				int noOddColoursAtPos;
				if (i - 1 < 0) {
					noOddColoursAtPos = oddColours.get(i + size - 1).size();
				} else {
					//					noOddColoursAtPos = oddColours.get(i + size - 1).size() - oddColours.get(i - 1).size();
					Set<Integer> longSet = new HashSet<>(oddColours.get(i + size - 1));
					Set<Integer> shortSet = new HashSet<>(oddColours.get(i - 1));
					// Set of odd numbers that is no longer odd at the current position
					shortSet.removeAll(longSet);
					longSet.removeAll(shortSet);
					noOddColoursAtPos = longSet.size();
				}
				if (size % 2 == 1 && noOddColoursAtPos == 1) {
					answer++;
				} else if (size % 2 == 0 && noOddColoursAtPos == 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}
