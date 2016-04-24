package linkedlist;

import java.util.Stack;

/**
 * Created by matt on 4/24/16.
 */
public class IntersectionofTwoLinkedLists160 {
	public static void main(String[] args) throws InterruptedException {
		int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
		int[] b = {2};
		//System.out.println(getIntersectionNode1(ListNode.listNode(a), ListNode.listNode(b)).val);
		System.out.println(getIntersectionNode2(ListNode.listNode(a), ListNode.listNode(b)).val);
	}

	/**
	 * use the Stack
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode inter = null;
		if (headA == null || headB == null) {
			return inter;
		}
		Stack<ListNode> stacka = new Stack<>();
		Stack<ListNode> stackb = new Stack<>();
		ListNode headA1 = headA;
		ListNode headB1 = headB;
		while (headA1 != null) {
			stacka.push(headA1);
			headA1 = headA1.next;
		}
		while (headB1 != null) {
			stackb.push(headB1);
			headB1 = headB1.next;
		}
		if (stacka.peek().val != stackb.peek().val) {
			return null;
		}
		while (stackb.size() > 0 && stacka.size() > 0 && stacka.peek().val == stackb.pop().val) {
			inter = stacka.pop();
		}

		return inter;
	}

	/**
	 * 先判断两个链表的长度，然后让长的先走
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lengthA = 0;
		int lengthB = 0;
		ListNode head = headA;
		while (head != null) {
			lengthA++;
			head = head.next;
		}
		head=headB;
		while (head != null) {
			lengthB++;
			head = head.next;
		}
		while (lengthA>lengthB){
			headA=headA.next;
			lengthA--;
		}
		while (lengthA<lengthB){
			headB=headB.next;
			lengthB--;
		}
		while (headA!=headB){
			headA=headA.next;
			headB=headB.next;
		}

		return headA;
	}
}
