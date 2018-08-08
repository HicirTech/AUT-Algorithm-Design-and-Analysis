package lab3;

import java.util.ArrayList;

public class Vertex {
	ArrayList<Vertex> outNeighbours=new ArrayList<>();
	boolean isVisited=false;
	String name;
	Vertex previous=null;

	public Vertex() {
	}
	
	public Vertex(String name) {
		this.name=name;
	}
	
	public void link(Vertex outNeighbour) {
		outNeighbours.add(outNeighbour);
	}
	
	public Vertex unvisitedOutneighbour() {
			for(int i=0;i<outNeighbours.size();i++)	{ //Search through all outneighbours
				if(!outNeighbours.get(i).isVisited)
					return outNeighbours.get(i); // Return an unvisited outneighbour
			}
		return null;
		
	}
	
	public boolean isTheEnd() {
		return (unvisitedOutneighbour()==null); //It is the end if it doesn't have any unvisited outneighbours.
	}
}
