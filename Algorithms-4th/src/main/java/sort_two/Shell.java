package sort_two;

/**
 * 希尔排序：是对插入排序的一种快速算法，插入排序相当于h=1的情况。（希尔排序的思想是使数组中任意间隔为h的元素都是有序的）
 * 
 * @author matt
 *
 */
public class Shell extends example {

	public static void main(String[] args) {
		String[] a = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}

	/**
	 * 排序算法实现
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}
}
