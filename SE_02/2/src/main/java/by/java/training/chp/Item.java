package by.java.training.chp;

public class Item {
	String name;
	int price;
	int count;

	public Item() {
	}

	public Item(String name, int price, int count) {
		this.name = name;
		this.count = count;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[Item: " + name + ", price: " + price + ", count: " + count + ", total:" + price * count + "]";
	}

}
