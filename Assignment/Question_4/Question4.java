package Question_4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Question4 {
	public static int[][] graph;
	
	static Random rand = new Random();
	static Nodes[] nodes;
	
	public static void main(String args[]) {
		System.out.println("[Question 4.3] Enter n to get random graph with order of n");
		int n = new Scanner(System.in).nextInt();
		graph = new int[n][n];
		createGraph(graph);
		makeList(graph);
		BFSIsBipartite();
		System.out.println();
		for(int i=10;i<=101;i+=10)
		{
			System.out.println("[Question 4.5]now doing order "+i+" ramdon graph");
			graph = new int[i][i];
			createGraph(graph);
			makeList(graph);
			long start=System.nanoTime();
			BFSIsBipartite();
			long ends = System.nanoTime();
			System.out.println("BFS took "+(ends-start)+" nano seconds to finish");
			System.out.println();
		}
	
	}
	
	static void BFSIsBipartite()
	{
		
		boolean isNotFound=true;
		
		BFS bfs = new BFS();//Question 4.4, Question 4.5
		for(int i=0;i!=nodes.length;i++)
		{
			if(!nodes[i].isVisited)
			{
				boolean checker = bfs.run(nodes[i]);
					
				if(checker)
				{
					System.out.println("is this a bipartite? : "+!checker);
					isNotFound=false;
					return;
				}
			}
		}
		
		if(isNotFound==true)
		{
			System.out.println("is this a bipartite? : "+isNotFound);
		}
		
	   

	}
	
	static void createGraph(int[][] graph) {
		for(int i = 0; i < graph.length; i++) {
			graph[i][i] = 0;
		}
		for(int i = 0; i < graph.length; i++) {
			for(int j = i + 1; j < graph.length; j++) {
				graph[i][j] = (int) (rand.nextInt(2));
				graph[j][i] = graph[i][j];
			}
		}
	}
	
	
	static ArrayList makeList(int[][] graph)
	{
		nodes=new Nodes[graph.length];
		for(int index= 0; index!=nodes.length;index++)
		{
			nodes[index] = new Nodes(String.format("%d",index));
		}
		
		ArrayList outside=new ArrayList();
		for(int i =0 ; i!=graph.length;i++)
		{
			ArrayList inside = new ArrayList();
			for(int j=0; j!=graph[i].length;j++)
			{
				if(graph[i][j]==1)
				{
					inside.add(j);
					nodes[i].addOut(nodes[j]);
				}
			}
			outside.add(inside);
		}
		return outside;
	}
	
}
