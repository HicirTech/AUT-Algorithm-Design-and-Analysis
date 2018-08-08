package lab3;
import java.util.*;
public class notTheDFSGraph<T> {

	private double[][] matrix;
	private T[] vertex;
	private int vertexNum;
	private boolean noNext = false;	
	private List<List<T>> result = new ArrayList<>();
 
	public notTheDFSGraph(double[][] matrix, T[] vertex) {
		this.matrix = matrix;
		this.vertex = vertex;
		vertexNum = matrix.length;
	}
		
	private void DFS(int begin, List<T> path) {
		
		path.add(vertex[begin]);
	
		int rollBackNum = -1;
	
		for (int i = 0; i < vertexNum; i++) {
			if ((matrix[begin][i] > 0)) {
				path.add(vertex[i]);
				if (containBranch(result, path)) {				
					path.remove(vertex[i]);					
					rollBackNum = i;					
					continue;
				} else {
					path.remove(vertex[i]);
					DFS(i, path);
				}
			}
			if (noNext) {
				return;
			}
		}
		if (rollBackNum > -1) {
			DFS(rollBackNum, path);
		} else {
			noNext = true;
		}
	}
	
	public List<List<T>> startSearch() {
		for (int i = 0; i < countPathNumber(); i++) {
			List<T> path = new LinkedList<>();
			noNext = false;
			DFS(0, path);
			result.add(path);
		}
		return result;
	}
 
	private int countPathNumber() {
		int[] numberArray = new int[vertexNum];
		for (int i = 0; i < vertexNum; i++) {
			for (int j = 0; j < vertexNum; j++) {
				if (matrix[j][i] > 0) {
					numberArray[j]++;
				}
			}
		}
		int number = 1;
		for (int k = 0; k < vertexNum; k++) {
			if (numberArray[k] > 1) {
				number++;
			}
		}
		return number;
	}
 

	private boolean containBranch(List<List<T>> nodeLists, List<T> edges) {
		for (int i = 0; i < nodeLists.size(); i++) {
			List<T> list = nodeLists.get(i);
			if (list.containsAll(edges)) {
				return true;
			}
		}
		return false;
	}
 
}
