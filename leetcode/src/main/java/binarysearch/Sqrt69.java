package binarysearch;

/**
 * Created by matt on 4/28/16.
 */
public class Sqrt69 {

	public static void main(String[] args) {
		System.out.println(mySqrt1(8));
		System.out.println(mySqrt2(8));
	}

	/**
	 * 基于二分查找的方法
	 *
	 * @param x
	 * @return
	 */
	public static int mySqrt1(int x) {
		if (x < 0) {
			return -1;
		}
		if (x == 0) {
			return 0;
		}
		int l = 1;
		int r = x / 2 + 1;
		while (l <= r) {
			int mid = (r + l) / 2;
			if (mid <= x / mid && (x / (mid + 1)) < mid + 1) {
				return mid;
			}
			if (mid > x / mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return 0;
	}

	/**
	 * 使用牛顿法，逐渐逼近该值
	 *
	 * @param x
	 * @return
	 */
	public static int mySqrt2(int x) {
		if (x == 0) {
			return 0;
		}
		double last = 0;
		double res = 1;
		while (res != last) {
			last = res;
			res = (res + x / res) / 2;
		}
		return (int) res;
	}
}
