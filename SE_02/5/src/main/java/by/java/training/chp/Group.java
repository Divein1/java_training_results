package by.java.training.chp;

import java.util.Collection;
import java.util.Iterator;

enum Discipline {
	MATH, BIOLOGY, PE, CHEMISTRY, PHYSICS
}

public class Group {


	public void createGroup(Collection<Student> c, Discipline discipline) {
		for (Iterator<Student> iterator = c.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if ((int) (Math.random() * 2) == 1) { // 50% to set student the
													// mark/ set to group
				student.setMark((int) (Math.random() * 10)+1, discipline);
			}

		}

	}

	public void showGroup(Collection<Student> c, Discipline discipline) {
		for (Iterator<Student> iterator = c.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if (student.getMark(discipline) != 0)
				System.out.print(student);

		}
	}

}
