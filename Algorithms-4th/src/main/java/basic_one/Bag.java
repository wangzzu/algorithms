package basic_one;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 基于链表的背包实现方法（背包：不支持从中删除元素的集合数据类型，它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素）
 * 
 * @author matt
 *
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int N;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Bag() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = (Item) current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {

	}

}
