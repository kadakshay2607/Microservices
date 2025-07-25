package programming;

import java.util.List;

public class F101Functional {

	public static void main(String[] args) {

		List<Integer> of = List.of(2, 3, 4, 5, 32, 5);
		printSqureOfEvenNumber(of);

	}

//	private static void print(int number) {
//		System.out.println(number);
//	}

	private static void printAllNumbers(List<Integer> numbers) {

//		for (int number:of) {
//			System.out.println(number);
//		}
		
//		numbers.stream().forEach(F101Functional::print);

		numbers.stream().forEach(System.out::println);

	}
	
	private static boolean isEven(int number) {
		return number%2==0;
		
	}
	
	private static void printEvenNumber(List<Integer> numbers) {
		//numbers.stream().filter(F101Functional::isEven).forEach(System.out::println);
		numbers.stream().filter(number -> number%2==0).forEach(System.out::println);

	}
	
	private static void printSqureOfEvenNumber(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number%2==0)
		.map(number -> number * number)
		.forEach(System.out::println);

	}

}
