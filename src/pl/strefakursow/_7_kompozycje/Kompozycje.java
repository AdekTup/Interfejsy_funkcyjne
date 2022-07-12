package pl.strefakursow._7_kompozycje;

import java.util.function.Function;
import java.util.function.Predicate;

public class Kompozycje {
	/*
		Kompozycja funkcyjna pozwala na łączenie kilku funkcji w jedną. Możemy rozróżnić:
		- kompozycje predykatów z metodami: and() i or()
		- kompozycje funkcji z metodami: compose() i andThen()
	 */
	public static void main(String[] args) {
		// predykat: and() i or()
		Predicate<String> zawieraI = (t) -> t.contains("i");
		Predicate<String> maDlugosc10   = (t) -> t.length() == 10;
		Predicate<String> zaczynaSieZnakiemA = (t) -> t.startsWith("A");
		Predicate<String> konczySieZnakiemY = (t) -> t.endsWith("y");

		String input1 = "Ala ma kota i dwa psy";
		String input2 = "Ala ma psy";
		String input3 = "Ala ma pieski";

		Predicate<String> predicate =
			zawieraI.and(zaczynaSieZnakiemA).and(konczySieZnakiemY).or(maDlugosc10);

		boolean output1 = predicate.test(input1);
		boolean output2 = predicate.test(input2);
		boolean output3 = predicate.test(input3);
		System.out.println(output1);
		System.out.println(output2);
		System.out.println(output3);

		System.out.println();

		// funkcje: compose()
		Function<Double, Double> pomnozPrzez3 = (x) -> x * 3;
		Function<Double, Double> dodaj5 = (x) -> x + 5;
		Function<Double, Double> podzielPrzez4 = (x) -> x / 4;

		// ((3/4) + 5) * 3 = 17.25
		Function<Double, Double> functionCompose =
			pomnozPrzez3.compose(dodaj5).compose(podzielPrzez4);

		Double result1 = functionCompose.apply(3.0);
		System.out.println(result1);


		// funkcje: andThen()
		// ((3 * 3) + 5) / 4 = 3.5
		Function<Double, Double> functionAndThen =
			pomnozPrzez3.andThen(dodaj5).andThen(podzielPrzez4);
		Double result2 = functionAndThen.apply(3.0);
		System.out.println(result2);
	}
}
