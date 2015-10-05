package by.java.training.chp;

public class Loops {
	
	private static void forLoop(int[] mass){
		for (int  i = 1; i < mass.length; i = i + 2){
			mass[i] = mass[i]*mass[i-1];
		}
		System.out.println("\nModified by for");
		for (int i = 0; i < mass.length; i++){
			System.out.printf("%5d",mass[i]);
			}	
	}
	
	private static void doWhileLoop(int[] mass){	
		int i = 1;
	do {	
		mass[i] = mass[i]*mass[i-1];
		i += 2;
		}
	while (i < mass.length);
	System.out.println("\nModified by do .. while");
	for ( i = 0; i < mass.length; i++)
		{
		System.out.printf("%5d",mass[i]);
		}
	}
	
	private static void whileLoop(int[] mass){
		int i = 1;
		while (i < mass.length) {
			mass[i] = mass[i]*mass[i-1];	
			i += 2;
		}
		System.out.println("\nModified by while");
		for ( i = 0; i < mass.length; i++){
			System.out.printf("%5d",mass[i]);
			}	
	}
	
	public static void main(String[] args){
		int array[] = new int[20];
		for (int i = 0; i < 20; i++) {
			while (true){
			array[i] = (int)(Math.random()*11);
			if (array[i] % 2 == 0)
				break;
			}
		}
		System.out.println("Initial array");
		for (int i = 0; i < 20; i++){
		System.out.printf("%5d",array[i]);
		}
		forLoop(array);
		whileLoop(array);
		doWhileLoop(array);
		
	}
}
