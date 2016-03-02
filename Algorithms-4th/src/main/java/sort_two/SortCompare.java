package sort_two;

import java.util.Random;

/**
 * 计算不同排序算法的时间
 * 
 * @author matt
 *
 */
public class SortCompare {

	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);

		System.out.printf("%s 的运行时间为： %.3f .", alg1, t1);
		System.out.println();
		System.out.printf("%s 的运行时间为： %.3f .", alg2, t2);
	}

	/**
	 * 计算排序需要的时间
	 * 
	 * @param alg
	 *            排序算法类型
	 * @param a
	 *            待排序数组
	 * @return
	 */
	public static double time(String alg, Double[] a) {
		long start = System.currentTimeMillis();
		if (alg.equals("Insertion"))
			Insertion.sort(a);
		if (alg.equals("Selection"))
			Selection.sort(a);
		if (alg.equals("Shell"))
			Shell.sort(a);
		if (alg.equals("Merge"))
			Merge.sort(a);
		if (alg.equals("Quick"))
			Quick.sort(a);
		// if(alg.equals("Heap"))
		// Heap.sort(a);
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}

	/**
	 * 生成T个长度为N的随机数组，并对这T个数组进行排序，返回排序花费的总时间
	 * 
	 * @param alg
	 *            排序算法的类型
	 * @param N
	 *            随机数组的长度
	 * @param T
	 *            生成T个长度为N的随机数组
	 * @return
	 */
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				long seed = System.currentTimeMillis();
				Random random = new Random(seed);
				a[i] = random.nextDouble();
			}
			total += time(alg, a);
		}
		return total;
	}
}
