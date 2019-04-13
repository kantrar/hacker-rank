import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
	public String guess(String expected, String guess) {
		int correct = 0;
		int wrongLocation = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < expected.length(); i++) {
			char key = expected.charAt(i);
			if (key == guess.charAt(i)) {
				correct++;
			} else {
				int count = map.getOrDefault(key, 0);
				map.put(key, count + 1);
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			char key = guess.charAt(i);
			if (key != expected.charAt(i)) {
				if (map.getOrDefault(key, 0) > 0) {
					wrongLocation++;
					map.put(key, map.get(key) - 1);
				}
			}
		}

		return composeString(correct, wrongLocation);
	}

	private String composeString(int correct, int wrongLocation) {
		return String.format("%dA%dB", correct, wrongLocation);
	}

	public static void main(String[] args) {
		BullsAndCows bullsAndCows = new BullsAndCows();
		String result = bullsAndCows.guess("1108", "7111");
		System.out.println(result);
	}
}
