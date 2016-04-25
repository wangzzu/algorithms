package binarysearch;

/**
 * Created by matt on 4/25/16.
 */
public class BinarySearch4 {

	public static void main(String[] args) {
		int[] a = {1};
		int[] b = {2};
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int len = m + n;
		if (len % 2 != 0) {
			return findMedianSortedArraysReal(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len / 2 + 1);
		} else {
			double x = findMedianSortedArraysReal(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len / 2 + 1);
			double y = findMedianSortedArraysReal(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len / 2);
			return (x + y) / 2.0;
		}
	}

	public static double findMedianSortedArraysReal(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) { // 查找第k个
		int m = end1 - start1 + 1;
		int n = end2 - start2 + 1;
		if (m > n) {
			return findMedianSortedArraysReal(nums2, start2, end2, nums1, start1, end1, k);
		}
		if (m == 0) {
			return nums2[start2 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		int part1 = Math.min(k / 2, m);
		int part2 = k - part1;

		if (nums1[start1 + part1 - 1] < nums2[part2 + start2 - 1]) {
			return findMedianSortedArraysReal(nums1, start1 + part1, end1, nums2, start2, end2, k - part1);
		} else if (nums1[start1 + part1 - 1] > nums2[part2 + start2 - 1]) {
			return findMedianSortedArraysReal(nums1, start1, end1, nums2, start2 + part2, end2, k - part2);
		} else {
			return nums1[start1 + part1 - 1];
		}
	}
}
