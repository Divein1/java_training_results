package by.java.training.chp;
public class Fxcalc {

	public static void main(String[] args) {
		double a = 1, b = 10, h = 2, F, x;
		x = a;
		System.out.print("F(x)=tg(2x)-3");
		while (x<=b) {
			F = Math.tan( 2 * x ) - 3;
			System.out.printf("\nif x= %1.0f, F(x)= %5f;", x, F);
			x+=h;
		}
		


		}
		

	}

