package by.java.training.chp;

public class TwoDimensionalXArray {

	public static void main(String[] args) {
		int i,j;
		final int n = 13;
		int[][] array = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if ((i == j)||(i == (array.length - 1 - j)))
					array[i][j] = 1;
				System.out.printf("%3d",array[i][j]);
			}
			System.out.println();
		}
	}

}
