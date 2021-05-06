package week3day2.assignments1;

import java.util.Arrays;
//import java.util.Collections;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		  
		  
		  Arrays.sort(input);
		  System.out.println("The length of Array"+ " " + input.length);
		  System.out.println("The Expected Reverse Array");
		  for( int i = input.length-1; i>=0 ; i--)
		  {
			  String j = input[i];
			   System.out.println(j);
		  }
		  
		  
		  

	}

}
