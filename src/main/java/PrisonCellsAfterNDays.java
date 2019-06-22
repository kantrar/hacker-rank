import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PrisonCellsAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
		int[] newCells = new int[cells.length];
		newCells[0] = 0;
		newCells[cells.length - 1] = 0;
		for (int i = 1; i < cells.length - 1; i++) {
			newCells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
		}
		N--;

		Set<Integer> set = new LinkedHashSet<>();
		set.add(getBits(newCells));

		while (N > 0) {
			System.arraycopy(newCells, 0, cells, 0, 8);
			for (int i = 1; i < cells.length - 1; i++) {
				newCells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
			}
			int key = getBits(newCells);
			if (set.contains(key)) {
				N--;
				break;
			}
			set.add(key);
			N--;
		}

		List<Integer> list = new ArrayList<>(set);
		int idx = list.indexOf(getBits(newCells));
		int size = list.size();

		int target = list.get(idx + (N - idx) % (size - idx));

		return getArray(target);

	}

	public int getBits(int[] cells) {
		int value = 0;
		for (int i = 0; i < cells.length; i++) {
			value += (cells[i] << (cells.length - i - 1));
		}
		return value;
	}

	public int[] getArray(int target) {
		int[] result = new int[8];
		int i = 7;
		while (i >= 0) {
			result[i] = target % 2;
			target = target / 2;
			i--;
		}

		return result;
	}
}
