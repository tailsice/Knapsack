package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
	public static void main(String[] args) throws Exception {

		List<Thing> thing = Arrays.asList(new Thing("File1", 5, 63), new Thing(
				"File2", 3, 50), new Thing("File3", 7, 38), new Thing("File4",
				2, 30), new Thing("File5", 2, 20), new Thing("File6", 3, 20));
		int W = 12;

		System.out.println(knapsack(thing, W));
	}

	public static int knapsack(List<Thing> thing, int W) {

		int N = thing.size();
		int val[] = new int[N];
		int wt[] = new int[N];
		String name[] = new String[N];

		int[][] V = new int[N + 1][W + 1];

		int point = 0;
		for (Thing a : thing) {
			val[point] = a.getPrice();
			wt[point] = a.getWeight();
			name[point] = a.getName();
			point++;
		}

		for (int col = 0; col <= W; col++) {
			V[0][col] = 0;
		}

		for (int row = 0; row <= N; row++) {
			V[row][0] = 0;
		}

		for (int item = 1; item <= N; item++) {
			for (int weight = 1; weight <= W; weight++) {
				if (wt[item - 1] <= weight) {
					V[item][weight] = Math.max(val[item - 1]
							+ V[item - 1][weight - wt[item - 1]],
							V[item - 1][weight]);
				} else
					V[item][weight] = V[item - 1][weight];
			}
		}

		// Printing the matrix
		for (int[] rows : V) {
			for (int col : rows) {
				System.out.format("%5d", col);
			}
			System.out.println();
		}

		int tmpInt = 0;
		List<Integer> re = new ArrayList<Integer>();
		for (int num = 1; num <= N; num++) {
			if (tmpInt != V[num][W]) {
				tmpInt=V[num][W];
				re.add(num - 1);
			}
		}

		//System.out.println("re size = " + re.size());

		for (Integer a : re)
			System.out.print(thing.get(a)+", ");
		System.out.println();

		//System.out.println(thing.toString());

		return V[N][W];
	}
}

class Thing {
	String name;
	int weight;
	int price;

	Thing(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public String toString() {
		return String.format("(%s, %d, %d)", name, weight, price);
	}

	public int getWeight() {
		return this.weight;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}
}
