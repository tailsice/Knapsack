package algorithm;

public class Thing {
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