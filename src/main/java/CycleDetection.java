import java.util.ArrayList;
import java.util.List;

public class CycleDetection {
	static boolean hasCycle2(SinglyLinkedListNode head) {
		List<SinglyLinkedListNode> visited = new ArrayList<>();
		return hasCycle(head, visited);
	}

	static boolean hasCycle(SinglyLinkedListNode head) {
		if (head == null) {
			return false;
		}

		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	static boolean hasCycle(SinglyLinkedListNode head, List<SinglyLinkedListNode> visited) {
		if (head == null) {
			return false;
		}

		if (visited.contains(head)) {
			return true;
		}

		visited.add(head);
		return hasCycle(head.next, visited);
	}

	private static class SinglyLinkedListNode {
		SinglyLinkedListNode next;
		int data;
	}
}
