package Lab2;

import java.util.ArrayList;
/**
 * this is the lab2 Question 3.2, this class will take a sorted array, and a value to lookup. 
 * a index will be randomly generated, it will not repeat, a index will only be search onece
 * @author Luo Zeting ID:16938158
 * @see  https://github.com/HicirTech/AUT-ADA
 */
public class lab2 {
	private int[] array;
	private int value;
	private ArrayList<Integer> repeat;
	lab2(int[] array, int value)
	{
		this.array=array;
		this.value=value;
		this.repeat=new ArrayList<>();
	}
	public boolean lookFor() {
		int i = getRamdom(); // get a random not repeat index 
		repeat.add(i); //  add it to repeat list, so that this index will not show up again
						// it is equal to search in the subArray
		return (array[i]==value)?true:(repeat.size()==array.length)?false:lookFor();
							// if value found return true
							// if value not found in the array return false
							// if value not found and it is not the end of the array
							// go to next index lookfor
	}		
	
	private int getRamdom()
	{
		int i;
		do {
			i= (int) (Math.random()*array.length);
		}while(repeat.contains(i)==true);
		return i;
	}
	
}

