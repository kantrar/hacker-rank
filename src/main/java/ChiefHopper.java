public class ChiefHopper {
	static int chiefHopper(int[] arr) {
		int energyNeeded = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			//if ((energyNeeded + arr[i]) % 2 == 0)
			energyNeeded = (energyNeeded + arr[i] + 1) / 2;
		}
		return energyNeeded;
	}
}
