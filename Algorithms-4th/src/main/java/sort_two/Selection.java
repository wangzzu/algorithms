package sort_two;

/**
 * 选择排序算法：不断地从数组中选取最小的元素
 * 
 * @author matt
 *
 */
public class Selection extends example {

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(new BufferedInputStream(System.in),
		// "UTF-8");
		String[] a = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}

}
