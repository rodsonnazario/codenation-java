package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

	public static int average(int[] elements) {
		return elements.length > 0 ?
				Arrays.stream(elements).reduce(0, Integer::sum) / elements.length :
				0;
	}

	public static int mode(int[] elements) {
		Map<Integer, Integer> mapa = new HashMap<>();
		int moda = 0, ocorrencias = 0;
		for(int element: elements) {
			int acumulador = mapa.get(element) != null ? mapa.get(element)+1 : 1;
			mapa.put(element, acumulador);
			if(acumulador > ocorrencias) {
				ocorrencias = acumulador;
				moda = element;
			}
		}
		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		return elements.length % 2 == 0 ?
				(elements[elements.length / 2] + elements[elements.length / 2 - 1]) / 2:
				elements[elements.length / 2];
	}
}