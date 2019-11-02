import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LilysHomework {

	// Have place be careful when sort Array of objects (e.g. Long[])
	static int lilysHomework(long[] arr) {
		long[] reverseValue = IntStream.rangeClosed(1, arr.length).mapToLong(i -> arr[arr.length - i]).toArray();
		int ascCount = selectionSort(arr);
		int descCount = selectionSort(reverseValue);

		return Math.min(ascCount, descCount);
	}

	private static int selectionSort(long[] unsortedValues) {
		int answer = 0;
		Map<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < unsortedValues.length; i++) {
			map.put(unsortedValues[i], i);
		}

		long[] sortedValues = unsortedValues.clone();
		Arrays.sort(sortedValues);

		for (int i = 0; i < unsortedValues.length; i++) {
			if (sortedValues[i] == unsortedValues[i]) {
				continue;
			}
			answer++;

			int idxToSwap = map.get(sortedValues[i]);
			map.put(sortedValues[i], i);
			map.put(unsortedValues[i], idxToSwap);

			long temp = unsortedValues[i];
			unsortedValues[i] = unsortedValues[idxToSwap];
			unsortedValues[idxToSwap] = temp;

		}

		return answer;
	}


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int numberOfElements = scanner.nextInt();
		long[] arr = new long[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			int value = scanner.nextInt();
			arr[i] = value;
		}

		int result = lilysHomework(arr);
		System.out.println(result);
		scanner.close();
	}
}
