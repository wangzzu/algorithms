package sort_two;

/**
 * 插入排序：对于数组，左边为有序数组，右边为待插入数组，将待插入数组依次插入左边有序的数组
 * 
 * @author matt
 *
 */
public class Insertion extends example {

	/**
	 * 检验
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}

	/**
	 * 排序算法的实现
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
}
