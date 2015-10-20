package by.java.training.chp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Toys {
	String name;
	int price;

	public Toys() {
		this("undef",0);
	}

	public Toys(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "\n" + name + ", price:" + price;
	}

	public static void main(String[] args) {
		ArrayList<Toys> shop = new ArrayList<Toys>();
		shop.add(new Toys("Bear White", 10));
		shop.add(new Toys("Bear", 10));
		shop.add(new Toys("Bear Blue", 10));
		shop.add(new Toys("Bear blue", 12));
		shop.add(new Toys("Tiger", 12));
		shop.add(new Toys("Gameboy", 30));
		shop.add(new Toys("PS4", 399));
		shop.add(new Toys("PS4", 349));
		shop.add(new Toys("Air gun", 15));
		shop.add(new Toys("Air rifle", 22));
		shop.add(new Toys("Air rifle", 29));
		
		System.out.println(shop);
		Collections.sort(shop, new Comparator<Toys>() {
			public int compare(Toys o1, Toys o2) {
				if (o1.name.compareToIgnoreCase(o2.name) != 0) {
					return o1.name.compareToIgnoreCase(o2.name);
				} else {
					Integer p1 = o1.price;
					Integer p2 = o2.price;
					return p1.compareTo(p2);
				}
			}
		});
		System.out.println();
		System.out.println(shop);

	}

}
