package linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode listNode(int[] a){
		ListNode head=new ListNode(0);
		ListNode node=head;
		for(int i=0;i<a.length;i++){
			node.next=new ListNode(a[i]);
			node=node.next;
		}
		return head.next;
	}
}
