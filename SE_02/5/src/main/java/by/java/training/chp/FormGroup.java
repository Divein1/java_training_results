package by.java.training.chp;

import java.util.ArrayList;
import java.util.List;

public class FormGroup {

	public static void main(String[] args) {
		List<Student> StudentList = new ArrayList<Student>();
		StudentList.add(new Student("Todd Eden"));
		StudentList.add(new Student("Clinton Geoff"));
		StudentList.add(new Student("Lenox Jimmie"));
		StudentList.add(new Student("Ryley Joe"));
		StudentList.add(new Student("Adolph Cam"));
		StudentList.add(new Student("Pierce Len"));
		StudentList.add(new Student("Connor Bernard"));
		StudentList.add(new Student("Roland Randy"));
		StudentList.add(new Student("David Eck"));

		Group group = new Group();
		group.createGroup(StudentList, Discipline.BIOLOGY);
		group.createGroup(StudentList, Discipline.CHEMISTRY);
		group.createGroup(StudentList, Discipline.MATHEMATICS);
		group.createGroup(StudentList, Discipline.PE);
		group.createGroup(StudentList, Discipline.PHYSICS);

		// System.out.println(StudentList);
		// System.out.println();

		System.out.print("BIOLOGY GROUP");
		group.showGroup(StudentList, Discipline.BIOLOGY);
		System.out.println();

		System.out.print("PHYSICS GROUP");
		group.showGroup(StudentList, Discipline.PHYSICS);

		System.out.println();
		System.out.println();
		for (int i = 0; i < StudentList.size(); i++) {
			StudentList.get(i).hasGroups();
		}

		System.out.println();
		group.getStudStatus(StudentList, 0, Discipline.BIOLOGY);
		group.getStudStatus(StudentList, 0, Discipline.PHYSICS);
		group.getStudStatus(StudentList, 0, Discipline.MATHEMATICS);

	}

}
