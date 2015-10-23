package by.java.training.chp;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

enum Discipline {
	MATH, BIOLOGY, PE, CHEMISTRY, PHYSICS
}

public class Group {

	public void createGroup(Collection<Student> c, Discipline d) {
		for (Iterator<Student> iterator = c.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if ((int) (Math.random() * 2) == 1) { // 50% to set student the
													// mark / set to group
				student.setMark((int) (Math.random() * 10) + 1, d);
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

	public void getStudStatus(List<Student> c, int id, Discipline d) {
		double average = 0;
		int count = 0;
		if (c.get(id).getMark(d) == 0) {
			System.out.println(c.get(id).getName() + " is not in group " + d);
			return;
		}
		for (Iterator<Student> iterator = c.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if (student.getMark(d) != 0) {
				average += student.getMark(d);
				count++;
			}
		}
		average = average / count;
		average = c.get(id).getMark(d) - average;
		String result = String.format("%.1f", Math.abs(average));
		if (average < 0) {
			System.out.println(
					"Marks of " + c.get(id).getName() + " are " + result + " points worse than average in group " + d);
		} else if (average > 0) {
			System.out.println(
					"Marks of " + c.get(id).getName() + " are " + result + " points better than average in group " + d);
		} else
			System.out.println("Marks of " + c.get(id).getName() + " are group average.");

	}

}
