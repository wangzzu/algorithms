package sort;

/**
 * Created by matt on 5/16/16.
 */
public class SortList148 {
	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode slow=head;
		ListNode fast=head;
		ListNode cur=head;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			cur=slow;
			slow=slow.next;
		}
		cur.next=null;
		ListNode left=sortList(head);
		ListNode right=sortList(slow);

		return mergeList(left,right);
	}

	public ListNode mergeList(ListNode l1, ListNode l2){
		ListNode first=new ListNode(0);
		ListNode node=first;
		while(l1!=null&&l2!=null){
			if(l1.val>=l2.val){
				node.next=l2;
				l2=l2.next;
			}else{
				node.next=l1;
				l1=l1.next;
			}
			node=node.next;
		}
		if(l1!=null){
			node.next=l1;
		}
		if(l2!=null){
			node.next=l2;
		}
		return first.next;
	}
}
