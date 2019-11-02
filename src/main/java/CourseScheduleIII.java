import java.util.Arrays;

public class CourseScheduleIII {
	public int scheduleCourse(int[][] courses) {
		if (courses == null || courses.length == 0) {
			return 0;
		}

		Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

		int[] dp = new int[10001];
		int max = 0;

		for (int t = 0; t <= 10000; t++) {
			for (int i = courses.length - 1; i >= 0; i--) {
				int[] course = courses[i];
				if (t + course[0] <= course[1] && t + course[0] <= 10000) {
					dp[t] = Math.max(dp[t], 1 + dp[t + course[0]]);
					max = Math.max(max, dp[t]);
				}
			}
		}

		return max;
	}
}
