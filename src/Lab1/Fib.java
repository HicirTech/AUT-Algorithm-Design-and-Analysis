package Lab1;

import java.util.Scanner;

public class Fib {
	
	
	public static int method1(int a) {
		if(a < 2) {
			return a;
		}
		return method1(a - 1) + method1(a - 2);
	}
	
	public static int method2(int a) {
		if(a == 0) {
			return 0;
		}
		int[] array = new int[a+1];
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i < a+1; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[a];
	}
	
	public static int method3(int a) {
		if(a < 2) {
			return a;
		}
		int[][] A = {{0,1},{1,1}};
		int[][]	B = {{1,0},{0,1}};
		for(int i = 1; i < a; ++i) {
			B = multiply2by2(B,A);
		}
		return B[0][1];
	}
	
	public static int method4(int a) {
		if(a < 2) {
			return a;
		}
		int[][] A = {{0,1},{1,1}};
		int[][]	B = {{1,0},{0,1}};
		
		while(a > 0) {
			if(a%2 == 1) {
				B = multiply2by2(B,A);
			}
			A = multiply2by2(A,A);
			a = a/2;
		}
		return B[0][1];
	}
	
	
	public static int[][]multiply2by2(int[][]m, int[][]n){
		int a = m[0][0] * n[0][0] +m[0][1] * n[1][0];
		int b = m[0][0] * n[0][1] +m[0][1] * n[1][1];
		int c = m[1][0] * n[0][0] +m[1][1] * n[0][1];
		int d = m[1][0] * n[0][1] +m[1][1] * n[1][1];
		
		int[][] result = {{a,b},{c,d}};
		return result;
	} 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a value: ");
		int fib = scan.nextInt();
		
		//System.out.println("Answer from method 1: " + method1(fib));
		//System.out.println(System.nanoTime());
		//System.out.println("Answer from method 2: " + method2(fib));
		//System.out.println(System.nanoTime());
		//System.out.println("Answer from method 3: " + method2(fib));
		//System.out.println(System.nanoTime());
		System.out.println("Answer from method 4: " + method4(fib));
		System.out.println(System.nanoTime());
	}
}
