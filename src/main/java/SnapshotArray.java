import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class SnapshotArray {
	// index -> snapshotId -> value
	Map<Integer, TreeMap<Integer, Integer>> diffMap;
	int currentSnapId;

	public SnapshotArray(int length) {
		currentSnapId = 0;
		diffMap = new HashMap<>();
	}

	public void set(int index, int val) {
		if (!diffMap.containsKey(index)) {
			diffMap.put(index, new TreeMap<>());
		}
		diffMap.get(index).put(currentSnapId, val);
	}

	public int snap() {
		currentSnapId++;
		return currentSnapId - 1;
	}

	public int get(int index, int snapId) {
		int res = 0;
		TreeMap<Integer, Integer> snapshotToValue = diffMap.getOrDefault(index, new TreeMap<>());

		Integer key = snapshotToValue.floorKey(snapId);
		if (snapshotToValue.isEmpty() || key == null) {
			return res;
		}
		res = snapshotToValue.getOrDefault(key, 0);
		return res;
	}

	public static void main(String[] args) {
		SnapshotArray snapshotArray = new SnapshotArray(3);
		snapshotArray.set(0, 5);
		int snapId = snapshotArray.snap();
		snapshotArray.set(0, 6);
		// 0
		System.out.println(snapId);

		int value = snapshotArray.get(0, 0);
		// 5
		System.out.println(value);

		snapId = snapshotArray.snap();
		// 1
		System.out.println(snapId);

		value = snapshotArray.get(0, 0);
		// 5
		System.out.println(value);

		value = snapshotArray.get(0, 1);
		// 6
		System.out.println(value);

		value = snapshotArray.get(1, 1);

		// 0
		System.out.println(value);

		snapshotArray.set(0, -2);
		snapId = snapshotArray.snap();
		// 2
		System.out.println(snapId);
		value = snapshotArray.get(0, 2);
		// - 2
		System.out.println(value);
		value = snapshotArray.get(0, 1);
		// 6
		System.out.println(value);
		value = snapshotArray.get(0, 0);
		// 5
		System.out.println(value);
		System.out.println();

		SnapshotArray s = new SnapshotArray(2);
		int id = s.snap();
		System.out.println(id);
		int v = s.get(1, 0);
		System.out.println(v);
		v = s.get(0, 0);
		System.out.println(v);
		s.set(1, 8);

		v = s.get(1, 0);
		System.out.println(v);

		s.set(0, 20);

		v = s.get(0, 0);
		System.out.println(v);

		s.set(0, 7);
	}
}
