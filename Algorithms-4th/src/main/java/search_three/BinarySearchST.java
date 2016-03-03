package search_three;

import java.util.NoSuchElementException;

import com.StdIn;
import com.StdOut;

import basic_one.Queue;

/**
 * 有序数组的二分查找
 * 
 * @author matt
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int N = 0;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	private void resize(int capacity) {
		assert capacity >= N;
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		vals = tempv;
		keys = tempk;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(Key key) {
		if (key == null)
			throw new NullPointerException("argument to contains() is null");
		return get(key) != null;
	}

	public Value get(Key key) {
		if (key == null)
			throw new NullPointerException("argument to get() is null");
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		return null;
	}

	public int rank(Key key) {
		if (key == null)
			throw new NullPointerException("argument to rank() is null");

		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	public void put(Key key, Value val) {
		if (key == null)
			throw new NullPointerException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		int i = rank(key);

		// key is already in table
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		// insert new key-value pair
		if (N == keys.length)
			resize(2 * keys.length);

		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;

		assert check();
	}

	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("argument to delete() is null");
		if (isEmpty())
			return;

		// compute rank
		int i = rank(key);

		// key not in table
		if (i == N || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < N - 1; j++) {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
		}

		N--;
		keys[N] = null; // to avoid loitering
		vals[N] = null;

		// resize if 1/4 full
		if (N > 0 && N == keys.length / 4)
			resize(keys.length / 2);

		assert check();
	}

	public void deleteMin() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow error");
		delete(min());
	}

	public void deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow error");
		delete(max());
	}

	public Key min() {
		if (isEmpty())
			return null;
		return keys[0];
	}

	public Key max() {
		if (isEmpty())
			return null;
		return keys[N - 1];
	}

	public Key select(int k) {
		if (k < 0 || k >= N)
			return null;
		return keys[k];
	}

	public Key floor(Key key) {
		if (key == null)
			throw new NullPointerException("argument to floor() is null");
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0)
			return keys[i];
		if (i == 0)
			return null;
		else
			return keys[i - 1];
	}

	public Key ceiling(Key key) {
		if (key == null)
			throw new NullPointerException("argument to ceiling() is null");
		int i = rank(key);
		if (i == N)
			return null;
		else
			return keys[i];
	}

	public int size(Key lo, Key hi) {
		if (lo == null)
			throw new NullPointerException("first argument to size() is null");
		if (hi == null)
			throw new NullPointerException("second argument to size() is null");

		if (lo.compareTo(hi) > 0)
			return 0;
		if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		if (lo == null)
			throw new NullPointerException("first argument to size() is null");
		if (hi == null)
			throw new NullPointerException("second argument to size() is null");

		Queue<Key> queue = new Queue<Key>();
		// if (lo == null && hi == null) return queue;
		if (lo == null)
			throw new NullPointerException("lo is null in keys()");
		if (hi == null)
			throw new NullPointerException("hi is null in keys()");
		if (lo.compareTo(hi) > 0)
			return queue;
		for (int i = rank(lo); i < rank(hi); i++)
			queue.enqueue(keys[i]);
		if (contains(hi))
			queue.enqueue(keys[rank(hi)]);
		return queue;
	}

	private boolean check() {
		return isSorted() && rankCheck();
	}

	private boolean isSorted() {
		for (int i = 1; i < size(); i++)
			if (keys[i].compareTo(keys[i - 1]) < 0)
				return false;
		return true;
	}

	private boolean rankCheck() {
		for (int i = 0; i < size(); i++)
			if (i != rank(select(i)))
				return false;
		for (int i = 0; i < size(); i++)
			if (keys[i].compareTo(select(rank(keys[i]))) != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

}
