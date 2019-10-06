package binaryHeap;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list = new ArrayList<E>();

	/**
	 * create a default map
	 */
	public Heap() {

	}

	/**
	 * Create a heap from an Array of objects
	 */
	public Heap(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}

	/**
	 * Add a new object to the heap
	 */
	public void add(E newObject) {
		list.add(newObject); // append on the last index
		int currentIndex = list.size() - 1; // the index of the last node

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			// Swap child node with parent if it is greater
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			} else {
				break;
			}
			currentIndex = parentIndex;
		}
	}

	/**
	 * Remove the root of the heap
	 */
	public E remove() {

		if (list.size() == 0) {
			return null;
		}

		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);

		int currentIndex = 0;

		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;

			// Find the max of the 2 children
			if (leftChildIndex >= list.size())
				break;
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}

			/**
			 * Swap current node if less than max
			 */
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			} else {
				break;
			}
		}
		return removedObject;
	}
	
	public int getSize() {
		return list.size();
	}
}
