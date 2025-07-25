package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalExcercise {

	public static void main(String[] args) {
		List<String> fruits = List.of("APPLE", "BANANA", "MANGO");

		Predicate<? super String> predicate = ruit -> ruit.startsWith("T");
		
		Optional<String> optional = fruits.stream().filter(predicate).findFirst();
		
		System.out.println("optinal :" + optional);
		
		System.out.println("optinal.isEmpty:" + optional.isEmpty());

		System.out.println("optinal.isPresent :" + optional.isPresent());

		System.out.println("optinal.get :" + optional.get());

	}
}
