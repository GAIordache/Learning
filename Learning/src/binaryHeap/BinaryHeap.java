package binaryHeap;

public class BinaryHeap {

	public static void main(String[] args) {
		Integer[] list2 = new Integer[] {33,2,15,66,7,100,33,16,16,74};
		Heap<Integer> heapSort2 = new Heap<>(list2);
		
		for (int i = 0; i < list2.length; i++) {
			System.out.print(heapSort2.remove() + " ");
		}
	}
}
