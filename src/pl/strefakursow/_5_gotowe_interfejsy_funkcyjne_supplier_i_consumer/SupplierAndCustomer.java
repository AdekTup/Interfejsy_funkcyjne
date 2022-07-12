package pl.strefakursow._5_gotowe_interfejsy_funkcyjne_supplier_i_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndCustomer {
	/*
		Supplier to interfejs, który zwraca obiekt i nie przyjmuje żadnych argumentów.
		Konstrukcja: T get()
		Przykład: LocalDate::now

		Customer to interfejs, który nic nie zwraca i przyjmuje obiekt.
		Konstrukcja: void accept(T t)
		Przykład: System.out::println
	 */

	public static void main(String[] args) {
		List<Order> input = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			input.add(factory(Order::new));
		}
		System.out.println(input);
		System.out.println();

		markAllDone(input, order -> order.setStatus(Status.DONE));
		// wersja z referencją
		markAllDone(input, SupplierAndCustomer::setDone);

		System.out.println();
		System.out.println(input);
	}

	private static Order factory(Supplier<? extends Order> supplier) {
		Order order = supplier.get();
		order.setStatus(Status.IN_PROGRESS);
		return order;
	}

	private static <T> void markAllDone(List<T> list, Consumer<T> consumer) {
		System.out.println("Marking...");
		for (T t : list) {
			consumer.accept(t);
		}
		System.out.println("Done.");
	}

	private static void setDone(Order order){
		order.setStatus(Status.DONE);
	}
}
