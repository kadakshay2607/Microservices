package programming;

import java.util.List;

public class F01FunctionalExrcises {

	public static void main(String[] args) {

		List<Integer> of = List.of(2, 3, 4, 5, 6, 1);
		List<String> courses = List.of("AWS", "AZURE", "JAVA", "SQL", "MICROSERVICES", "SPRINGBOOT", "API", "DOCKER",
				"KUBERNETS", "SPRING");
		// printoddNumber(of);

		// courses.stream().forEach(System.out::println);

//		courses.stream().filter(course -> course.contains("spring")).forEach(System.out::println);

		// courses.stream().filter(course -> course.length() >
		// 4).forEach(System.out::println);

		courses.stream().map(course -> course.length()).forEach(System.out::println);
	}

	private static void printoddNumber(List<Integer> numbers) {
		numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
	}

}
