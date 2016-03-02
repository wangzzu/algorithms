package sort_two;

/**
 * 基于堆的优先队列（实现删除最大元素和插入元素的操作）
 * 
 * @author matt
 *
 */
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;

	public static void main(String[] args) {

	}

	/**
	 * 建立优先队列
	 * 
	 * @param maxN
	 */
	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	/**
	 * 插入元素：将元素插入到队列最后一位，通过上浮到给定的位置
	 * 
	 * @param x
	 */
	public void insert(Key x) {
		pq[++N] = x;
		swim(N);
	}

	/**
	 * 删除最大的元素，然后将对后一位元素交换到第一位，最后通过下沉将元素下沉到合适位置
	 * 
	 * @return
	 */
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N + 1] = null;// 释放存储空间，防止对象游历
		return max;
	}

	/**
	 * 上浮法
	 * 
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * 下沉：将元素与两个子节点中较大者进行比较
	 * 
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
}
