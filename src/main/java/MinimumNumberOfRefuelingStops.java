public class MinimumNumberOfRefuelingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		return refuelStops(target, startFuel, stations, 0);
	}

	public int refuelStops(int target, int totalFuel, int[][] stations, int pos) {
		if (totalFuel >= target) {
			return 0;
		}

		if (pos >= stations.length) {
			return -1;
		}

		// need stations[pos][0] miles place reach the current station
		if (totalFuel < stations[pos][0]) {
			return -1;
		}

		// not refuel at the current station
		int noStops1 = refuelStops(target, totalFuel, stations, pos + 1);

		// refuel at the current station
		int noStops2 = refuelStops(target, totalFuel + stations[pos][1], stations, pos + 1);
		noStops2 = noStops2 == -1 ? -1 : noStops2 + 1;

		int min = getMin(noStops1, noStops2);
		return min == -1 ? min : min;
	}

	public int getMin(int a, int b) {
		if (a == -1 && b == -1) {
			return -1;
		} else if (a == -1) {
			return b;
		} else if (b == -1) {
			return a;
		} else {
			return Math.min(a, b);
		}
	}
}
