package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by matt on 5/17/16.
 */
public class KthLargestElementinanArray215 {
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println(findKthLargest2(nums, 3));
	}

	/**
	 * 使用优先队列实现
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
//	public static int findKthLargest1(int[] nums, int k) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		int size = nums.length;
//		if (k > size || k <= 0) {
//			return 0;
//		}
//		Queue<Integer> heap = new PriorityQueue(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer l1, Integer l2) {
//				return l2 - l1;
//			}
//		});
//		for (int i = 0; i < size; i++) {
//			heap.offer(nums[i]);
//		}
//		int ans = 0;
//		while (k != 0) {
//			ans = heap.poll();
//			k--;
//		}
//		return ans;
//	}

	public static int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int size = nums.length;
		if (k > size || k <= 0) {
			return 0;
		}
		return quickfind(nums,0,nums.length-1,nums.length-k);
	}

	public static int quickfind(int[] nums, int start, int end, int k) {
		if(start<end){
			return 0;
		}
		int tmp=nums[end];
		int left=start;
		for(int i=start;i<end;i++){
			if(nums[i]<=tmp){
				swap(nums,i,left);
				left++;
			}
		}
		swap(nums,left,end);
		if(left==k){
			return nums[left];
		}else if(left<k){
			return quickfind(nums,left+1,end,k);
		}else {
			return quickfind(nums,start,left-1,k);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
