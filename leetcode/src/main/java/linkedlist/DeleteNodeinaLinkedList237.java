package linkedlist;

/**
 * Created by matt on 5/6/16.
 */
public class DeleteNodeinaLinkedList237 {
	public void deleteNode(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;
	}
}
