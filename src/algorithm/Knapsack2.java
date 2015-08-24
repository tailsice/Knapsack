package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Unbounded Knapsack Problem

public class Knapsack2 {

	public static void main(String[] args) {
		List<Thing> thing = Arrays.asList(new Thing("File1", 5, 63), new Thing(
				"File2", 3, 50), new Thing("File3", 7, 38), new Thing("File4",
				2, 30), new Thing("File5", 2, 20), new Thing("File6", 3, 20));
		System.out.println(knapsack2(thing, 12));

	}

	public static List<Thing> knapsack2(List<Thing> thing, int limit) {
		int[] values = new int[limit + 1];
		int[] items = new int[limit + 1];
		for (int i = 0; i < thing.size(); i++) {
			for (int w = thing.get(i).weight; w <= limit; w++) {
				int p = w - thing.get(i).weight;
				int newValue = values[p] + thing.get(i).price;
				if (newValue > values[w]) {
					values[w] = newValue;
					items[w] = i;
				}
			}
		}
		List<Thing> solution = new ArrayList<>();
		int min = Collections.min(thing, (f1, f2) -> f1.weight - f2.weight).weight;
		for (int i = limit; i >= min; i -= thing.get(items[i]).weight) {
			solution.add(thing.get(items[i]));
		}
		return solution;
	}
}