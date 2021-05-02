package week3day1.assignments;

/*
POLYMORPHISM
Assignment 1:
Create class Calculator with below methods
- 2 methods for add, 1 method with 2 int args , 1 method with 3 int args
- 2 methods for multiply, 1 method with 2 int args, 1method with 1 int and 1 double args
- 2 methods for subtract, 1 method with 2 int args , 1 method with 2 double args
- 2 methods to divide , 1 method with 2 int args, one to divide one double number with one int
create object for the Calculator class and execute all the methods */

public class Calculator {

	public static void main(String[] args) {
		
		Calculator myobj = new Calculator();
		myobj.add(5, 5);
		myobj.add(12, 13, 15);
		myobj.sub(10.5, 5.5);
		myobj.sub(20, 10);
		myobj.multiply(4, 4);
		myobj.multiply(18, 12);
		myobj.divide(10, 2);
		myobj.divide(1000, 50);
		
		

	}
	
	
	
	public void add(int i, int j)
	{
		int sum = i + j;
		System.out.println("The sum is"+ " " + sum );
	}
	
	public void add(int a, int b, int c)
	{
		int sum1 = a + b+c;
		System.out.println("The sum is" + " "+sum1);
	}
	
	public void multiply(int k, int h)
	{
		int multi = k * h;
		System.out.println("The multiplied result is" +" "+ multi );
	}
	
	public void multiply(int g, long f)
	{
		long multi1 = g*f;
		System.out.println("The multiplied result is"+ " " + multi1 );
	}
	
	public void sub(int i, int j)
	{
		int sub = i - j;
		System.out.println("The sub is" +" "+ sub );
	}
	
	public void sub(double i, double j)
	{
		double sub1 = i - j;
		System.out.println("The subtraction1 is" +" "+ sub1 );
	}
	public void divide(int i, int j)
	{
		int div = i / j;
		System.out.println("The div is" +" "+ div );
	}
	
	public void divide(long i, int j)
	{
		long div1 = i / j;
		System.out.println("The div is" +" "+ div1 );
	}
	
	}



