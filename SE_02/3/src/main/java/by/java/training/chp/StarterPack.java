package by.java.training.chp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import by.java.training.chp.items.*;

public class StarterPack {

	public static void main(String[] args) {
		ArrayList<Stationery> StPack = new ArrayList<Stationery>();
		StPack.add(new Printer("Epson x1", 500000));
		StPack.add(new Stapler("Stapler", 20000));
		StPack.add(new InkCartridge("Epson x1 Cartridge", 200000));
		StPack.add(new BallPen("Blue pen", 3500));
		StPack.add(new BallPen("Red pen", 3500));
		StPack.add(new Pencil("Pencil", 3500));
		StPack.add(new Pencil("Pencil", 2500));
		StPack.add(new OfficePaper("Paper 1kg", 50000));
		StPack.add(new Calculator("Calculator", 15000));

		System.out.println("Initial ArrayList");
		System.out.println(StPack);

		Collections.sort(StPack, new Comparator<Stationery>() {
			public int compare(Stationery o1, Stationery o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
				// how without abst getter? str, int
			}
		});
		System.out.println("\nArrayList by name");
		System.out.println(StPack);

		Collections.sort(StPack, new Comparator<Stationery>() {
			public int compare(Stationery o1, Stationery o2) {
				Integer pr1 = o1.getPrice();
				Integer pr2 = o2.getPrice();
				return pr1.compareTo(pr2);
			}
		});
		System.out.println("\nArrayList by price");
		System.out.println(StPack);

		Collections.sort(StPack, new Comparator<Stationery>() {

			public int compare(Stationery o1, Stationery o2) {
				if (o1.getName().compareToIgnoreCase(o2.getName()) != 0) {
					return o1.getName().compareToIgnoreCase(o2.getName());
				} else {
					Integer pr1 = o1.getPrice();
					Integer pr2 = o2.getPrice();
					return pr1.compareTo(pr2);
				}
			}

		});
		System.out.println("\nArrayList by name and price");
		System.out.println(StPack);
	}

}
