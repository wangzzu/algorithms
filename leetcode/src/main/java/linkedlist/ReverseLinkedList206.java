package linkedlist;

import java.util.Stack;

/**
 * Created by matt on 4/22/16.
 */
public class ReverseLinkedList206 {

	public static void main(String[] args) throws InterruptedException {
		int[] a = {1, 2, 3, 4, 5, 6};
		ListNode head2 = reverseList2(ListNode.listNode(a));
		ListNode head1= reverseList(ListNode.listNode(a));
		System.out.println("The first method: ");
		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
		System.out.println("\n The second method: ");
		while (head2 != null) {
			System.out.println(head2.val);
			head2 = head2.next;
		}
	}

	/**
	 * use stack
	 *
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode node;
		while (head != null) {
			node = head;
			stack.push(node);
			head = head.next;
		}
		head = stack.pop();
		node = stack.pop();
		head.next = node;
		while (!stack.isEmpty()) {
			node.next = stack.pop();
			node = node.next;
		}
		if (stack.isEmpty()) {
			node.next = null;
		}
		return head;
	}

	/**
	 * find the rule of reverseList
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head) {
		if (head != null && head.next != null) {
			ListNode left = head;
			ListNode border;
			while (left != null && left.next != null) {
				border = left.next;
				left.next = border.next;
				border.next = head;
				head = border;
			}
		}
		return head;
	}

}
