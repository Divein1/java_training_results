package by.java.training.chp.items;

import by.java.training.chp.*;

public class InkCartridge extends Consumables {
	String name;
	int price;

	public InkCartridge(String name, int price) {
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