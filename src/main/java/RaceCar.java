import java.util.HashMap;
import java.util.Map;

public class RaceCar {
	public int racecar(int target) {
		Map<Integer, Integer>[] map = new HashMap[target + 1];
		for (int i = 0; i <= target; i++) {
			map[i] = new HashMap<>();
		}
		return racecar(target, 0, 1, map);
	}

	private int racecar(int target, int pos, int speed, Map<Integer, Integer>[] map) {
		if (pos == target) {
			return 0;
		}
		if (map[target].containsKey(speed)) {
			return map[target].get(speed);
		}

		int accelerate = (pos > target && speed > 0) ? Integer.MAX_VALUE : (1 + racecar(target, pos + speed, speed * 2, map));
		int reverse = pos < 0 ? Integer.MAX_VALUE : 1 + racecar(target, pos, speed > 0 ? -1 : 1, map);
		int res = Math.min(accelerate, reverse);
		map[target].put(speed, res);
		return res;
	}
}
