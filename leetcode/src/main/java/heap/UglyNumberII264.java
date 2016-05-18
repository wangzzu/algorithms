package heap;

/**
 * Created by matt on 5/17/16.
 */
public class UglyNumberII264 {
	public int nthUglyNumber(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] nums = new int[n];
		nums[0] = 1;
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		int i = 1;
		while (i < n) {
			nums[i] = min(nums[p2] * 2, nums[p3] * 3, nums[p5] * 5);
			while (nums[p2] * 2 <= nums[i]) {
				p2++;
			}
			while (nums[p3] * 3 <= nums[i]) {
				p3++;
			}
			while (nums[p5] * 5 <= nums[i]) {
				p5++;
			}
			i++;
		}
		return nums[n - 1];
	}

	public int min(int n1, int n2, int n3) {
		int min = (n1 < n2) ? n1 : n2;
		return min = (min < n3) ? min : n3;
	}
}
