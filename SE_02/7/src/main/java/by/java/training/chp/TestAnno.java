package by.java.training.chp;

import java.lang.reflect.Method;

public class TestAnno {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {

		Class<?> testClass = Class.forName("by.java.training.chp.NuclearSubmarineAnno");

		Method m = testClass.getMethod("callEngineStart");
		MethAnno annotation = m.getAnnotation(MethAnno.class);
		if (m.isAnnotationPresent(MethAnno.class)) {
			System.out.println("Method annotated");
			System.out.println(annotation);
		}
		System.out.println();

		if (!testClass.isAnnotationPresent(ControlledObject.class)) {
			System.out.println("no annotation");
		} else {
			System.out.println("Class " + testClass.getName() + " is annotated ;\nname  -  "
					+ testClass.getAnnotation(ControlledObject.class));
		}

	}

}
