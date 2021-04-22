package week1assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pseudo code
		 * 
		 * a) Use the declared String text as input String text =
		 * "We learn java basics as part of java sessions in java week1"; 
		 * b) Initialize an integer variable as count
		 *  c) Split the String into array and iterate over it 
		 *  d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. f) if the count > 1 then
		 * replace the word as ""
		 * 
		 * g) Displaying the String without duplicate words
		 */

		String text = "We learn java basics as part of java sessions in java week1";

		int count = 0;

		String str = "";
		int k = 0;

		String[] output1 = new String[10];

		String[] input = text.split(" ");

		for (int i = 0; i < input.length; i++)
		{
			str = input[i];

			if (i == 0) {
				output1[k] = str;

				k++;
			} 
			
			else {
				count = 0;

				for (int j = 1; j < output1.length; j++)

				{
					if (str.equals(output1[j]))
						count = 1;

				}
				if (count == 0)
				{
					output1[k] = str;
					k++;
				}
			}
		}

		for (String str1 : output1)
		{
			System.out.print(str1 + " ");
		}
	}

}
