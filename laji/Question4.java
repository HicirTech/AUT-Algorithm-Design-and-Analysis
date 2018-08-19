

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question4 {
	public static int[][] graph;
	public static int n;
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	
	public static void main(String args[]) {
		System.out.println("Enter n to get random graph with order of n");
		n = scan.nextInt();
		graph = new int[n][n];
		createGraph(graph);
		
		makeList(graph);
		
	}
	
	public static void createGraph(int[][] graph) {
		for(int i = 0; i < n; i++) {
			graph[i][i] = 0;
		}
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				graph[i][j] = rand.nextInt(2);
				graph[j][i] = graph[i][j];
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static ArrayList makeList(int[][] graph)
	{
		ArrayList outside=new ArrayList();
		for(int i =0 ; i!=graph.length;i++)
		{
			ArrayList inside = new ArrayList();
			for(int j=0; j!=graph[i].length;j++)
			{
				if(graph[i][j]==0)
				{
					inside.add(j);
				}
			}
			System.out.println(inside);
			outside.add(inside);
		}
		return outside;

	}

}
