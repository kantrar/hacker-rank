import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Set<Integer>[] courses = new HashSet[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses[i] = new HashSet<>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int post = prerequisites[i][0];
			int pre = prerequisites[i][1];

			courses[pre].add(post);
		}

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				dfs(courses, i, stack, visited);
			}
		}

		if (stack.size() < numCourses) {
			return new int[] {};
		}

		int[] answers = new int[numCourses];
		int idx = 0;
		while (!stack.isEmpty()) {
			answers[idx++] = stack.pop();
		}

		return answers;
	}

	public void dfs(Set<Integer>[] courses, int current, Stack<Integer> stack, boolean[] visited) {
		visited[current] = true;

		for (int next : courses[current]) {
			if (!visited[next]) {
				dfs(courses, next, stack, visited);
			}
		}

		stack.push(current);
	}
}
