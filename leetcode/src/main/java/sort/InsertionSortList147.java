package sort;

/**
 * Created by matt on 4/22/16.
 */
public class InsertionSortList147 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(19);
		ListNode l3 = new ListNode(14);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(-3);
		ListNode l6 = new ListNode(1);
		ListNode l7 = new ListNode(8);
		ListNode l8 = new ListNode(5);
		ListNode l9 = new ListNode(11);
		ListNode l0 = new ListNode(15);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l0;
		ListNode newNode = insertionSortList2(l1);
		while (newNode != null) {
			System.out.println(newNode.val);
			newNode = newNode.next;
		}
	}

	/**
	 * runtime:42ms(50%)
	 *
	 * @param head
	 * @return
	 */
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head.next;
		int i = 0;
		head.next = null; // split the ListNode to two ListNode
		while (node != null) {
			//System.out.println(node.val);
			ListNode tmp = head;
			if (node.val <= head.val) { // compare with the first node
				tmp = node;
				node = node.next;
				tmp.next = head;
				head = tmp;
				continue;
			}
			ListNode last = head;
			while (tmp.next != null && tmp.val < node.val) {
				last = tmp;
				tmp = tmp.next;
			}
			if (tmp.next == null) {
				if (tmp.val < node.val) {
					tmp.next = node;
					node = node.next;
					tmp.next.next = null;
				} else {
					last.next = node;
					node = node.next;
					last.next.next = tmp;
					tmp.next = null;
				}
				continue;
			}
			last.next = node;
			node = node.next;
			last.next.next = tmp;
		}
		return head;
	}

	/**
	 * runtime:7ms(96%)
	 *
	 * @param head
	 * @return
	 */
	public static ListNode insertionSortList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fakeHead = new ListNode(1);
		ListNode pre = fakeHead;

		while (head != null) {
			// important trick here to avoid scanning from head.
			if (pre != fakeHead && pre.val > head.val)
				pre = fakeHead;
			while (pre.next != null && pre.next.val < head.val) {
				pre = pre.next;
			}
			ListNode cur = head;
			head = head.next;
			cur.next = pre.next;
			pre.next = cur;
		}
		return fakeHead.next;
	}
}
