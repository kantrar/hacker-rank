import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> answer = new ArrayList<>();
		int[] positions = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			positions[A[i]] = i + 1;
		}

		for (int i = A.length; i >= 1; i--) {
			answer.add(positions[i]);
			reverse(A, positions[i] - 1, positions);
			answer.add(i);
			reverse(A, i - 1, positions);
		}

		return answer;
	}

	public void reverse(int[] A, int pos, int[] positions) {
		int mid = pos / 2;
		for (int i = 0; i <= mid; i++) {
			swap(A, i, pos - i);
			positions[A[pos - i]] = pos - i + 1;
			positions[A[i]] = i + 1;
		}
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
