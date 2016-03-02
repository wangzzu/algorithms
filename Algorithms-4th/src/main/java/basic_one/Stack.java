package basic_one;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 栈，下压栈，是一种基于先进后出LIFO策略的集合类型
 * 
 * @author matt
 *
 */
public class Stack<Item> implements Iterable<Item> {
	private Node<Item> first; // top of stack
	private int N;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Stack() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	/**
	 * 下压操作，将元素添加到链表的顶端
	 * 
	 * @param item
	 */
	public void push(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	/**
	 * 返回最顶端的元素，并从链表中删除该节点
	 * 
	 * @return
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = first.item; // save item to return
		first = first.next; // delete first node
		N--;
		return item; // return the saved item
	}

	/**
	 * 返回最新被添加节点的值
	 * 
	 * @return
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return first.item;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

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
