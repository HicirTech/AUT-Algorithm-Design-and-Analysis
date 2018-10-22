package Assignment;

import java.util.Scanner;
/**
 * Ada-assginment 2 
 * entry point question 3 and question 4
 * @author Luo Zeting ID:16938158
 *
 */
public class Q3Q4Runable {

	public static void main(String[] args)
	{
		System.out.println("Here is the Q3, Q4 test");
		
		System.out.println("Please select Question to test");
		
		System.out.println("1. Question 3");
		System.out.println("2. Question 4");
		int userInput = new Scanner(System.in).nextInt();
		ActionControl ac= new ActionControl(new Q3GUI(),new Spider(),new Q4GUI(),new PageRank());
		if(userInput==1)
		{
			System.out.println("You Selected Q3");
			ac.Q3Begin();
		}
		else if(userInput == 2)
		{
			System.out.println("You Selected Q4");
			ac.Q4Begin();
		}
		else
		{
			System.out.println("Select error");
		}
		
		
	}
}
