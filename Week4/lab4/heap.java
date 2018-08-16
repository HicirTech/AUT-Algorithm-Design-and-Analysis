package lab4;

import java.util.Arrays;


public class heap<Nodes extends Comparable<Nodes>> {

	private Nodes[] array;
	private int size;

	heap(int sizeofarray) {
		array = (Nodes[]) new Comparable[sizeofarray];
		size = 0;
	}
	
	public void add(Nodes value) {

		if (size >= array.length - 1) {
			array = this.resize();
		}
		size++;
		int index = size;
		array[index] = value;

		MoveUp();
	}
	
	public Nodes remove() {

		Nodes result = peek();
		array[1] = array[size];
		array[size] = null;
		size--;
		MoveDown();
		return result;
	}

	public String toString() {
		return Arrays.toString(array);
	}

	private boolean isEmpty() {
		return size == 0;
	}

	private Nodes peek() {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		return array[1];
	}

	
	public int findLast() {
		int result = 1;
		while (!checkHaveThisNode(result))
			result++;

		return result-1;
	}
	private boolean checkHaveThisNode(int index) {
		return this.array[index] == null;
	}
	private void MoveDown() {
		int index = 1;
		while (hasLeftChild(index)) {

			int smallerChild = leftIndex(index);

			if (hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
				smallerChild = rightIndex(index);
			}

			if (array[index].compareTo(array[smallerChild]) > 0) {
				swap(index, smallerChild);
			} else {

				break;
			}
			index = smallerChild;
		}
	}

	private void MoveUp() {
		int index = this.size;

		while (hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {

			swap(index, parentIndex(index));
			index = parentIndex(index);
		}
	}

	private boolean hasParent(int i) {
		return i > 1;
	}

	private int leftIndex(int i) {
		return i * 2;
	}

	private int rightIndex(int i) {
		return i * 2 + 1;
	}

	private boolean hasLeftChild(int i) {
		return leftIndex(i) <= size;
	}

	private boolean hasRightChild(int i) {
		return rightIndex(i) <= size;
	}

	private Nodes parent(int i) {
		return array[parentIndex(i)];
	}

	private int parentIndex(int i) {
		return i / 2;
	}

	private Nodes[] resize() {
		return Arrays.copyOf(array, array.length * 2);
	}

	private void swap(int index1, int index2) {
		Nodes tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
}