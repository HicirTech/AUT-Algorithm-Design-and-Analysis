package lab1;
import java.util.Scanner;
public class Runable {

	public static void main(String[] args) {
		
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.tryOne();
		fibonacci.tryTwo();
		fibonacci.tryThree();
		System.out.println("ERROR IN TRY FOUR");
		fibonacci.tryFour();
		
	}

}
