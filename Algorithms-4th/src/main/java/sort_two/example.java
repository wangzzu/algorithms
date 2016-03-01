package sort_two;

/**
 * 排序的基本模版（一些基本的函数）
 * 
 * @author matt
 *
 */
public class example {

	/**
	 * 排序算法的实现
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
	}

	/**
	 * 对元素进行比较
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 将元素交换位置
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * 打印数组内容
	 * 
	 * @param a
	 */
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

	/**
	 * 通过assert isSorted(a)确认排序后的代码是有序的
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}
}
