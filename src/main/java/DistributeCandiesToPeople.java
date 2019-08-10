public class DistributeCandiesToPeople {
	public int[] distributeCandies(int candies, int num_people) {
		if (num_people == 0) {
			return new int[0];
		}
		int[] answer = new int[num_people];

		int firstTime = num_people * (num_people + 1) / 2;
		int lastCompleteRound = 0;

		if (candies > firstTime) {
			lastCompleteRound = (int) Math.floor((-1 + Math.sqrt(1 + 8 * (long) candies)) / (2 * (double) num_people));

			for (int i = 0; i < num_people; i++) {
				int givenCandies = (i + 1) * lastCompleteRound + num_people * (lastCompleteRound - 1) * lastCompleteRound / 2;
				answer[i] = givenCandies;
				candies -= givenCandies;
			}
		}

		int i = 0;
		while (candies > 0) {
			int givenCandies = Math.min(candies, lastCompleteRound * num_people + (i + 1));
			answer[i] += givenCandies;
			candies -= givenCandies;
			i++;
		}

		return answer;
	}
}
