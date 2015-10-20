package by.java.training.chp;

public class Worker {
	final String name;
	private Item[] itemPool;
	private int itemCount = 20;

	public Worker() {
		name = "John Smith";
		itemPool = new Item[itemCount];
	}

	public Worker(String name) {
		this.name = name;
		itemPool = new Item[itemCount];
	}
	
	public Worker(String name, int itemCount) {
		this.name = name;
		itemPool = new Item[itemCount];
	}

	public void getStats() {
		int summ = 0;
		for (int i = 0; i < itemPool.length; i++) {
			if (itemPool[i] != null) {
				summ = summ + itemPool[i].price * itemPool[i].count;
			}
		}
		System.out.println("Total stationery price of worker " + name + " is " + summ + " rub.");
	}

	public void addItem(String name, int price, int count) {
		for (int i = 0; i < itemPool.length; i++) {
			if (itemPool[i] == null) {
				itemPool[i] = new Item(name, price, count);
				break;
			}
		}

	}

	public int getByName(String str) {
		int index = 0;
		for (int i = 0; i < itemPool.length; i++) {
			if (itemPool[i] != null) {
				if (itemPool[i].name.equalsIgnoreCase(str))
					index = i;
			}
		}
		return index;
	}

	public void removeItem(int item) {
		itemPool[item] = null;
		for (int i = 0; i < itemPool.length; i++) {
			if (i != itemPool.length - 1) {

				if (itemPool[i] == null) {
					itemPool[i] = itemPool[i + 1];
					itemPool[i + 1] = null;

				}
			}
		}
	}

	@Override
	public String toString() {
		String output = "";
		int count = 0;

		for (int i = 0; i < itemPool.length; i++) {
			if (itemPool[i] != null) {
				System.out.println(output + itemPool[i]);
				count++;
			}
		}

		return "Name: " + name + output + ", Quantity of items: " + count + "]";
	}
}
