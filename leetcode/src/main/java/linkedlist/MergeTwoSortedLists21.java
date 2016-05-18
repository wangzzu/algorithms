package linkedlist;

/**
 * Created by matt on 5/9/16.
 */
public class MergeTwoSortedLists21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode head = l1.val < l2.val ? l1 : l2;
		ListNode nonHead = l1.val < l2.val ? l2 : l1;

		head.next = mergeTwoLists(head.next, nonHead);

		return head;
	}
}
