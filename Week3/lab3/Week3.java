package lab3;

import java.util.ArrayList;
import java.util.Stack;

public class Week3 {

	public static void main(String[] args) {
		long startTime=System.nanoTime();
		ArrayList<Vertex> graph=buildGraph();
		stackTraverse(graph);
		System.out.println("The time of using stack is: "+(System.nanoTime()-startTime));
		
		startTime=System.nanoTime();
		graph=buildGraph();
		recursiveTraverse(graph);
		System.out.println("The time of using recursion is: "+(System.nanoTime()-startTime));
		//System.out.println("Finished!");
	}
	
	public static ArrayList<Vertex> buildGraph() {
		Vertex vA=new Vertex("A");
		Vertex vB=new Vertex("B");
		Vertex vC=new Vertex("C");
		Vertex vD=new Vertex("D");
		Vertex vE=new Vertex("E");
		Vertex vF=new Vertex("F");
		Vertex vG=new Vertex("G");
		Vertex vH=new Vertex("H");
		Vertex vI=new Vertex("I");
		Vertex vJ=new Vertex("J");
		Vertex vK=new Vertex("K");
		Vertex vL=new Vertex("L");
		Vertex vM=new Vertex("M");
		Vertex vN=new Vertex("N");
		Vertex vO=new Vertex("O");
		Vertex vP=new Vertex("P");
		Vertex vQ=new Vertex("Q");
		Vertex vR=new Vertex("R");
		Vertex vS=new Vertex("S");
		Vertex vT=new Vertex("T");
		Vertex vU=new Vertex("U");
		Vertex vV=new Vertex("V");
		Vertex vX=new Vertex("X");
		Vertex vY=new Vertex("Y");
		Vertex vZ=new Vertex("Z");
		Vertex v1=new Vertex("1");
		Vertex v2=new Vertex("2");
		Vertex v3=new Vertex("3");
		Vertex v4=new Vertex("4");
		Vertex v5=new Vertex("5");
		
		vA.link(vB);
		vA.link(vH);
		vB.link(vC);
		vC.link(vD);
		vC.link(vM);
		vC.link(vP);
		vD.link(vJ);
		vF.link(vE);
		vG.link(vH);
		vG.link(vF);
		vG.link(vJ);
		vH.link(vI);
		vK.link(vM);
		vK.link(vL);
		vL.link(vO);
		vM.link(vN);
		vO.link(vR);
		vO.link(vQ);
		vP.link(vQ);
		vP.link(vX);
		vR.link(vV);
		vS.link(vT);
		vT.link(vU);
		vX.link(vY);
		vX.link(vT);
		vY.link(vT);
		vZ.link(v1);
		v1.link(v2);
		v3.link(v5);
		v4.link(vX);
		
		ArrayList<Vertex> vertices=new ArrayList<>();
		vertices.add(vA);
		vertices.add(vG);
		vertices.add(vK);
		vertices.add(vS);
		vertices.add(v3);
		vertices.add(v4);
		
		return vertices;
	}
	
	public static void stackTraverse(ArrayList<Vertex> graph) {
		Stack<Vertex> traverseStack=new Stack<>();
		Vertex currentVertex;
		ArrayList<Vertex> visitedVertices=new ArrayList<>(); // Put all visited vertices in this vertex. Not really used...
		
		for(int i=0;i<graph.size();i++)
		{
			boolean goingBack=false;
			currentVertex=graph.get(i);
			do {
				if(!goingBack)
				{
					traverseStack.push(currentVertex);
					//System.out.println(traverseStack.peek().name+" pushed.");
				}
					
				
				if(traverseStack.peek().isTheEnd())
				{
					traverseStack.peek().isVisited=true;
					visitedVertices.add(traverseStack.pop());
					//System.out.println(visitedVertices.get(visitedVertices.size()-1).name+" popped.");
					goingBack=true;
				}
				else {
					goingBack=false;
					currentVertex=traverseStack.peek().unvisitedOutneighbour();				
				}
				
			}while(!traverseStack.isEmpty());
			
			System.out.println("Branch finished!");
			System.out.println();
		}
		
		
		
	}

	public static void recursiveTraverse(ArrayList<Vertex> graph) {
		Vertex currentVertex;
		for(int i=0; i<graph.size();i++)
		{
			currentVertex=graph.get(i);
			recursivePath(currentVertex);
			System.out.println("Branch finished!");
			System.out.println();
		}
		
	}
	
	public static void recursivePath(Vertex v) {
		System.out.println("Current vertex is "+v.name);
		if(!v.isTheEnd())
		{
			v.unvisitedOutneighbour().previous=v;
			recursivePath(v.unvisitedOutneighbour());
		}
			
		else
		{
			v.isVisited=true;
			System.out.println(v.name+ " is visited!");
			if(v.previous!=null)
				recursivePath(v.previous);
		}
			
	}
}
