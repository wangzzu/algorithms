package linkedlist;

public class AddTwoNumbers_002 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode l10 = l1;
		ListNode l20 = l2;
		for (int i = 0; i < 5; i++) {
			ListNode l11 = new ListNode(i);
			ListNode l21 = new ListNode(2 * i);
			l10 = l11;
			l20 = l21;
			l10 = l10.next;
			l20 = l20.next;
		}
		l10 = null;
		l20 = null;
		ListNode ans = addTwoNumbers(l1, l2);
		System.out.println("ans:");
		while (ans.next != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode next = new ListNode(0);
		ListNode first = next;
		int flagVal = 0;
		int i = 0;
		while (true) {
			int val = 0;
			if (l1 == null) {
				if ((l2.val + flagVal) / 10 == 0) {
					val = l2.val + flagVal;
					flagVal = 0;
				} else {
					val = (l2.val + flagVal) % 10;
					flagVal = (l2.val + flagVal) / 10;
				}
				l2 = l2.next;
			} else if (l2 == null) {
				if ((l1.val + flagVal) / 10 == 0) {
					val = l1.val + flagVal;
					flagVal = 0;
				} else {
					val = (l1.val + flagVal) % 10;
					flagVal = (l1.val + flagVal) / 10;
				}
				l1 = l1.next;
			} else {
				if ((l1.val + l2.val + flagVal) / 10 == 0) {
					val = l1.val + l2.val + flagVal;
					flagVal = 0;
				} else {
					val = (l1.val + l2.val + flagVal) % 10;
					flagVal = (l1.val + l2.val + flagVal) / 10;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
			next.val = val;
			if (l1 == null && l2 == null) {
				if (flagVal != 0) {
					ListNode next0 = new ListNode(flagVal);
					next.next = next0;
					next0.next = null;
				}
				break;
			}
			ListNode next0 = new ListNode(0);
			next.next = next0;
			next = next0;
		}
		return first;
	}

	public static ListNode addTwoNumbersTwo(ListNode l1, ListNode l2) {
		ListNode ln1 = l1, ln2 = l2, head = null, node = null;
		int carry = 0, remainder = 0, sum = 0;
		head = node = new ListNode(0);
		while (ln1 != null || ln2 != null || remainder != 0) {
			sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
			carry = sum / 10;
			remainder = sum % 10;
			node = node.next = new ListNode(remainder);
			ln1 = (ln1 != null ? ln1.next : null);
			ln2 = (ln2 != null ? ln2.next : null);
		}
		return head.next;
	}
}
