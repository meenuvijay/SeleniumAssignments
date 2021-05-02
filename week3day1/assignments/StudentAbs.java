package week3day1.assignments;

public  class StudentAbs {
	
	public  void getStudentInfo(int id)
	{
		System.out.println("The Student ID" + " " +    id);
	}
	
	public  void getStudentInfo(int id, String name)
	{
		System.out.println("The Student ID & Name :" + id+ " " + name);
	}
	
	
	public  void getStudentInfo( String email, long phoneNumber)
	{
		System.out.println("The Student Phone no & Email :" + phoneNumber + " " + email );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentAbs stu1 = new StudentAbs();
		stu1.getStudentInfo(978);
		stu1.getStudentInfo(978, "TestLeaf");
		stu1.getStudentInfo("test@gmail.com", 123456798);
		
	}
	
}
