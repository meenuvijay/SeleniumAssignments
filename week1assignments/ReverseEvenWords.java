package week1assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "I am a software tester";

		String[] input = test.split(" ");
		String output = " ";

		for (int i = 0; i <= input.length - 1; i++) {
			if (i % 2 != 0) {

				// String str = input[i];
				// char[] rev = str.toCharArray();

				char[] rev = input[i].toCharArray();
				// System.out.println(str.length());

				String revout = " ";

				for (int j = input[i].length() - 1; j >= 0; j--)

				{

					revout = revout + rev[j];

				}

				output = output + revout;

			}

			else {
				output = output + " " + input[i];
			}
		}
		System.out.print("The reverse even words :" + output);
	}
}
