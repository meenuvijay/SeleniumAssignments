package week3day1.assignments;

public class Student extends Department {

	public void studentName() {
		System.out.println("studentName");

	}

	public void studentDept() {
		System.out.println("studentDept");

	}

	public void studentId() {
		System.out.println("studentId");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student st1 = new Student();

		st1.collegeCode();
		st1.collegeName();
		st1.collegeName();
		st1.deptName();
		st1.studentId();
		st1.studentDept();
		st1.studentName();
	}

}
