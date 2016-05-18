package linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by matt on 5/9/16.
 */
public class MergekSortedLists23 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode[] lists = new ListNode[]{l1};
		//ListNode ans = mergeKLists(lists);
		//System.out.println(ans.val);
		System.out.println("1".hashCode());
//		List<String> list = new ArrayList<>();
//		list.add("as");
//		list.remove(0);
//		System.out.println(list.size());
	}

	/**
	 * 使用优先队列，但是需要修改默认的比较器
	 *
	 * @param lists
	 * @return
	 */
//	public static ListNode mergeKLists(ListNode[] lists) {
//		Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
//			@Override
//			public int compare(ListNode l1, ListNode l2) {
//				return l1.val - l2.val;
//			}
//		});
//		for (ListNode node : lists) {
//			if (node != null) {
//				heap.offer(node);
//			}
//		}
//		ListNode head = new ListNode(0);
//		ListNode tail = head;
//		while (!heap.isEmpty()) {
//			tail.next = heap.poll();
//			tail = tail.next;
//			if (tail.next != null) {
//				heap.offer(tail.next);
//			}
//		}
//		return head.next;
//	}
}
