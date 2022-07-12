package pl.strefakursow._2_gotowe_interfejsy_funkcyjne_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Operatorr {
	/*
	Operatory to interfejsy reprezentujące funkcję dla
	której zwracana wartość i argument są takie same.

	Ogólna struktura: T apply(T t), gdzie T to typ przyjmowany i zwracany

	Możemy je podzielić na UnaryOperator i BinaryOperator.
	Unary przyjmuje jeden argument a Binary dwa.
	 */

	public static void main(String[] args) {
		List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> output1 = unaryFunction(input, x -> x * x);
		System.out.println(output1);

		// Integer::sum == (a, b) -> a + b
		Integer output2 = binaryFunction(input, 0, Integer::sum);
		System.out.println(output2);
	}

	private static <T> List<T> unaryFunction(List<T> list, UnaryOperator<T> unaryOperator) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(unaryOperator.apply(t));
		}
		return result;
	}

	private static <T> T binaryFunction(List<T> list, T init, BinaryOperator<T> unaryOperator) {
		T result = init;
		for (T t : list) {
			result = unaryOperator.apply(result, t);
		}
		return result;
	}
}
