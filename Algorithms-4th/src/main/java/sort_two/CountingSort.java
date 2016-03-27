package sort_two;

/**
 * 计数排序
 * 
 * @author matt
 *
 */
public class CountingSort extends example {
	public static void main(String[] args) {
		// 检查一般的快速排序算法
		int[] a = new int[] { 21, 13, 56, 11, 1, 42, 4, 3, 64, 13, 0, 35, 11, 7, 17, 26 };
		int[] b = sort(a);
		assert isSorted(b);
		System.out.println("output:");
		show(b);
	}

	public static int[] sort(int[] a) {
		int[] b = new int[a.length];
		int min = a[0];
		int max = a[0];
		for (int i : a) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}
		int size = max - min + 1;
		int[] c = new int[size];
		for (int i = 0; i < a.length; i++) {
			c[a[i] - min]++;
		}
		for (int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i - 1];
		}
		for (int i = a.length - 1; i >= 0; i--) {
			b[--c[a[i] - min]] = a[i];
		}
		return b;
	}

	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
}
