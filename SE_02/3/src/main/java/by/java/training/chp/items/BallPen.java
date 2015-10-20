package by.java.training.chp.items;

import by.java.training.chp.WritingImplements;

public class BallPen extends WritingImplements {
	String name;
	int price;

	public BallPen(String name, int price) {
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