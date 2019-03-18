import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class NuclearFusion {
	public static class Vessel {
		int seq;
		private List<Vessel> aElements;
		private int bElements;
		private Vessel parent;
		private int height;

		public Vessel(int s) {
			this.seq = s;
			aElements = new ArrayList<>();
		}

		public int getSeq() {
			return seq;
		}
	}

	// Incomplete
	public static void nuclearFusion(List<Integer> elements) {
		List<Integer> childElems = new ArrayList<>();
		List<Vessel> vessels = new ArrayList<>();
		vessels.add(new Vessel(-1));
		for (int i = 0; i <= elements.size(); i++) {
			vessels.add(new Vessel(i + 1));
			childElems.add(i + 1);
		}

		vessels.get(1).parent = null;
		for (int i = 0; i < elements.size(); i++) {
			vessels.get(i + 2).parent = vessels.get(elements.get(i));
			if (childElems.contains(elements.get(i))) {
				childElems.remove(elements.get(i));
			}
		}

		Collections.sort(vessels, Comparator.comparingInt(Vessel::getSeq));

		Map<Integer, List<Integer>> mapByTime = new HashMap<>();

		// elements now contain only leaf nodes
		LinkedList<Integer> queue = new LinkedList<>();

		queue.addAll(childElems);
		mapByTime.put(0, childElems);

		int time = 1;
		while (true) {
			List<Integer> arrayList = new ArrayList<>();

			while (!queue.isEmpty()) {
				int seq = queue.remove();
				if (vessels.get(seq).parent == null) {
					break;
				}
				arrayList.add(vessels.get(seq).parent.seq);
			}

			if (arrayList.isEmpty()) {
				break;
			}

			Collections.sort(arrayList);

			mapByTime.put(time, arrayList);
			queue.addAll(arrayList);
			time++;
		}

		queue = new LinkedList<>();

		Map<Integer, Integer> fusedList = new TreeMap<>();
		Queue<Integer> unfusedList = new PriorityQueue<>();

		while (time >= 0) {
			List<Integer> vList = mapByTime.get(time);

			queue.addAll(vList);
			while (!queue.isEmpty()) {
				int seq = queue.remove();

				if (!queue.contains(vessels.get(seq).parent)) {
					queue.add(vessels.get(seq).parent.seq);
				}

				if (vessels.get(seq).aElements.size() >= 2) {
					for (int i = vessels.get(seq).aElements.size() - 2; i >= 0; i--) {
						fusedList.put(vessels.get(seq).aElements.get(i).seq, vessels.get(seq).aElements.get(i + 1).seq);
					}
				}

				if (vessels.get(seq).aElements.size() % 2 == 0) {
					if (vessels.get(seq).parent == null) {
						break;
					}
				} else {
					if (vessels.get(seq).parent == null) {
						unfusedList.add(vessels.get(seq).aElements.get(0).seq);
						break;
					}
				}

				vessels.get(seq).parent.aElements.add(vessels.get(seq));
			}

			time--;
		}

		System.out.println(unfusedList.size());
		while (!queue.isEmpty()) {
			int v = queue.remove();
			System.out.println(v);
		}

		System.out.println(fusedList.size());

		for (Integer integer : fusedList.keySet()) {
			System.out.print(integer + " " + fusedList.get(integer));
		}
	}
}

