package week3day1.assignments;


public class Desktop1 implements Hardware, Software {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Desktop1 myobj =  new Desktop1();
		myobj.hardwareResources();
		myobj.softwareResources();


	}

	public static void desktopModel() {
		System.out.println("desktopModel");
	}

	public void softwareResources() {
		System.out.println("softwareResources");

	}

	public void hardwareResources() {
		System.out.println("hardwareResources");
	}

}
