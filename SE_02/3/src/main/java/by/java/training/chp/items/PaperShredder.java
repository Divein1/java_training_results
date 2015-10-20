package by.java.training.chp.items;

import by.java.training.chp.OfficeEquipment;

public class PaperShredder extends OfficeEquipment {
	String name;
	int price;

	public PaperShredder(String name, int price) {
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