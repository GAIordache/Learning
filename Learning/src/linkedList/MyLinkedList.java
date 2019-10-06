package linkedList;

public class MyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	int size = 0;
	
	public MyLinkedList() {
		
	}
	
	public MyLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(i, objects[i]);
		}
	}
	
	public int size() {
		return size;
	}
	
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (tail == null) {
			tail = head;
		}
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		
		if(tail == null) {
			tail = head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public void add(int index, E e) {
		if(index == 0) addFirst(e);
		else if (index >= size) addLast(e);
		else {
			Node<E> current = head;
			for(int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}
	
	public E removeLast() {
		if(size == 0) return null;
		else if(size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;
			
			for(int i = 0; i < size - 2;i++)
				current = current.next;
			
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	
	public E removeFirst() {
		if(size == 0) return null;
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if(head == null) tail = null;
			return temp.element;
		}
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) return null;
		else if (index == 0) return removeFirst();
		else if (index == size - 1) return removeLast();
		else {
			Node<E> previous = head;
			
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		Node<E> current = head;
		for(int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if(current != null) {
				result.append(",");
			} else {
				result.append("]");
			}
		}
		return result.toString();
	}
	
	public void clear() {
		size = 0;
		head = tail = null;
	}
	
}
