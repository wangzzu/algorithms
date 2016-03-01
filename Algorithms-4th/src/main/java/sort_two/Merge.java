package sort_two;

/**
 * 三种归并排序算法
 * 
 * @author matt
 *
 */
public class Merge extends example {
	public static void main(String[] args) {
		// 原地归并排序算法检查
		String[] a1 = new String[] { "E", "E", "G", "M", "R", "A", "C", "E", "R", "T" };
		merge(a1, 0, 4, 9);
		assert isSorted(a1);
		System.out.println("a1 output:");
		show(a1);

		// 自顶向下归并算法
		String[] a2 = new String[] { "S", "O", "R", "T", "B", "X", "A", "M", "P", "L", "E" };
		sort(a2);
		assert isSorted(a2);
		System.out.println("\na2 output:");
		show(a2);

		// 自底向上归并算法
		String[] a3 = new String[] { "S", "O", "R", "T", "B", "X", "A", "M", "P", "L", "E" };
		sortBU(a3);
		assert isSorted(a3);
		System.out.println("\na3 output:");
		show(a3);
	}

	/**
	 * 原地归并排序算法：将有序的a[lo...mid]和a[mid+1...hi]进行归并。
	 * 
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		Comparable[] aux = new Comparable[a.length];
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) {// 从两个有序数组的最低位开始进行比较
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	/**
	 * 调用排序算法
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	/**
	 * 自顶向下的归并排序，实质上据是递归的归并排序
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);// 归并两个有序数组
	}

	/**
	 * 自底向上法：从最下面把两个长度为1的数组进行合并，一直合并直到把数组分成两个数组，再进行最后一次合并
	 * 
	 * @param a
	 */
	public static void sortBU(Comparable[] a) {
		int N = a.length;
		for (int sz = 1; sz < N; sz = sz + sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz)// lo<N-sz是由下面的lo+sz-1<N-1等到的
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
		}
	}
}
