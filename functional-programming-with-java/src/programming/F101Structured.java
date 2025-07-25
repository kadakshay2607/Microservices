package programming;

import java.util.List;

public class F101Structured {

	public static void main(String[] args) {

		printEvenNumbers(List.of(2,3,4,5,2,1));

	}

	private static void printAllNumbers(List<Integer> of) {
		for (int number:of) {
			System.out.println(number);
		}
		
	}
	
	private static void printEvenNumbers(List<Integer> of) {
		
		for (int integer : of) {
			if (integer%2==0) {
				System.out.println(integer);
			}
		}
	}

}
