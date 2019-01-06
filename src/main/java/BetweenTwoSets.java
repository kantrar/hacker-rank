import java.util.ArrayList;

public class BetweenTwoSets {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList();
		numbers.add(14);
		numbers.add(6);
		System.out.println("GCD: " + getGCD(numbers));
		System.out.println("LCM: " + getLCM(numbers));
	}

	private static int getLCM(ArrayList<Integer> numbers) {
		int result = numbers.get(0);
		for (Integer number : numbers) {
			result = getLCM(result, number);
		}
		return result;
	}

	private static int getLCM(int a, int b) {
		return a * b / getGCD(a, b);
	}

	private static int getGCD(ArrayList<Integer> numbers) {
		int result = numbers.get(0);
		for (Integer number : numbers) {
			result = getGCD(result, number);
		}
		return result;
	}

	private static int getGCD(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
