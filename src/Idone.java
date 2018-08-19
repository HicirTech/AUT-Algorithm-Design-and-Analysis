import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Idone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[][] = { { 1, 2, 32, 46 }, { 4, 5, 15, 18, 20 }, { 3 }, { 6, 8 } };
		print2DArray(arr);
		System.out.println("after sorting");
		printArray(mergeKSortedArrays(arr, arr.length));
	}
	
		private static class MinHeapSorted {
		int data;
		int indexOfHeap;
		int currentIndex;
	}

	public static int[] mergeKSortedArrays(int[][] arr, int k) {
		int size = 0;
		for (int i = 0; i < arr.length; i++) {
			size += arr[i].length;
		}
		int[] merge = new int[size];
		MinHeapSorted[] heap = new MinHeapSorted[k];
		for (int i = 0; i < k; i++) {
			heap[i] = new MinHeapSorted();
			heap[i].data = arr[i][0];
			heap[i].currentIndex = 0;
			heap[i].indexOfHeap = i;
		}
		//////////////////////////////////////////
		for (int i = 0; i < merge.length; i++) {
			minHeapifyMinHeapSorted(heap, 0, k);
			merge[i] = heap[0].data;
			heap[0].currentIndex++;
			int[] currentSubArray = arr[heap[0].indexOfHeap];
			if (heap[0].currentIndex >= currentSubArray.length) {
				heap[0].data = Integer.MAX_VALUE;
			} else {
				heap[0].data = currentSubArray[heap[0].currentIndex];
			}

		}
		return merge;
	}

	public static void minHeapifyMinHeapSorted(MinHeapSorted[] arr, int root, int size) {
		int smallest = root;
		int leftIndex = 2 * root + 1;
		int rightIndex = 2 * root + 2;

		if (leftIndex < size && arr[smallest].data > arr[leftIndex].data) {
			smallest = leftIndex;
		}

		if (rightIndex < size && arr[smallest].data > arr[rightIndex].data) {
			smallest = rightIndex;
		}

		if (smallest != root) {
			MinHeapSorted temp = arr[smallest];
			arr[smallest] = arr[root];
			arr[root] = temp;
			minHeapifyMinHeapSorted(arr, smallest, size);
		}
	}

	public static void print2DArray(int[][] arr) {
		for (int[] a : arr) {
			for (int i : a)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
		private static void printArray(int[] arr) {
		System.out.println("");
		System.out.println("TestSort.printArray()");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}