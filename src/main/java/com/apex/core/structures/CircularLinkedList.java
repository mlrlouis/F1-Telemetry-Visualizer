package main.java.com.apex.core.structures;

import java.util.NoSuchElementException;

public class CircularLinkedList<T> {

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	private final Node<T> dummy;
	private Node<T> last;
	private int size;

	public CircularLinkedList() {
		this.dummy = new Node<>(null);
		this.dummy.next = dummy;
		this.last = dummy;
		this.size = 0;
	}

	public void addToEnd(T data) {
		Node<T> newNode = new Node<>(data);

		newNode.next = dummy;
		last.next = newNode;
		last = newNode;
		size++;
	}

	public void addToStart(T data) {
		Node<T> newNode = new Node<>(data);

		newNode.next = dummy.next;
		dummy.next = newNode;

		if (last == dummy)
			last = newNode;

		size++;
	}

	public void insertAt(int index, T data) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (index == 0) {
			addToStart(data);
			return;
		}

		if (index == size) {
			addToEnd(data);
			return;
		}

		Node<T> prev = dummy;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

		Node<T> newNode = new Node<>(data);
		newNode.next = prev.next;
		prev.next = newNode;
		size++;
	}

	public T deleteAtEnd() {
		if (isEmpty())
			throw new NoSuchElementException("List is Empty");

		Node<T> oldLast = last;
		T data = oldLast.data;

		Node<T> curr = dummy;
		while (curr.next != last) {
			curr = curr.next;
		}

		curr.next = dummy;
		last = curr;

		size--;
		return data;
	}

	public T deleteAtStart() {
		if (isEmpty())
			throw new NoSuchElementException("List is empty");

		Node<T> toDelete = dummy.next;
		dummy.next = toDelete.next;

		if (toDelete == last)
			last = dummy;

		size--;
		return toDelete.data;
	}

	public T deleteAt(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + "; Size: " + size);
		if (isEmpty())
			throw new NoSuchElementException("List is empty");

		Node<T> prev = dummy;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

		Node<T> toDelete = prev.next;
		T data = toDelete.data;

		prev.next = toDelete.next;

		if (toDelete == last)
			last = prev;

		size--;
		return data;
	}

	public boolean isEmpty() {
		return dummy.next == dummy;
	}

	public int getSize() {
		return size;
	}

}