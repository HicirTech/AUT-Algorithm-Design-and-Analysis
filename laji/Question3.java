

import java.util.Random;
import java.util.Scanner;


public class Question3 {
	static int k;
	static int n;
	static int[][] arrays;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter k:");
		k = scan.nextInt();
		System.out.println("enter n:");
		n = scan.nextInt();
		arrays = new int[k][n];
		getArrays(k,n,arrays);
		
	}
	
	public static void getArrays(int k, int n, int arrays[][]){
		Random rand = new Random(1000);
		for(int i = 0; i < k; i++) {
			int start = rand.nextInt(50);
			for(int j = 0; j < n; j++) {
				arrays[i][j] = rand.nextInt((1000 - start) + 1) + start;
				start = arrays[i][j];
			}
		}
		System.out.println();
		long time = System.nanoTime();
		//method1(arrays);
		int[] array = getarray(arrays);
		System.out.println();
		method2(array,0,array.length-1);
//		for(int i = 0; i< array.length; i++) {
//			System.out.print("[" + array[i] + "]");
//		}
		System.out.print(System.nanoTime() - time);
	}
	
	public static void method1(int[][] arrays) {
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = arrays[0][i];
		}
		int index = 1;
		int length = n;
		while(index < k) {
			int index1 = 0;
			int index2 = 0;
			int[] arr = new int[length + n];
			for(int i = 0; i < arr.length; i++) {
				if(index1 == array.length ||index1 > array.length) {
					arr[i] = arrays[index][index2];
					index2++;
				}
				else if(index2 == n ||index2 > n) {
					arr[i] = array[index1];
					index1++;
				}
				else if(array[index1] < arrays[index][index2]) {
					arr[i] = array[index1];
					index1++;
				}
				else if(array[index1] > arrays[index][index2]) {
					arr[i] = arrays[index][index2];
					index2++;
				}
				else if(array[index1] == arrays[index][index2]) {
					arr[i] = arrays[index][index2];
					index2++;	
				}
				
			}
			array = new int[arr.length];
			for(int i = 0; i< array.length; i++) {
				array[i] = arr[i];
			}
			index++;
			length = array.length;
		}
		for(int i = 0; i< array.length; i++) {
			System.out.print("[" + array[i] + "]");
		}
	}
	public static int[] getarray(int[][] arrays) {
		int[] array = new int[k*n];
		for(int i = 0; i < k; i++) {
			for(int j = i*n; j < i*k + n; j++) {
				array[j] = arrays[i][j - i*n];
				//System.out.println(array[j]);
			}
		}	
		return array;
	}
	
	public static void merge(int arr[], int first, int mid, int last)
    {
        
        int Left[] = new int [mid - first + 1];
        int Right[] = new int [last - mid];

        for (int i=0; i<Left.length; ++i)
            Left[i] = arr[first + i];
        for (int j=0; j<Right.length; ++j)
            Right[j] = arr[mid + 1+ j];
 
        int i = 0, j = 0;
 
        int k = first;
        while (i < Left.length && j < Right.length)
        {
            if (Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }
            else
            {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
 
        while (i < Left.length)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }

        while (j < Right.length)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
 
    public static void method2(int arr[], int first, int last)
    {
        if (first < last)
        {
            int m = (first+last)/2;
 
            method2(arr, first, m);
            method2(arr , m+1, last);
 
            merge(arr, first, m, last);
        }
    }
}

