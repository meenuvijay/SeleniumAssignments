package week1assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		 * 
		 * Declare String Input as Follow
		 * 
		 * String test = "changeme";
		 * 
		 * a) Convert the String to character array
		 * 
		 * b) Traverse through each character (using loop)
		 * 
		 * c)find the odd index within the loop (use mod operator)
		 * 
		 * d)within the loop, change the character to uppercase, if the index is odd
		 * else don't change
		 * 
		 */

		String test = "changeme";
		String output = "";

		char[] input = test.toCharArray();
		char c1;

		for (int i = 0; i <= input.length - 1; i++)

		{

			if (i % 2 != 0) {

				// System.out.print(Character.toUpperCase(input[i]));
				c1 = Character.toUpperCase(input[i]);
				output = output + c1;

			} else {

				c1 = input[i];
				output = output + c1;

			}

		}
		System.out.print("The changeoddindex touppercase :" + output);

	}

}
