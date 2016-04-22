package linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode listNode(int[] a){
		ListNode head=new ListNode(a[0]);
		ListNode node=new ListNode(a[1]);
		head.next=node;
		for(int i=2;i<a.length;i++){
			node.next=new ListNode(a[i]);
			node=node.next;
		}
		return head;
	}
}
