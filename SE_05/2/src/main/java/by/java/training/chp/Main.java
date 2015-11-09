package by.java.training.chp;

import static by.java.training.chp.propertyGetter.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Prop file contents:");
		System.out.println(
				loadAllProp("questions_en_US.properties").toString());

		System.out.println("Fifth property is:");
		System.out.println(
				loadProp("questions_en_US.properties", "5"));

	}

}
