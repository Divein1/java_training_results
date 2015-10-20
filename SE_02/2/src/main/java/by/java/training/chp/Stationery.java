package by.java.training.chp;

public class Stationery implements Prices {

	public static void main(String[] args) {
		Worker worker1 = new Worker("IVAN IVANOV");
		worker1.addItem("Pen", PEN, 1);
		worker1.addItem("Pencil", PENCIL, 3);
		worker1.addItem("Tape", TAPE, 2);
		worker1.addItem("Eraser", ERASER, 1);
		worker1.addItem("Stapler", STAPLER, 1);
		worker1.addItem("Notepad", NOTEPAD, 2);
		worker1.addItem("Paper 1kg", 72500, 2);

		System.out.println(worker1);
		worker1.getStats();
		System.out.println();

		worker1.removeItem(worker1.getByName("pen"));
		System.out.println(worker1);
		worker1.getStats();
		System.out.println();

		worker1.addItem("Pen Craus", PEN, 1);
		System.out.println(worker1);
		worker1.getStats();
		System.out.println();
		
		Worker worker2 = new Worker();
		System.out.println(worker2);
		worker2.getStats();
		System.out.println();
		
		Worker worker3 = new Worker("PETR PETROV",10);
		worker3.addItem("Pen", PEN, 1);
		worker3.addItem("Pencil", PENCIL, 3);
		System.out.println(worker3);
		worker3.getStats();

	}

}
