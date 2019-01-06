public class GoodLandElectricity {
	public static int pylons(int distance, int[] inputs) {

		int diameter = distance * 2 - 1;

		if (diameter / 2 >= inputs.length) {
			for (int input : inputs) {
				if (input == 1) {
					return 1;
				}
			}
			return -1;
		}

		int previousI = -1;
		int i = diameter / 2;
		int count = 0;
		int answer = 0;

		while (i < inputs.length) {
			if (inputs[i] == 1) {
				answer++;
				if (i + diameter / 2 >= inputs.length - 1) {
					break;
				}
				int newI = i + diameter;
				if (newI >= inputs.length) {
					newI = inputs.length - 1;
				}
				previousI = i;
				i = newI;
				count = 0;
			} else {
				int newI = i - 1;

				if (newI < 0) {
					return -1;
				}

				if(newI == previousI) {
					return -1;
				}

				i = newI;

			}
		}
		return answer;
	}
}
