package sort_two;

public class RadixSort extends example {

	public static void main(String[] args) {
		int[] a = { 21, 13, 56, 11, 1, 42, 4, 3, 64, 13, 0, 35, 11, 7, 17, 26, 120, 112, 365, 956, 212, 213 };
		sort(a, 3);
		assert isSorted(a);
		System.out.println("output:");
		show(a);
	}

	public static void sort(int[] a, int d) {// d最大值多少位
		int index = 0;
		int m = 1;
		int n = 1;
		int[][] tmp = new int[10][a.length];
		int[] num = new int[10];
		while (m <= d) {
			for (int i : a) {
				int lsd = (i / n) % 10;
				tmp[lsd][num[lsd]] = i;
				num[lsd]++;
			}
			for (int i = 0; i < 10; i++) {
				if (num[i] != 0) {
					for (int j = 0; j < num[i]; j++) {
						a[index] = tmp[i][j];
						index++;
					}
					num[i] = 0;
				}
			}
			n *= 10;
			index = 0;
			m++;
		}
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
