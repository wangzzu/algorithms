package sort_two;

public class Heap extends example {

	public static void main(String[] args) {
		String[] a = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isSorted(a);
		show(a);
	}

	public static void sort(Comparable[] pq) {
		int N = pq.length;
		for (int k = N / 2; k >= 1; k--)
			sink(pq, k, N);
		while (N > 1) {
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
	}

	private static void sink(Comparable[] pq, int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(pq, j, j + 1))
				j++;
			if (!less(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

}
