package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> numbers = new ArrayList<>();
		int previous = 1, current = 0, accumulator = 0;

		do {
			if(current <= 0) {
				numbers.add(current);
			}
			accumulator = previous + current;
			previous = current;
			current = accumulator;
			numbers.add(accumulator);
		}
		while (accumulator <= 350);

		return numbers;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}