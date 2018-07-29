package Lab2;

import static java.lang.System.nanoTime;

import java.util.Scanner;
/**
 * this the lab 2 Question 3 runnable part, require user input array size and the number to look up
 * Warning: A large size array may course stack overflow
 * nano-second time will be show after method ran
 * @author Luo Zeting ID:16938158
 * @see https://github.com/HicirTech/AUT-ADA
 */
public class Runable {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Please input number of size of the array  Warning: A large size array may course stack overflow");
		int [] array = new int[new Scanner(System.in).nextInt()];
		for(int i = 0; i!=array.length;i++)
			array[i]=i;		
		System.out.println("Please input a number to look for:");
		lab2 a = new lab2(array,new Scanner(System.in).nextInt());
	
		long start = nanoTime();//Start counting
		System.out.println("found? "+a.lookFor()+"   Used time "+ (nanoTime()-start)+" nano-second");}
		
}
