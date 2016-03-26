package sort_two;

/**
 * 冒泡排序
 * 
 * @author matt
 *
 */
public class Bubble extends example {

	public static void main(String[] args) {
		String[] a = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}

	public static void sort(Comparable[] a) {
		int N = a.length - 1;
		while (N > 0) {
			for (int i = 1; i <= N; i++) {
				if (less(a[i], a[i - 1]))
					exch(a, i, i - 1);
			}
			N--;
		}
	}
}
