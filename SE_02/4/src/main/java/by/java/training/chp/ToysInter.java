package by.java.training.chp;

import java.util.ArrayList;
import java.util.Collections;

public class ToysInter implements Comparable<ToysInter> {
	String name;
	int price;

	public ToysInter() {
		this("undef",0);
	}

	public ToysInter(String name, int price) {
		this.name = name;
		this.price = price;

	}

	@Override
	public String toString() {
		return "\n" + name + ", price:" + price;
	}

	public static void main(String[] args) {
		ArrayList<ToysInter> shop = new ArrayList<ToysInter>();
		shop.add(new ToysInter("Bear White", 10));
		shop.add(new ToysInter("Bear", 10));
		shop.add(new ToysInter("Bear Blue", 10));
		shop.add(new ToysInter("Bear blue", 12));
		shop.add(new ToysInter("Tiger", 12));
		shop.add(new ToysInter("Gameboy", 30));
		shop.add(new ToysInter("PS4", 399));
		shop.add(new ToysInter("PS4", 349));
		shop.add(new ToysInter("Air gun", 15));
		shop.add(new ToysInter("Air rifle", 22));
		shop.add(new ToysInter("Air rifle", 29));
		System.out.println(shop);
		Collections.sort(shop);
		System.out.println();
		System.out.println(shop);

	}

	public int compareTo(ToysInter o) {
		if (name.compareTo(o.name) != 0) {
			return name.compareTo(o.name);
		}
		Integer pr1 = price;
		Integer pr2 = o.price;
		return pr1.compareTo(pr2); // == return Integer.valueOf(price).compareTo(Integer.valueOf(o.price));

	}

}
