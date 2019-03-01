import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int noOfQueries = sc.nextInt();

		Stack<Integer> front = new Stack<>();
		Stack<Integer> rear = new Stack<>();

		Stack<Integer>[] queue = new Stack[] {front, rear};

		for (int i = 0; i < noOfQueries; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				enqueue(queue, sc.nextInt());
			} else if (type == 2) {
				dequeue(queue);
			} else {
				print(queue);
			}
		}

		sc.close();
	}

	private static void enqueue(Stack<Integer>[] queue, int value) {
		queue[1].push(value);
	}

	private static void dequeue(Stack<Integer>[] queue) {
		if (!queue[0].empty()) {
			queue[0].pop();
			return;
		}

		while (!queue[1].empty()) {
			Integer element = queue[1].pop();
			queue[0].push(element);
		}

		queue[0].pop();
	}

	private static void print(Stack<Integer>[] queue) {
		if (!queue[0].empty()) {
			System.out.println(queue[0].peek());
			return;
		}

		while (!queue[1].empty()) {
			int element = queue[1].pop();
			queue[0].push(element);
		}

		System.out.println(queue[0].peek());
	}
}



