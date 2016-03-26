package sort_two;

/**
 * 一般的快速排序算法：将一个数组分成两个数组，主要使用切分的方法完成；
 * 
 * 三向切分的快速排序：将数组分成三个数组，如小于等于和大于三部分；
 * 
 * @author matt
 *
 */
public class Quick extends example {
	public static void main(String[] args) {
		// 检查一般的快速排序算法
		String[] a = new String[] { "S", "O", "R", "T", "B", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		System.out.println("output:");
		show(a);

		// 检查一般的快速排序算法
		String[] a1 = new String[] { "S", "O", "R", "T", "B", "X", "A", "M", "P", "L", "E" };
		sort3way(a1, 0, 10);
		assert isSorted(a1);
		System.out.println("\na1 output:");
		show(a1);

		// 检查合在一起的快排写法
		String[] a2 = new String[] { "S", "O", "R", "T", "B", "X", "A", "M", "P", "L", "E" };
		sort(a2, 0, 10, true);
		assert isSorted(a2);
		System.out.println("\na1 output:");
		show(a2);
	}

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	/**
	 * 一般的快速排序，使用了递归的方法，一直寻找v，将小于v的值放在左边，大于v的值放在右边
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j);
		sort(a, j + 1, hi);
	}

	/**
	 * 最简单的递归切分：指针i从数组的最左端开始扫描直到找到一个大于等于它的元素，指针j从数组的最右端开始扫描直到找到一个小于等于它的元素，
	 * 然后交换它们的位置，直到指针相遇。
	 * 
	 * @param a
	 *            排序数组
	 * @param lo
	 *            起始索引
	 * @param hi
	 *            结束索引
	 * @return 切分元素索引
	 */
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	/**
	 * 合在一起的快排写法
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @param flag
	 */
	public static void sort(Comparable[] a, int low, int high, boolean flag) {
		int l = low;
		int h = high;
		Comparable key = a[l];
		while (l < h) {
			while (l < h && less(key, a[h]))
				h--;
			if (l < h) {
				exch(a, l, h);
				l++;
			}

			while (l < h && less(a[l], key))
				l++;
			if (l < h) {
				exch(a, l, h);
				h--;
			}
		}
		if (l > low)
			sort(a, low, l - 1);
		if (h < high)
			sort(a, l + 1, high);
	}

	/**
	 * 三向切分的快速排序算法：它从左到右遍历数组一次，维护一个指针lt使得a[lo..lt-1]中的元素都小于v，一个指针gt使得a[gt+1..hi]
	 * 中的元素都大于v，一个指针i使得a[lt..i-1]中的元素都等于v，a[i..gt]中的元素都还未确定。
	 * 
	 * @param a
	 *            排序数组
	 * @param lo
	 *            起始索引
	 * @param hi
	 *            结束索引
	 */
	public static void sort3way(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0)
				exch(a, lt++, i++);
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}
		sort3way(a, lo, lt - 1);
		sort3way(a, gt + 1, hi);
	}
}
