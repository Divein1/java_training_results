package by.java.training.chp;

public class Student {
	private int groups = 0;

	public Student() {
		this("undef");
	}

	public Student(String name) {
		this.name = name;
	}

	String name;
	double math;
	int bio;
	int pe;
	double chem;
	double phys;

	public void setMark(double mark, Discipline d) {
		groups += 1;
		switch (d) {
		case BIOLOGY:
			bio = (int) mark;
			break;
		case CHEMISTRY:
			chem = mark;
			break;
		case MATH:
			math = mark;
			break;
		case PE:
			pe = (int) mark;
			break;
		default:
			phys = mark;
			break;
		}

	}

	public double getMark(Discipline d) {
		switch (d) {
		case BIOLOGY:
			return bio;
		case CHEMISTRY:
			return chem;
		case MATH:
			return math;
		case PE:
			return pe;
		default:
			return phys;
		}
	}

	public void hasGroups() {
		if (groups == 0) {
			System.out.println("Student" + name + "has no groups.");
		} else {

			System.out.print("Student " + name + " has " + groups + " gr. Including:");
			if (math != 0) {
				System.out.print(" Math.");
			}
			if (bio != 0) {
				System.out.print(" Biology.");
			}
			if (pe != 0) {
				System.out.print(" Physical Education.");
			}
			if (chem != 0) {
				System.out.print(" Chemistry.");
			}
			if (phys != 0) {
				System.out.print(" Physics.");
			}
		}

	}

	@Override
	public String toString() {

		return "\nStudent name: " + name + " 		Marks: Math=" + math + ", Biology=" + bio + ", PE=" + pe
				+ ", Chemistry=" + chem + ", Physic=" + phys;
	}

}
