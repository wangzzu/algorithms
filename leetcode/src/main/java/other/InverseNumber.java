package other;

/**
 * 求一个数组的逆序数对
 * Created by matt on 4/24/16.
 */
public class InverseNumber {
	public static void main(String[] args) throws InterruptedException {
		int[] a={7,5,6,4};
		System.out.println(inverseNumber(a,0,3));
	}

	public static int inverseNumber(int[] a, int start, int end) {
		int num = 0;
		if (start == end) {
			return num;
		}
		int mid = (end - start + 1) / 2-1+start;
		int left = inverseNumber(a, start, mid);
		int right = inverseNumber(a, mid + 1, end);
		int i = mid;
		int j = end;
		while (i >= start && j >= mid + 1) {
			if (a[i] > a[j]) {
				num += j - mid;
				i--;
			} else {
				j--;
			}
		}
		merge(a,start,mid,end);
		return left+right+num;
	}

	public static void merge(int[] a, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int[] ao = new int[a.length];
		for (int k = start; k <= end; k++) {
			ao[k] = a[k];
		}
		for (int k = start; k <= end; k++) {
			if (i > mid) {
				a[k] = ao[j++];
			} else if (j > end) {
				a[k] = ao[i++];
			} else if (ao[i] > ao[j]) {
				a[k] = ao[j++];
			} else {
				a[k] = ao[i++];
			}
		}
	}
}
