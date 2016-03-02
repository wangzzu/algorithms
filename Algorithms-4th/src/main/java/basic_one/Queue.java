package basic_one;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 基于链表的队列实现方法：FIFO
 * 
 * @author matt
 *
 */
public class Queue<Item> implements Iterable<Item> {
	private Node<Item> first; // beginning of queue
	private Node<Item> last; // end of queue
	private int N;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Queue() {
		first = null;
		last = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return first.item;
	}

	/**
	 * 添加元素，添加到链表的最后面
	 * 
	 * @param item
	 */
	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	/**
	 * 删除元素，从链表的顶端删除元素
	 * 
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty())
			last = null; // to avoid loitering对象游离
		return item;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {

	}
}
