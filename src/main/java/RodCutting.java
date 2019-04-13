import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RodCutting {
	// 1. Store the length after cut, the cut part => the remaining length
	public List<Integer> rodCut(int length, List<Integer> weakPoints) {
		List<Integer> remainingList = new ArrayList<>();
		for (int i = 0; i < weakPoints.size(); i++) {
			int remainingLength = Math.max(length - weakPoints.get(i), weakPoints.get(i));
			remainingList.add(remainingLength);
		}

		Collections.sort(remainingList);

		List<Integer> answers = new ArrayList<>();
		cutUtil(length, weakPoints, answers);
		return answers;
	}

	private void cutUtil(int length, List<Integer> remainingList, List<Integer> answers) {
		if (remainingList.size() == 0) {
			return;
		}

		int mid = findMid(remainingList, length);

		answers.add(remainingList.get(mid));

		List<Integer> firstList = remainingList.subList(0, mid);
		cutUtil(mid, firstList, answers);

		List<Integer> secondList = remainingList.subList(mid + 1, length);
		cutUtil(length - mid, secondList, answers);

	}

	private int findMid(List<Integer> remainingList, int length) {
		int midValue = length / 2;
		int minIdx = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < remainingList.size(); i++) {
			int diff = Math.abs(midValue - remainingList.get(i));
			if (diff < minDiff) {
				minDiff = diff;
				minIdx = i;
			}
		}

		return minIdx;
	}

}
