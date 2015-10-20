package by.java.training.chp.items;

import by.java.training.chp.Consumables;

public class TonerCartridge extends Consumables {

	String name;
	int price;

	public TonerCartridge(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "\n" + name + ", price: " + price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}