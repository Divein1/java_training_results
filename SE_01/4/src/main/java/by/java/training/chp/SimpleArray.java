package by.java.training.chp;

public class SimpleArray {

	public static void main(String[] args) {	
			final int n = 7;
			int max = 0,index = 0;;
			int array[] = new int[2*n];
			for(int i = 0; i<2*n; i++ ){
				array[i] = (int)(Math.random()*11);
			}
			
			for (int i = 0; i < n; i++){
				if (array[i]+array[2*n - i - 1]>max){
				max = array[i]+array[2*n - i - 1];
				index = i;
				}
				System.out.printf("%d)  %-2d+ ",i, array[i]);
				System.out.println(array[2*n - i - 1]);
			}
			System.out.printf("\nMax is %d at index %d", max, index);

	}

}
