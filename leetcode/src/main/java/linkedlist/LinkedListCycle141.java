package linkedlist;

/**
 * Created by matt on 5/6/16.
 */
public class LinkedListCycle141 {
	/**
	 * 使用快慢指针，相遇的话就证明有循环
	 *
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}
