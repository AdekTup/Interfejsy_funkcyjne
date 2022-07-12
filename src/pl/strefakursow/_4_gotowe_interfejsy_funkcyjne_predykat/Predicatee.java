package pl.strefakursow._4_gotowe_interfejsy_funkcyjne_predykat;

import java.nio.file.DirectoryStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicatee {
	/*
		Predykat umożliwia zapisywanie warunków logicznych.

		Konstrukcja: boolean test(T t)

		Gdy argumentem jest typ prosty, stosujemy przedrostki, np. IntPredicate czy LongPredicate.
	 */

	public static void main(String[] args) {
		List<String> input = List.of("Ala", "ma", "kota", "i", "dwa", "psy");
		isWordsWiderThan(input, s -> s.length() > 2);
		System.out.println();
		biPredisWordsWiderThan(input, (s, b) -> s.length() > b);
	}

	private static void isWordsWiderThan(List<String> list, Predicate<String> predicate) {
		for (String s : list) {
			if (predicate.test(s)) {
				System.out.println(s + " -> passed");
			} else {
				System.out.println(s + " -> not passed");
			}
		}
	}

	private static void biPredisWordsWiderThan(List<String> list, BiPredicate<String, Integer> predicate) {
		int b = 2;
		for (String s : list) {
			if (predicate.test(s, b)) {
				System.out.println(s + " -> passed");
			} else {
				System.out.println(s + " -> not passed");
			}
		}
	}
}
