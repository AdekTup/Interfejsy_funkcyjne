package pl.strefakursow._3_gotowe_interfejsy_funkcyjne_funkcja;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functionn {
	/*
		Function to interfejs przyjmujący jedent typ a zwracający inny typ.

		Ogólna struktura: R apply(T t, R r), gdzie T to typ przyjmowany a R zwracany.

		Podobnie jak w Operator, wyróżniamy Function i BiFunction,
		gdzie Bi przyjmuje zamiast jednego, dwa parametry.
	 */

	public static void main(String[] args) {
		// Funkcja zamieniająca liste na mape -> mapuje liste na tekst, długość tekstu.
		List<int[]> input = List.of(new int[]{1,2}, new int[]{2,3}, new int[]{3,4}, new int[]{4,5});
		Map<int[], Integer> output1 = listToMapConverter(input, Functionn::sumArray);

		for (Map.Entry<int[], Integer> entry : output1.entrySet()) {
			System.out.println(Arrays.toString(entry.getKey()) + " = " + entry.getValue());
		}


		// Fabryka objektów typu Animal
		List<Animal> output2 = List.of(
			factory("Mruczek", Species.CAT, Animal::new),
			factory("Burek", Species.DOG, Animal::new),
			factory("Elemelek", Species.BIRD, Animal::new)
		);

		System.out.println(output2);
	}

	private static <T, R> Map<T, R> listToMapConverter(List<T> list, Function<T, R> function) {
		Map<T, R> result = new HashMap<>();
		for (T t : list) {
			result.put(t, function.apply(t));
		}
		return result;
	}

	private static Integer sumArray(int[] array) {
		int result = 0;
		for (int i : array) {
			result += i;
		}
		return result;
	}

	private static <R extends Animal> R factory(String name, Species species,
											   BiFunction<String, Species, R> funct) {
		return funct.apply(name, species);
	}
}
