package sort_two;

public class BucketSort extends example {

	public static void main(String[] args) {
		int[] a = { 21, 13, 56, 11, 1, 42, 4, 3, 64, 13, 0, 35, 11, 7, 17, 26, 120, 112, 365, 956, 212, 213 };
		sort(a);
		assert isSorted(a);
		System.out.println("output:");
		show(a);
	}

	public static void sort(int a[]) {
		int n = a.length;
		int bask[][] = new int[10][n];
		int index[] = new int[10];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = max > (Integer.toString(a[i]).length()) ? max : (Integer.toString(a[i]).length());
		}
		String str;
		for (int i = max - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				str = "";
				if (Integer.toString(a[j]).length() < max) {
					for (int k = 0; k < max - Integer.toString(a[j]).length(); k++)
						str += "0";
				}
				str += Integer.toString(a[j]);
				bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = a[j];
			}
			int pos = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < index[j]; k++) {
					a[pos++] = bask[j][k];
				}
			}
			for (int x = 0; x < 10; x++)
				index[x] = 0;
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
