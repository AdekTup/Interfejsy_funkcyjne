package pl.strefakursow._6_tworzenie_wlasnych_interfejsow_funkcyjnych;

import java.util.List;

public class WlasneIF {
	/*
		Własny interfejs funkcyjny warto napisać gdy:
		- Nie znaleźliśmy pasującego gotowego interfejsu.
		- Uważamy, że napisanie nowego sprawi, że nasz kod będzie czytelniejszy.
	*/

	public static void main(String[] args) {
		CustomFI customFI = (a, b, c, d) -> 0.5 * a + (((b + 15) * 0.6 * c) + 5) / c * (d + a);
		System.out.println(customFI.calculate(3, 5, 1.5, 1.6));
	}
}
